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
 * 退款状态.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public enum RefundStatus {
    /**
     * 退款异常.
     *
     * @since 1.0.0.RELEASE
     */
    ABNORMAL,

    /**
     * 退款关闭.
     *
     * @since 1.0.0.RELEASE
     */
    CLOSED,
    /**
     * 退款成功.
     *
     * @since 1.0.0.RELEASE
     */
    SUCCESS

}
