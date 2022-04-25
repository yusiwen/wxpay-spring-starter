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

package cn.yusiwen.wxpay.protocol.v3.model.partner;

import lombok.Data;

/**
 * 服务商模式-关闭订单请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class CloseTransParams {
    /**
     * 子商户号
     */
    private String subMchId;
    /**
     * 商户订单号
     */
    private String outTradeNo;
}
