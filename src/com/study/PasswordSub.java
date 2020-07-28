package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/6 10:05
 */
public class PasswordSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            List<String> passwords = new ArrayList<>();
            for(int i=0;i<line.length()-1;i++){
                for(int j=i+1;j<line.length()+1;j++){

                    String current = line.substring(i, j);
                    int lg = current.length();
                    if(lg%2==0){
                        String pro = current.substring(0,lg/2);
                        String suffix =new StringBuffer(current.substring(lg/2)).reverse().toString();
                        if(pro.equals(suffix)){
                            passwords.add(current);
                        }
                    }else {
                        String pro = current.substring(0,lg/2);
                        String suffix =new StringBuffer(current.substring((lg/2)+1)).reverse().toString();
                        if(pro.equals(suffix)){
                            passwords.add(current);
                        }
                    }
                }
            }

            int max = 0;
            for(String password:passwords){
                if(max<password.length()){
                    max=password.length();
                }
            }
            System.out.println(max);

        }
    }
}
