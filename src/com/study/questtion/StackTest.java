package com.study.questtion;

import java.util.Stack;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/12 10:40
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        for (int i=1;i<5;i++){
            integers.push(i);
        }

        System.out.println(integers.peek());
        System.out.println();
        while (!integers.empty()){
            System.out.println(integers.pop());
        }
    }
}
