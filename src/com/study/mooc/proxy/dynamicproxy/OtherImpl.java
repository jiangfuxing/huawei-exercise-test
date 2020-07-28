package com.study.mooc.proxy.dynamicproxy;

public class OtherImpl implements Subject {
    @Override
    public void request() {
        System.out.println("OtherImpl.request()");
    }

    @Override
    public void requestOther() {
        System.out.println("OtherImpl.requestOther()");
    }
}
