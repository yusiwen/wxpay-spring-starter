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

/**
 * The enum Relation type.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
public enum RelationType {

    /**
     * Service provider relation type.
     */
    SERVICE_PROVIDER,
    /**
     * Store relation type.
     */
    STORE,
    /**
     * Staff relation type.
     */
    STAFF,
    /**
     * Store owner relation type.
     */
    STORE_OWNER,
    /**
     * Partner relation type.
     */
    PARTNER,
    /**
     * Headquarter relation type.
     */
    HEADQUARTER,
    /**
     * Brand relation type.
     */
    BRAND,
    /**
     * Distributor relation type.
     */
    DISTRIBUTOR,
    /**
     * User relation type.
     */
    USER,
    /**
     * Supplier relation type.
     */
    SUPPLIER,
    /**
     * Custom relation type.
     */
    CUSTOM

}
