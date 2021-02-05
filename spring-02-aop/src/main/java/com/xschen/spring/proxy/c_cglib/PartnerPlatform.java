package com.xschen.spring.proxy.c_cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Cglib
 * @author xschen
 */


public class PartnerPlatform {

    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new Partner("肖洁洁"));
        partners.add(new Partner("田苟"));
        partners.add(new Partner("高总裁"));
    }

    public static Partner getPartner(int budget) {
        Partner partner = partners.remove(0);
        // 使用Cglib的Enhancer创建代理对象
        /**
         * Class type ：被代理的对象所属类的类型
         * Callback callback ：增强的代码实现
         */
        return (Partner) Enhancer.create(partner.getClass(), new MethodInterceptor() {
            private boolean status = false;

            /**
             * @param proxy 代理后的对象
             * @param method 代理对象执行的方法
             * @param args 代理对象执行方法的参数列表
             * @param methodProxy 对method的封装，利用他可以直接执行被代理对象的方法 methodProxy.invokeSuper(proxy, args)
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("receiveMoney")) {
                    int receiveMoney = (int) args[0];
                    // 平台需要运营，抽成一半
                    args[0] = receiveMoney / 2;
                    this.status = receiveMoney >= budget ;
                }

                if (status) {
                    return method.invoke(partner, args);
                }

                return null;
            }
        });
    }
}
