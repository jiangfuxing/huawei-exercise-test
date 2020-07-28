package com.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RMBTranslate {
    private static Map<String,String> maps = new HashMap<>(); //数字转换集合

    private static Map<Integer,String> unitMap = new HashMap<>(); //单位转换集合 根据字符串长度和下标确定

    static {
        maps.put("0","零");
        maps.put("1","壹");
        maps.put("2","贰");
        maps.put("3","叁");
        maps.put("4","肆");
        maps.put("5","伍");
        maps.put("6","陆");
        maps.put("7","柒");
        maps.put("8","捌");
        maps.put("9","玖");
        maps.put("10","拾");
        maps.put("11","拾壹");
        maps.put("12","拾贰");
        maps.put("13","拾叁");
        maps.put("14","拾肆");
        maps.put("15","拾伍");
        maps.put("16","拾陆");
        maps.put("17","拾柒");
        maps.put("18","拾捌");
        maps.put("19","拾玖");

        unitMap.put(1,"元");
        unitMap.put(2,"拾");
        unitMap.put(3,"佰");
        unitMap.put(4,"仟");
        unitMap.put(5,"万");
        unitMap.put(9,"亿");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            String[] elems=input.split("\\.");
            StringBuffer stringBuffer = new StringBuffer("人民币");
            String proString = elems[0];
            int length = proString.length();
            int proEndIndex = length%4;
            int nums = length/4;
            //处理提前位
            addFist(stringBuffer, proString, length, proEndIndex,nums);

            //每四位分别处理
            for(int i=0;i<nums;i++){
               String tempString = proString.substring(proEndIndex,proEndIndex+4);
               addOther(tempString,stringBuffer,unitMap.get(length-proEndIndex-3)); //最后一位单位，1-4：元，5-8：万，9以上：亿
               proEndIndex=proEndIndex+4;
            }

            //处理小数部分
            String supString = elems[1];
            String jiao=String.valueOf(supString.charAt(0));//角的部分
            String fen=String.valueOf(supString.charAt(1));
            if(supString.equals("00")){
                stringBuffer.append("整");
            }else if(fen.equals("0")){
                stringBuffer.append(maps.get(jiao)
                        +"角");
            }else if(jiao.equals("0")){
                stringBuffer.append(maps.get(fen)+"分");
            }
            else {
                stringBuffer.append(maps.get(jiao)
                        +"角"+maps.get(fen)+"分");
            }
            System.out.println(stringBuffer.toString());
        }
    }

    private static void addFist(StringBuffer stringBuffer, String proString, int length, int proEndIndex,int nums) {
        String mproString=proString.substring(0,proEndIndex);
        if(mproString.equals("0")){
            return;
        }
        if(proEndIndex==2&&mproString.substring(0,1).equals("1")){
                stringBuffer.append(maps.get(mproString));
            stringBuffer.append(unitMap.get(nums*4+1));
        }else {
            addOther(mproString,stringBuffer,unitMap.get(nums*4+1));
        }

    }

    //10 1150 0001.15
    private static void addOther(String mproString, StringBuffer stringBuffer,String unit) {
        StringBuffer mindTemp = new StringBuffer(mproString).reverse();
        String newString = mindTemp.toString();
        StringBuffer temp = new StringBuffer();
        for (int i=newString.length();i>0;i--){
            String key=String.valueOf(newString.charAt(i-1));
            temp.append(maps.get(key));
            if(!key.equals("0")&&i!=1){
                temp.append(unitMap.get(i));
            }
            if(i==1){
                temp.append(unit);
            }
        }
        stringBuffer.append(temp.toString().replaceAll("零{2,}","零"));
    }
}
