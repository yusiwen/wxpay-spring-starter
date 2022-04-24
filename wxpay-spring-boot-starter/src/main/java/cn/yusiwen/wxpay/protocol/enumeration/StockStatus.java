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
 * 代金券批次状态.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public enum StockStatus {
    /**
     * Unactivated stock status.
     *
     * @since 1.0.0.RELEASE
     */
    UNACTIVATED("unactivated", "未激活"),
    /**
     * Audit stock status.
     *
     * @since 1.0.0.RELEASE
     */
    AUDIT("audit", "审核中"),
    /**
     * Running stock status.
     *
     * @since 1.0.0.RELEASE
     */
    RUNNING("running", "运行中"),
    /**
     * Stoped stock status.
     *
     * @since 1.0.0.RELEASE
     */
    STOPED("stoped", "已停止"),
    /**
     * Paused stock status.
     *
     * @since 1.0.0.RELEASE
     */
    PAUSED("paused", "暂停发放");

    /**
     * Value
     */
    private final String value;
    /**
     * Description
     */
    private final String description;

    StockStatus(String value, String description) {
        this.value = value;
        this.description = description;
    }

    /**
     * Value string.
     *
     * @return the string
     * @since 1.0.0.RELEASE
     */
    public String value() {
        return this.value;
    }

    /**
     * Description string.
     *
     * @return the string
     * @since 1.0.0.RELEASE
     */
    public String description() {
        return this.description;
    }
}
