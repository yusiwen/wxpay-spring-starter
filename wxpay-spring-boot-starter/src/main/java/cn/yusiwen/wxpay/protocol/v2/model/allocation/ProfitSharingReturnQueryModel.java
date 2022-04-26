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
package cn.yusiwen.wxpay.protocol.v2.model.allocation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.yusiwen.wxpay.protocol.v2.model.BaseModel;

/**
 * The type Profit sharing return query model.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfitSharingReturnQueryModel extends BaseModel {

    /**
     * 商户号.
     * <p>
     * 微信支付分配的商户号
     */
    @JsonProperty("mchid")
    private String mchId;

    /**
     * 公众账号ID.
     * <p>
     * 微信分配的公众账号ID
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 微信分账订单号.
     * <p>
     * 原发起分账请求时，微信返回的微信分账单号，与商户分账单号一一对应。 微信分账单号与商户分账单号二选一填写
     */
    private String orderId;

    /**
     * 商户分账单号.
     * <p>
     * 原发起分账请求时使用的商户系统内部的分账单号。 微信分账单号与商户分账单号二选一填写
     */
    private String outOrderNo;

    /**
     * 商户回退单号.
     * <p>
     * 调用回退接口提供的商户系统内部的回退单号
     */
    private String outReturnNo;

}
