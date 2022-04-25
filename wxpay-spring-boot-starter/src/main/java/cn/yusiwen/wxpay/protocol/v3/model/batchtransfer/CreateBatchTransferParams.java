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
package cn.yusiwen.wxpay.protocol.v3.model.batchtransfer;

import java.util.List;

import lombok.Data;

/**
 * 批量转账到零钱API请求参数.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class CreateBatchTransferParams {

    /**
     * 直连商户的appId
     */
    private String appId;
    /**
     * 商家批次单号
     */
    private String outBatchNo;
    /**
     * 批次名称
     */
    private String batchName;
    /**
     * 批次备注
     */
    private String batchRemark;
    /**
     * 发起批量转账的明细列表，最多三千笔
     */
    private List<TransferDetailListItem> transferDetailList;
    /**
     * 转账总金额,单位为“分”。转账总金额必须与批次内所有明细转账金额之和保持一致，否则无法发起转账操作
     */
    private Integer totalAmount;
    /**
     * 转账总笔数,一个转账批次单最多发起三千笔转账。转账总笔数必须与批次内所有明细之和保持一致，否则无法发起转账操作
     */
    private Integer totalNum;

    /**
     * 转账明细.
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    @Data
    public static class TransferDetailListItem {

        /**
         * 商家明细单号
         */
        private String outDetailNo;
        /**
         * 转账金额，单位为分
         */
        private Integer transferAmount;
        /**
         * 单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符
         */
        private String transferRemark;
        /**
         * 用户在直连商户appId下的唯一标识
         */
        private String openId;
        /**
         * 收款用户姓名
         */
        private String userName;
        /**
         * 收款用户身份证
         */
        private String userIdCard;
    }
}
