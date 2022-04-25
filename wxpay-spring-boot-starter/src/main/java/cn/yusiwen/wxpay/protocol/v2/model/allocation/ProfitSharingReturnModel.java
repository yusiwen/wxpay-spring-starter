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

import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.yusiwen.wxpay.protocol.v2.model.BaseModel;

/**
 * The type Profit sharing return model.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfitSharingReturnModel extends BaseModel {

    /**
     * 商户号.
     * <p>
     * 微信支付分配的商户号
     */
    private String mchId;

    /**
     * 公众账号ID.
     * <p>
     * 微信分配的公众账号ID
     */
    private String appId;
    /**
     * Order ID
     */
    private String orderId;
    /**
     * Out order No.
     */
    private String outOrderNo;
    /**
     * Out return No.
     */
    private String outReturnNo;
    /**
     * Return account type
     */
    private String returnAccountType;
    /**
     * Return account
     */
    private String returnAccount;
    /**
     * Return amount
     */
    private String returnAmount;
    /**
     * Description
     */
    private String description;

}
