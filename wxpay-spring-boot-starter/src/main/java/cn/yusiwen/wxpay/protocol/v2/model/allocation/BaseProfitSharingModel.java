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
 * The type Base profit sharing model.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseProfitSharingModel extends BaseModel {

    /**
     * 商户号.
     * <p>
     * 微信支付分配的商户号
     */
    @JsonProperty("mchid")
    private String mchId;
    /**
     * App ID
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * Transaction ID
     */
    private String transactionId;
    /**
     * Out order ID
     */
    private String outOrderNo;

}
