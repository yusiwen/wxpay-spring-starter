/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cn.yusiwen.wxpay.protocol.v3;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import cn.yusiwen.wxpay.WechatPayProperties;
import cn.yusiwen.wxpay.protocol.enumeration.WeChatServer;
import cn.yusiwen.wxpay.protocol.enumeration.WechatPayV3Type;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerAddReceiversParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerDelReceiversParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerProfitSharingOrder;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerQueryOrderParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerQueryReturnOrderParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerReturnOrdersParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.PartnerUnfreezeParams;
import cn.yusiwen.wxpay.protocol.v3.model.profitsharing.Receiver;

/**
 * 微信V3服务商分账
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public class WechatPartnerProfitsharingApi extends AbstractApi {

    /**
     * Instantiates a new Abstract api.
     *
     * @param wechatPayClient
     *            the wechat pay client
     * @param tenantId
     *            the tenant id
     */
    public WechatPartnerProfitsharingApi(WechatPayClient wechatPayClient, String tenantId) {
        super(wechatPayClient, tenantId);
    }

    /**
     * 请求分账API
     * <p>
     * 微信订单支付成功后，商户发起分账请求，将结算后的资金分到分账接收方
     * <p>
     * 注意：
     * <ul>
     * <li>对同一笔订单最多能发起20次分账请求，每次请求最多分给50个接收方</li>
     * <li>此接口采用异步处理模式，即在接收到商户请求后，优先受理请求再异步处理，最终的分账结果可以通过查询分账接口获取</li>
     * </ul>
     *
     * @param profitSharingOrder
     *            the profit sharing order
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> profitsharingOrders(PartnerProfitSharingOrder profitSharingOrder) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_ORDERS, profitSharingOrder)
                .function((wechatPayV3Type, params) -> {
                    WechatPayProperties.V3 v3 = this.wechatMetaBean().getV3();
                    SignatureProvider signatureProvider = this.client().signatureProvider();
                    X509WechatCertificateInfo certificate = signatureProvider
                            .getCertificate(this.wechatMetaBean().getTenantId());
                    final X509Certificate x509Certificate = certificate.getX509Certificate();
                    params.setAppId(v3.getAppId());
                    List<Receiver> receivers = params.getReceivers();
                    if (!CollectionUtils.isEmpty(receivers)) {
                        List<Receiver> encrypted = receivers.stream().peek(receiversItem -> {
                            String name = receiversItem.getName();
                            if (StringUtils.hasText(name)) {
                                String encryptedName = signatureProvider.encryptRequestMessage(name, x509Certificate);
                                receiversItem.setName(encryptedName);
                            }
                        }).collect(Collectors.toList());
                        params.setReceivers(encrypted);
                    }
                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().toUri();
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add("Wechatpay-Serial", certificate.getWechatPaySerial());
                    return post(uri, params, httpHeaders);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 查询分账结果API
     * <p>
     * 发起分账请求后，可调用此接口查询分账结果
     * <p>
     * 注意：
     * <ul>
     * <li>发起解冻剩余资金请求后，可调用此接口查询解冻剩余资金的结果</li>
     * </ul>
     *
     * @param queryOrderParams
     *            the query order params
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> queryProfitsharingOrder(PartnerQueryOrderParams queryOrderParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_ORDERS_RESULT, queryOrderParams)
                .function((wechatPayV3Type, params) -> {
                    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
                    queryParams.add("transaction_id", params.getTransactionId());
                    Optional.ofNullable(params.getSubMchId())
                            .ifPresent(mchId -> queryParams.add("sub_mchid", params.getSubMchId()));
                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA))
                            .queryParams(queryParams).build().expand(params.getOutOrderNo()).toUri();
                    return get(uri);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 请求分账回退API
     * <p>
     * 如果订单已经分账，在退款时，可以先调此接口，将已分账的资金从分账接收方的账户回退给分账方，再发起退款
     * <p>
     * 注意：
     * <ul>
     * <li>分账回退以原分账单为依据，支持多次回退，申请回退总金额不能超过原分账单分给该接收方的金额</li>
     * <li>此接口采用同步处理模式，即在接收到商户请求后，会实时返回处理结果</li>
     * <li>对同一笔分账单最多能发起20次分账回退请求</li>
     * <li>退款和分账回退没有耦合，分账回退可以先于退款请求，也可以后于退款请求</li>
     * <li>此功能需要接收方在商户平台-交易中心-分账-分账接收设置下，开启同意分账回退后，才能使用</li>
     * </ul>
     *
     * @param returnOrdersParams
     *            the return orders params
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> returnOrders(PartnerReturnOrdersParams returnOrdersParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_RETURN_ORDERS, returnOrdersParams)
                .function((wechatPayV3Type, params) -> {

                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().toUri();
                    return post(uri, params);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 查询分账回退结果API
     * <p>
     * 商户需要核实回退结果，可调用此接口查询回退结果
     * <p>
     * 注意：
     * <ul>
     * <li>如果分账回退接口返回状态为处理中，可调用此接口查询回退结果</li>
     * </ul>
     *
     * @param queryReturnOrderParams
     *            the query return order params
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> queryReturnOrders(PartnerQueryReturnOrderParams queryReturnOrderParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_RETURN_ORDERS_RESULT, queryReturnOrderParams)
                .function((wechatPayV3Type, params) -> {
                    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
                    queryParams.add("out_order_no", params.getOutOrderNo());
                    Optional.ofNullable(params.getSubMchId())
                            .ifPresent(mchId -> queryParams.add("sub_mchid", params.getSubMchId()));
                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA))
                            .queryParams(queryParams).build().expand(params.getOutReturnNo()).toUri();
                    return get(uri);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 解冻剩余资金API
     * <p>
     * 不需要进行分账的订单，可直接调用本接口将订单的金额全部解冻给特约商户
     * <p>
     * 注意：
     * <ul>
     * <li>调用分账接口后，需要解冻剩余资金时，调用本接口将剩余的分账金额全部解冻给特约商户</li>
     * <li>此接口采用异步处理模式，即在接收到商户请求后，优先受理请求再异步处理，最终的分账结果可以通过查询分账接口获取</li>
     * </ul>
     *
     * @param unfreezeParams
     *            the unfreeze params
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> unfreeze(PartnerUnfreezeParams unfreezeParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_ORDERS_UNFREEZE, unfreezeParams)
                .function((wechatPayV3Type, params) -> {

                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().toUri();
                    return post(uri, params);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 查询剩余待分金额API
     * <p>
     * 可调用此接口查询订单剩余待分金额
     *
     * @param transactionId
     *            the transaction id
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> queryAmounts(String transactionId) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_AMOUNTS, transactionId).function((wechatPayV3Type, id) -> {

            URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().expand(id)
                    .toUri();
            return get(uri);
        }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * （服务商）查询剩余待分金额API
     * <p>
     * 可调用此接口查询订单剩余待分金额
     *
     * @param subMchId
     *            the sub merchant ID
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> queryMchConfigs(String subMchId) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_MCH_CONFIG, subMchId).function((wechatPayV3Type, id) -> {

            URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().expand(id)
                    .toUri();
            return get(uri);
        }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 添加分账接收方API
     * <p>
     * 商户发起添加分账接收方请求，建立分账接收方列表。后续可通过发起分账请求，将分账方商户结算后的资金，分到该分账接收方
     *
     * @param addReceiversParams
     *            the add receivers params
     * @return wechat response entity
     */
    public WechatResponseEntity<ObjectNode> addReceivers(PartnerAddReceiversParams addReceiversParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_RECEIVERS_ADD, addReceiversParams)
                .function((wechatPayV3Type, params) -> {
                    WechatPayProperties.V3 v3 = this.wechatMetaBean().getV3();
                    SignatureProvider signatureProvider = this.client().signatureProvider();
                    X509WechatCertificateInfo certificate = signatureProvider
                            .getCertificate(this.wechatMetaBean().getTenantId());
                    final X509Certificate x509Certificate = certificate.getX509Certificate();
                    params.setAppId(v3.getAppId());
                    String name = params.getName();
                    if (StringUtils.hasText(name)) {
                        String encryptedName = signatureProvider.encryptRequestMessage(name, x509Certificate);
                        params.setName(encryptedName);
                    }
                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().toUri();
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add("Wechatpay-Serial", certificate.getWechatPaySerial());
                    return post(uri, params, httpHeaders);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }

    /**
     * 删除分账接收方API
     * <p>
     * 商户发起删除分账接收方请求。删除后，不支持将分账方商户结算后的资金，分到该分账接收方
     *
     * @param delReceiversParams
     *            the del receivers params
     * @return the wechat response entity
     */
    public WechatResponseEntity<ObjectNode> deleteReceivers(PartnerDelReceiversParams delReceiversParams) {
        WechatResponseEntity<ObjectNode> wechatResponseEntity = new WechatResponseEntity<>();
        this.client().withType(WechatPayV3Type.PROFITSHARING_RECEIVERS_DELETE, delReceiversParams)
                .function((wechatPayV3Type, params) -> {
                    WechatPayProperties.V3 v3 = this.wechatMetaBean().getV3();
                    params.setAppId(v3.getAppId());
                    URI uri = UriComponentsBuilder.fromHttpUrl(wechatPayV3Type.uri(WeChatServer.CHINA)).build().toUri();
                    return post(uri, params);
                }).consumer(wechatResponseEntity::convert).request();
        return wechatResponseEntity;
    }
}
