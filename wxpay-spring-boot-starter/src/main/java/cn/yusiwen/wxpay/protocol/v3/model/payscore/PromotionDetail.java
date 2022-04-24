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

import lombok.Data;

/**
 * 微信支付分支付成功回调，优惠功能
 *
 * 注：针对2020年5月27日10:00:00以后完结的订单生效
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class PromotionDetail {

    /**
     * The Amount.
     */
    private Long amount;
    /**
     * The Coupon id.
     */
    private String couponId;
    /**
     * The Currency.
     */
    private String currency;
    /**
     * The Goods detail.
     */
    private List<GoodsDetail> goodsDetail;
    /**
     * The Merchant contribute.
     */
    private Long merchantContribute;
    /**
     * The Name.
     */
    private String name;
    /**
     * The Other contribute.
     */
    private Long otherContribute;
    /**
     * The Scope.
     */
    private String scope;
    /**
     * The Stock id.
     */
    private String stockId;
    /**
     * The Type.
     */
    private String type;
    /**
     * The Wechatpay contribute.
     */
    private Long wechatpayContribute;

    /**
     * The type Goods detail.
     */
    @Data
    public static class GoodsDetail {

        /**
         * The Discount amount.
         */
        private Long discountAmount;
        /**
         * The Goods id.
         */
        private String goodsId;
        /**
         * The Goods remark.
         */
        private String goodsRemark;
        /**
         * The Quantity.
         */
        private Long quantity;
        /**
         * The Unit price.
         */
        private Long unitPrice;

    }
}
