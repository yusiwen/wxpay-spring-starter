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
package cn.yusiwen.wxpay.protocol.enumeration;

/**
 * 商家券核销方式
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public enum BusiFavorUseMethod {

    /**
     * 线下滴码核销，点击券“立即使用”跳转展示券二维码详情。
     *
     * @since 1.0.0.RELEASE
     */
    OFF_LINE,
    /**
     * 线上小程序核销，点击券“立即使用”跳转至配置的商家小程序（需要添加小程序appId和path）。
     *
     * @since 1.0.0.RELEASE
     */
    MINI_PROGRAMS,
    /**
     * 微信支付付款码核销，点击券“立即使用”跳转至微信支付钱包付款码。
     *
     * @since 1.0.0.RELEASE
     */
    PAYMENT_CODE,
    /**
     * 用户自助核销，点击券“立即使用”跳转至用户自助操作核销界面（当前暂不支持用户自助核销）。
     *
     * @since 1.0.0.RELEASE
     */
    SELF_CONSUME;
}
