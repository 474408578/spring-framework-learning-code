package com.xschen.spring.proxy.b_jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * jdk动态代理 演示
 * @author xschen
 */


public class PartnerPlatform {

    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new IndividualPartner("肖洁洁"));
        partners.add(new IndividualPartner("田苟"));
        partners.add(new IndividualPartner("高总裁"));
    }

    /**
     * @param budget 获取玩家需要的预算
     * @return
     */
    public static Partner getPartner(int budget) {
        Partner partner = partners.remove(0);
        /**
         * jdk 的动态代理，要求被代理的对象所属类必须实现一个以上的接口，代理对象的创建使用 Proxy.newProxyInstance 方法。
         * @param loader 被代理的对象所属类的类加载器
         * @param interfaces 被代理的对象所属类实现的接口
         * @param h 代理的具体实现代码
         */
        return (Partner) Proxy.newProxyInstance(partner.getClass().getClassLoader(),
                partner.getClass().getInterfaces(),
                new InvocationHandler() {
                    private boolean status = false;

                    /**
                     * @param proxy 代理对象的引用，代理后的
                     * @param method 代理对象执行的方法
                     * @param args 代理对象执行方法的参数列表
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("receiveMoney")) { // 对这个receiveMoney方法做处理
                            // 实际接收到的钱
                            int receiveMoney = (int) args[0];
                            // 平台需要运营，抽成一半，receive
                            args[0] = receiveMoney / 2;
                            // 接收到的钱大于预算，可以匹配玩家
                            this.status = receiveMoney >= budget;
                        }

                        if (status) {
                            return method.invoke(partner, args);
                        }

                        return null;
                    }
                });
    }
}
