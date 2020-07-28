package com.study.mooc.proxy.dynamicproxy;

public class SubjectImpl implements Subject,Teachable {
    @Override
    public void request() {
        System.out.println("SubjectImpl.request()");
    }

    @Override
    public void requestOther() {
        System.out.println("SubjectImpl.requestOther()");
    }
}
