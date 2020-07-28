package com.study.mooc.proxy.aop;

public class PersonImpl implements Person {
    @Override
    public void eat() {
        System.out.println("I am eating");
    }

    @Override
    public void bath() {
        System.out.println("I am bathing");
    }

    @Override
    public void washHand() {
        System.out.println("I am washing Hand");
    }
}
