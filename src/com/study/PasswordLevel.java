package com.study;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/5 12:30
 */
public class PasswordLevel {
    public static final String VERY_SECURE="VERY_SECURE";

    public static final String SECURE="SECURE";

    public static final String VERY_STRONG = "VERY_STRONG";

    public static final String STRONG = "STRONG";

    public static final String AVERAGE = "AVERAGE";

    public static final String WEAK="WEAK";

    public static final String VERY_WEAK = "VERY_WEAK";
    public static class Password{
        String value;
        int score;
        Password(String value,int score,String level){
            this.score=score;
            this.value=value;
        }

        boolean isExist(String regex){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if(matcher.find()){
                return true;
            }else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            int score = 0;
            Password password = new Password(line,score,VERY_WEAK);
            int length = line.length();
            if(length<=4) password.score+=5;
            else if(length>5&&length<7) password.score+=10;
            else if(length>8) password.score+=25;

            if(password.isExist("[a-zA-Z]{2}")) password.score+=20;
            else if((password.isExist("[a-z]+")&&!password.isExist("[A-Z]+"))
                    ||(!password.isExist("[a-z]+")&&password.isExist("[A-Z]+")))
                password.score+=10;

            if(password.isExist("(\\d{2,})")) password.score+=20;
            else if(password.isExist("[0-9]{1}")) password.score+=10;

            if(password.isExist("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]{2,}"))password.score+=25 ;
            else if (password.isExist("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]{1}")) password.score+=10;

            if(password.isExist("([A-Za-z0-9`~!@#$%^&*()+=|{}':;',\\[\\].<>/?])+")){
                password.score+=5;
            }else if(password.isExist("([a-z]|[A-Z])[0-9`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]+"))
                password.score+=3;
            else if(password.isExist("([A-Z]|[a-z])[0-9]+")) password.score+=2;

            System.out.println(getLevel(password.score));



        }
    }

    private static String getLevel(int score) {
        if(score>=90) return VERY_SECURE;
        else if(score>=80) return SECURE;
        else if(score>=70) return VERY_STRONG;
        else if(score>=60) return STRONG;
        else if(score>=50) return AVERAGE;
        else if(score>=25) return WEAK;
        else return VERY_WEAK;
    }

}

