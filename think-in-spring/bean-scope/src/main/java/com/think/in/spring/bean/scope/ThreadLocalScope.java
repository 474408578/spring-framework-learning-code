package com.think.in.spring.bean.scope;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 ThreadLocal级别Scope
 * @author xschen
 *
 * @see Scope
 * @see ObjectFactory
 * @see ConfigurableBeanFactory#registerScope(String, Scope)
 * @see ThreadLocal
 * @see NamedThreadLocal
 */

public class ThreadLocalScope implements Scope {

    private static final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("thread-local-scope") {
        // 覆盖initialValue()方法，防止threadLocal.get()导致空指针异常
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public static final String SCOPE_NAME = "thread-local";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object obj = context.get(name);
        if (obj == null) {
            obj = objectFactory.getObject();
            context.put(name, obj);
        }
        return obj;
    }

    @NotNull
    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    @Override
    public Object remove(String name) {
        return getContext().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // TODO
    }

    @Override
    public Object resolveContextualObject(String key) {
        return getContext().get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
