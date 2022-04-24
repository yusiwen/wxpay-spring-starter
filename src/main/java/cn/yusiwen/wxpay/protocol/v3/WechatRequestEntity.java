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

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.function.Consumer;

import lombok.Getter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

/**
 * The type Wechat request entity.
 *
 * @param <T>
 *            the type parameter
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Getter
public class WechatRequestEntity<T> extends RequestEntity<T> {

    /**
     * The Response body consumer.
     */
    private final Consumer<ResponseEntity<ObjectNode>> responseBodyConsumer;

    /**
     * Instantiates a new Wechat request entity.
     *
     * @param body
     *            the body
     * @param headers
     *            the headers
     * @param method
     *            the method
     * @param url
     *            the url
     * @param type
     *            the type
     * @param responseBodyConsumer
     *            the response body consumer
     */
    public WechatRequestEntity(T body, MultiValueMap<String, String> headers, HttpMethod method, URI url, Type type,
            Consumer<ResponseEntity<ObjectNode>> responseBodyConsumer) {
        super(body, headers, method, url, type);
        this.responseBodyConsumer = responseBodyConsumer;
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) {
            return false;
        }

        WechatRequestEntity<?> otherEntity = (WechatRequestEntity<?>) other;
        return ObjectUtils.nullSafeEquals(getResponseBodyConsumer(), otherEntity.getResponseBodyConsumer());
    }

    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
        hashCode = 29 * hashCode + ObjectUtils.nullSafeHashCode(this.responseBodyConsumer);
        return hashCode;
    }

    /**
     * Headers wechat request entity.
     *
     * @param httpHeaders
     *            the http headers
     * @return the wechat request entity
     */
    public WechatRequestEntity<T> headers(HttpHeaders httpHeaders) {
        return new WechatRequestEntity<>(this.getBody(), httpHeaders, this.getMethod(), this.getUrl(), this.getType(),
                this.responseBodyConsumer);
    }

    /**
     * Of wechat request entity.
     *
     * @param requestEntity
     *            the request entity
     * @param responseBodyConsumer
     *            the response body consumer
     * @return the wechat request entity
     */
    public static WechatRequestEntity<?> of(RequestEntity<?> requestEntity,
            Consumer<ResponseEntity<ObjectNode>> responseBodyConsumer) {
        return new WechatRequestEntity<>(requestEntity.getBody(), requestEntity.getHeaders(), requestEntity.getMethod(),
                requestEntity.getUrl(), requestEntity.getType(), responseBodyConsumer);
    }
}
