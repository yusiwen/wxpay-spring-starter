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

import java.time.LocalDate;

import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.FundFlowAccountType;
import cn.yusiwen.wxpay.protocol.enumeration.TarType;

/**
 * 申请资金账单请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class FundFlowBillParams {
    /**
     * 账单日期，必传。
     * <p>
     * 格式YYYY-MM-DD，仅支持三个月内的账单下载申请。
     */
    private LocalDate billDate;
    /**
     * 资金账户类型,不填则默认值为{@link FundFlowAccountType#BASIC}
     *
     * @see FundFlowAccountType
     */
    private FundFlowAccountType accountType;
    /**
     * 压缩类型，不填默认值为数据流
     *
     * @see TarType
     */
    private TarType tarType;
}
