/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geekbang.thinking.in.spring.ioc.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Scope
 * ThreadLocal 级别 Scope
 */
public class ThreadLocalScope implements Scope {

    public static final String SCOPE_NAME = "thread-local";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("thread-local-scope") {
        public Map<String, Object> initialValue() {
            return new HashMap<>();
        }//初始化创建一个new HashMap
    };

   /* public static void main(String[] args) {
        ThreadLocalScope threadLocalScope1 = new ThreadLocalScope();
        threadLocalScope1.getContext().put("aa","d");
        System.out.println(threadLocalScope1.getContext());
        ThreadLocalScope threadLocalScope2 = new ThreadLocalScope();
        System.out.println(threadLocalScope2.getContext());
        System.out.println(Thread.currentThread());
    }*/

    /**通过容器去取*/
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        // 非空
        Map<String, Object> context = getContext();

        Object object = context.get(name);

        if (object == null) {
            object = objectFactory.getObject();
            context.put(name, object);
        }

        return object;
    }

    @NonNull
    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    /**删除对象的操作*/
    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    /**注册销毁时的系统回调*/
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // TODO
    }

    /**通过key取上下文对象*/
    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getContext();
        return context.get(key);
    }

    /**返回会话id，这里采用线程id，sessionScope则采用sessionId*/
    @Override
    public String getConversationId() {
        Thread thread = Thread.currentThread();
        return String.valueOf(thread.getId());
    }
}
