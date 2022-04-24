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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RedpackModel extends BaseModel {

    /**
     * Wechat app ID
     */
    private String appId;
    /**
     * Merchant ID
     */
    private String mchId;
    /**
     * Merchant bill No.
     */
    private String mchBillno;
    /**
     * Send name
     */
    private String sendName;
    /**
     * Reopen ID
     */
    private String reOpenid;
    /**
     * Total amount
     */
    private String totalAmount;
    /**
     * Total number
     */
    private String totalNum;
    /**
     * Wishing
     */
    private String wishing;
    /**
     * Client IP
     */
    private String clientIp;
    /**
     * Act name
     */
    private String actName;
    /**
     * Remark
     */
    private String remark;
    /**
     * Scene ID
     */
    private String sceneId;
    /**
     * Risk information
     */
    private String riskInfo;

}
