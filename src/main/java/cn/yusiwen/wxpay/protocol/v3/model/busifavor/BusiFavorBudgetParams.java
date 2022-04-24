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
package cn.yusiwen.wxpay.protocol.v3.model.busifavor;

import lombok.Data;

/**
 * 修改商家券批次预算API请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class BusiFavorBudgetParams {

    /**
     * 批次号
     */
    private String stockId;
    /**
     * 目标批次最大发放个数，同{@link #targetMaxCouponsByDay}二选一
     */
    private Integer targetMaxCoupons;
    /**
     * 目标单天发放上限个数，同{@link #targetMaxCoupons}二选一
     */
    private Integer targetMaxCouponsByDay;
    /**
     * 当前批次最大发放个数，当传入{@link #targetMaxCoupons}大于0时，必传
     */
    private Integer currentMaxCoupons;
    /**
     * 当前单天发放上限个数 ，当传入{@link #targetMaxCouponsByDay}大于0时，必填
     */
    private Integer currentMaxCouponsByDay;
    /**
     * 修改预算请求单据号
     */
    private String modifyBudgetRequestNo;
}
