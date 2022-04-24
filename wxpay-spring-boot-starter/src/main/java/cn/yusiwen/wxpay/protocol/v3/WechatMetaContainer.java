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
package cn.yusiwen.wxpay.protocol.v3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 配置容器
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public class WechatMetaContainer {
    /**
     * Meta bean map
     */
    private final Map<String, WechatMetaBean> wechatMetaBeanMap = new HashMap<>();
    /**
     * Tenant IDs
     */
    private final Set<String> tenantIds = new HashSet<>();

    /**
     * Add wechat meta boolean.
     *
     * @param tenantId
     *            the tenantId
     * @param wechatMetaBean
     *            the wechat meta bean
     * @return the boolean
     */
    public WechatMetaBean addWechatMeta(String tenantId, WechatMetaBean wechatMetaBean) {
        tenantIds.add(tenantId);
        return this.wechatMetaBeanMap.put(tenantId, wechatMetaBean);
    }

    /**
     * Remove wechat meta wechat meta bean.
     *
     * @param tenantId
     *            the tenantId
     * @return the wechat meta bean
     */
    public WechatMetaBean removeWechatMeta(String tenantId) {
        tenantIds.remove(tenantId);
        return this.wechatMetaBeanMap.remove(tenantId);
    }

    /**
     * Gets wechat meta.
     *
     * @param tenantId
     *            the tenantId
     * @return the wechat meta
     */
    public WechatMetaBean getWechatMeta(String tenantId) {
        return Objects.requireNonNull(this.wechatMetaBeanMap.get(tenantId));
    }

    /**
     * Gets properties keys.
     *
     * @return the properties keys
     */
    public Set<String> getTenantIds() {
        return tenantIds;
    }
}
