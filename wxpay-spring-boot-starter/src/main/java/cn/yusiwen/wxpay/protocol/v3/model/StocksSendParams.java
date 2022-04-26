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
package cn.yusiwen.wxpay.protocol.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 代金券发放接口请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class StocksSendParams {
    /**
     * 批次号 必须为代金券（全场券或单品券）批次号，不支持立减与折扣。
     */
    private String stockId;
    /**
     * 用户openId 该openId需要与接口传入中的appId有对应关系。
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 商户单据号
     */
    private String outRequestNo;
    /**
     * 公众账号ID
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 创建批次的商户号
     */
    @JsonProperty("stock_creator_mchid")
    private String stockCreatorMchId;
    /**
     * 指定面额发券场景，券面额，其他场景不需要填，单位：分。 校验规则：仅在发券时指定面额及门槛的场景才生效，常规发券场景请勿传入该信息。
     */
    private Long couponValue;
    /**
     * 指定面额发券批次门槛，其他场景不需要，单位：分。 校验规则：仅在发券时指定面额及门槛的场景才生效，常规发券场景请勿传入该信息。
     */
    private Long couponMinimum;
}
