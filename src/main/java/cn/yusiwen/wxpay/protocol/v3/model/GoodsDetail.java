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

import lombok.Data;

/**
 * 商户下单接口传的单品信息
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class GoodsDetail {

    /**
     * 优惠金额，单位【分】
     */
    private Long discountAmount;
    /**
     * 单品券创建时录入的单品编码。
     */
    private String goodsId;
    /**
     * 单品单价
     */
    private Long price;
    /**
     * 单品数量
     */
    private Long quantity;

}
