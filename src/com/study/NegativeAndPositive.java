package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NegativeAndPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNextInt()){
            integers.add(scanner.nextInt());
        }
        long count = integers.stream().filter(x -> x < 0).count();
        System.out.println(count);
        double average = integers.stream().filter(x -> x > 0).mapToInt(Integer::intValue).average().orElse(0D);
        System.out.println(String.format("%.1f",average));
    }
}
