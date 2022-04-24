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
 * 未完成约定原因
 * <p>
 * 当订单守约状态为{@link ContractStatus#UNFINISHED}，返回此字段
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public enum UnfinishedReason {
    /**
     * 到期未完成约
     */
    DUE_TO_QUIT,
    /**
     * 提前退出约定
     */
    EARLY_QUIT
}
