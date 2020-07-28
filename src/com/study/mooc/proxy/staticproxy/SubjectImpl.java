package com.study.mooc.proxy.staticproxy;

public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("目标对象调用方"+this.getClass().getName());
    }
}
