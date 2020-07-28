package com.study;

import java.util.Scanner;

public class ValidIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            String s = sc.nextLine() ;
            boolean b = isValidIP(s) ;
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();

    }

    private static boolean isValidIP(String s) {
        String[] str = s.split("\\.") ;
        for(int i = 0 ; i < str.length ; i++){
            int temp = Integer.parseInt(str[i]) ;
            if(!str[i].matches("\\d{1,3}")||temp <0 || temp >255)
                return false ;        }
        return true ;
    }
}
