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

package cn.yusiwen.wxpay.protocol.v3.model.profitsharing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 服务商-查询分账回退结果API-请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class PartnerQueryReturnOrderParams {
    /**
     * 子商户号，选填
     */
    @JsonProperty("sub_mchid")
    private String subMchId;
    /**
     * 商户回退单号，必填
     */
    private String outReturnNo;
    /**
     * 商户分账单号，必填
     */
    private String outOrderNo;
}
