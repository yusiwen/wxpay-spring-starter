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

import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.springframework.core.io.ClassPathResource;

import cn.yusiwen.wxpay.PayException;

/**
 * 证书工具
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 **/
public class KeyPairFactory {

    /**
     * Keystore for pkcs12
     */
    private static final KeyStore PKCS12_KEY_STORE;

    static {
        try {
            PKCS12_KEY_STORE = KeyStore.getInstance("PKCS12");
        } catch (KeyStoreException e) {
            throw new PayException(" wechat pay keystore initialization failed");
        }
    }

    /**
     * 获取公私钥.
     *
     * @param keyPath
     *            the key path
     * @param keyAlias
     *            the key alias
     * @param keyPass
     *            password
     * @return the key pair
     */
    public WechatMetaBean initWechatMetaBean(String keyPath, String keyAlias, String keyPass) {
        ClassPathResource resource = new ClassPathResource(keyPath);
        char[] pem = keyPass.toCharArray();
        try {
            PKCS12_KEY_STORE.load(resource.getInputStream(), pem);
            X509Certificate certificate = (X509Certificate) PKCS12_KEY_STORE.getCertificate(keyAlias);
            certificate.checkValidity();
            String serialNumber = certificate.getSerialNumber().toString(16).toUpperCase();
            PublicKey publicKey = certificate.getPublicKey();
            PrivateKey storeKey = (PrivateKey) PKCS12_KEY_STORE.getKey(keyAlias, pem);
            WechatMetaBean wechatMetaBean = new WechatMetaBean();
            wechatMetaBean.setKeyPair(new KeyPair(publicKey, storeKey));
            wechatMetaBean.setSerialNumber(serialNumber);
            return wechatMetaBean;
        } catch (Exception e) {
            throw new PayException("Cannot load keys from store: " + resource, e);
        }
    }
}
