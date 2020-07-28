package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringSubstor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputStrs = new ArrayList<>();
        while (scanner.hasNext()){
            int lines = Integer.parseInt(scanner.nextLine());
            for(int i = 0;i<lines;i++){
                String current = scanner.nextLine();
                while (current.length()>=8){
                    inputStrs.add(current.substring(0,8));
                    current = current.substring(8);
                }
                if(current.length()>0&&current.length()<8){
                    inputStrs.add(addString(current));
                }
            }
        }
        for(String s:inputStrs){
            System.out.println(s);
        }
    }

    private static String addString(String current) {
        StringBuffer result = new StringBuffer(current);
        for (int i=current.length();i<8;i++){
            result.append("0");
        }
        return result.toString();
    }
}
