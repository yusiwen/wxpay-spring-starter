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
package cn.yusiwen.wxpay.protocol.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TransferModel extends BaseModel {
    /**
     * Merchant app ID
     */
    @JsonProperty("mch_appid")
    private String mchAppId;
    /**
     * Merchant ID
     */
    @JsonProperty("mchid")
    private String mchId;
    /**
     * Device information
     */
    private String deviceInfo;
    /**
     * Partner trade No.
     */
    private String partnerTradeNo;
    /**
     * Open ID
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * Check name
     */
    private String checkName;
    /**
     * Reuser name
     */
    private String reUserName;
    /**
     * Amount
     */
    private String amount;
    /**
     * Description
     */
    private String desc;
    /**
     * SP bill create IP
     */
    private String spBillCreateIp;
}
