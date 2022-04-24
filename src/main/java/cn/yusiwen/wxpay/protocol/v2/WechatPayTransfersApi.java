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
package cn.yusiwen.wxpay.protocol.v2;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.HttpMethod;

import cn.yusiwen.wxpay.WechatPayProperties;
import cn.yusiwen.wxpay.protocol.v2.model.TransferInfoModel;
import cn.yusiwen.wxpay.protocol.v2.model.TransferModel;

/**
 * 企业付款
 * <p>
 * TODO 暂时没有企业付款到银行卡
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public class WechatPayTransfersApi {
    /**
     * WechatV2Client
     */
    private final WechatV2Client wechatV2Client;

    /**
     * Instantiates a new Wechat pay transfers api.
     *
     * @param wechatV2Client
     *            the wechat v 2 client
     */
    public WechatPayTransfersApi(WechatV2Client wechatV2Client) {
        this.wechatV2Client = wechatV2Client;
    }

    /**
     * 企业付款到零钱
     *
     * @param transferModel
     *            the transfer model
     * @return json node
     */
    public JsonNode transfer(TransferModel transferModel) {
        WechatPayProperties.V3 v3 = wechatV2Client.getWechatMetaBean().getV3();
        transferModel.setMchAppId(v3.getAppId());
        transferModel.setMchId(v3.getMchId());
        return wechatV2Client.wechatPayRequest(transferModel, HttpMethod.POST,
                "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");
    }

    /**
     * 查询企业付款
     *
     * @param transferModel
     *            the transfer model
     * @return the json node
     */
    public JsonNode transferInfo(TransferInfoModel transferModel) {
        WechatPayProperties.V3 v3 = wechatV2Client.getWechatMetaBean().getV3();
        transferModel.setAppId(v3.getAppId());
        transferModel.setMchId(v3.getMchId());
        return wechatV2Client.wechatPayRequest(transferModel, HttpMethod.POST,
                "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo");
    }
}
