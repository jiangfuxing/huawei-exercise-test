package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxLengthNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(string);
            String maxLength = "";
            List<String> sameLengths = new ArrayList<>();
            while (matcher.find()){
                String temp = matcher.group();
                if(maxLength.length()<temp.length()) maxLength=temp;
                else if(maxLength.length()==maxLength.length()) sameLengths.add(temp);
            }
            int maxLg = +maxLength.length();
            System.out.print(maxLength);
            sameLengths.stream().filter(i->i.length()==maxLg).forEach(System.out::print);
            System.out.print(","+maxLg);
            System.out.println();

        }
    }
}
