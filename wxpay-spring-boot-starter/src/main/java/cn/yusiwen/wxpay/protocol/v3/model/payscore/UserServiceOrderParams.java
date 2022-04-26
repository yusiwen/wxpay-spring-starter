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
package cn.yusiwen.wxpay.protocol.v3.model.payscore;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 创建支付分订单请求参数.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class UserServiceOrderParams {

    /**
     * 商户服务订单号，必填
     * <p>
     * 商户系统内部服务订单号（不是交易单号），要求此参数只能由数字、大小写字母_-|*组成，且在同一个商户号下唯一。详见[商户订单号]。
     */
    private String outOrderNo;
    /**
     * 与传入的商户号建立了支付绑定关系的appId，必填
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 服务ID，必填
     * <p>
     * 该服务ID有本接口对应产品的权限。
     */
    private String serviceId;
    /**
     * 服务信息，必填
     * <p>
     * 用于介绍本订单所提供的服务 ，当参数长度超过20个字符时，报错处理。
     */
    private String serviceIntroduction;
    /**
     * 后付费项目，选填
     */
    private List<PostPayment> postPayments;
    /**
     * 后付费商户优惠，选填
     */
    private List<PostDiscount> postDiscounts;
    /**
     * 服务时间段，必填
     */
    private TimeRange timeRange;
    /**
     * 服务位置，选填
     */
    private Location location;
    /**
     * 订单风险金，必填
     */
    private RiskFund riskFund;
    /**
     * 商户数据包，选填
     * <p>
     * 商户数据包可存放本订单所需信息，需要先urlencode后传入。 当商户数据包总长度超出256字符时，报错处理。
     */
    private String attach;
    /**
     * 商户回调地址，必填
     */
    private String notifyUrl;
    /**
     * 微信用户在商户对应appId下的唯一标识，条件选填
     * <p>
     * 免确认订单：必填 需确认订单：不填
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 是否需要用户确认，选填
     * <p>
     * false：免确认订单 true：需确认订单 默认值true
     */
    private Boolean needUserConfirm = Boolean.TRUE;
}
