package com.study.mooc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Subject subject;

    public ProxyHandler(){

    }
    public ProxyHandler(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        Object result = method.invoke(subject, args);
        return result;
    }
}
