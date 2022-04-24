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

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 单次分账请求按照传入的分账接收方账号和资金进行分账，同时会将订单剩余的待分账金额解冻给本商户。 故操作成功后，订单不能再进行分账，也不能进行分账完结。
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfitSharingModel extends BaseProfitSharingModel {

    /**
     * 分账接收方列表，不超过50个json对象，不能设置分账方作为分账接受方
     */
    private List<Receiver> receivers;

}
