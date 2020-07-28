package com.study.mooc.proxy.staticproxy;

public class StaticProxyDemo {
    public static void main(String[] args) {
        //SubjectImpl subject = new SubjectImpl();

        StaticProxy staticProxy = new StaticProxy(new SubjectImpl());
        staticProxy.request();
    }
}
