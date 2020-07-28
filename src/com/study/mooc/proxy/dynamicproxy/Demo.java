package com.study.mooc.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        ProxyHandler proxyHandler = new ProxyHandler(subject);
        Teachable proxy = (Teachable)Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),proxyHandler);
        proxy.request();
        /*proxy.requestOther();*/
        System.out.println(proxy.getClass().getName());
        System.out.println(proxy.getClass().getSuperclass());
        Class<?>[] interfaces = proxy.getClass().getInterfaces();
        for(Class clazz:interfaces){
            System.out.println(clazz.getName());
        }
    }
}
