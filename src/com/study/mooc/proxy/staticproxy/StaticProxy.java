package com.study.mooc.proxy.staticproxy;

public class StaticProxy implements Subject{
    private Subject subject;

    public StaticProxy(){}

    public StaticProxy(Subject subject){
        this();
        this.subject=subject;
    }
    @Override
    public void request() {
        System.out.println("调用前");
        subject.request();
        System.out.println("调用后");
    }
}
