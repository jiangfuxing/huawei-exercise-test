package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 24点游戏运算
 */
public class Point24 {
    /**
     * 程序入口
     * @param args 入口参数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            if(string.contains("joker")||string.contains("JOKER")){
                System.out.println("ERROR");
            }else {
                System.out.println(comput(string));
            }
        }
    }

    /**
     * 进行24点运算
     * @param string 运算数：字符串形式，以空格分隔
     * @return 通过 + - * / 后能得到24，则输出成功的算式，否则位NONE
     */
    private static String comput(String string) {
        String[] pairs = string.split(" ");
        int[] nums = new int[4];
        for(int i =0;i<pairs.length;i++){
            nums[i] = switchNum(pairs[i]);
        }
        List<Integer> initNums = intToInteger(nums);
        List<Integer> rs=new ArrayList<>();
        List<List<Integer>> totals = new ArrayList<>();
        pl(initNums,rs,totals); //产生排列
        for(List<Integer> integers:totals){
            //进行穷举
            int[] nums1 = listToInt(integers);
            String[] ops = new String[3];
            if(get(nums1[0],nums1[1],nums1[2],nums1[3],ops)){
                return getString(nums1,ops);
            }
        }
        return "NONE";

    }

    /**
     * 获取算式
     * @param nums 运算数字
     * @param ops 运算符
     * @return 算式
     */
    private static String getString(int[] nums, String[] ops) {
        String[] pokers = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            pokers[i] = switchString(nums[i]);
        }

        return "(("+pokers[0]+ops[0]+pokers[1]+")"+ops[1]+pokers[2]+")"+ops[2]+pokers[3];
    }

    /**
     * 将扑克牌特殊数字还原成字符
     * @param num 数字
     * @return 输出相应的特殊字符
     */
    public static String switchString(int num){
        switch(num){
            case 1: return "A";
            case 11:return "J";
            case 12:return "Q";
            case 13:return "K";
            default: return String.valueOf(num);
        }
    }


    /**
     * 将int数组转换位Integer List
     * @param nums int数组
     * @return List
     */
    private static List<Integer> intToInteger(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for(int num:nums){
            integers.add(num);
        }
        return integers;
    }

    /**
     * 产生排列
     * @param s 原始集合
     * @param rs 中间结果
     * @param totals 总数集合
     */
    public static void pl(List<Integer> s, List<Integer> rs,List<List<Integer>> totals){

        if(s.size()==1)
        {

            rs.add(s.get(0));
            List<Integer> tmpRs = produceList(rs);
            totals.add(tmpRs);
            rs.remove(rs.size()-1);

        }else{

            for(int i=0;i<s.size();i++){

                rs.add(s.get(i));
                List<Integer> tmp=new ArrayList<Integer>();
                for(Integer a:s)
                    tmp.add(a);
                tmp.remove(i);
                pl(tmp,rs,totals);
                rs.remove(rs.size()-1);

            }
        }
    }

    /**
     * 产生一个新List<Integer>
     * @param rs 中间结果
     * @return 新List
     */
    private static List<Integer> produceList(List<Integer> rs) {
        List<Integer> integers = new ArrayList<>();
        for(Integer integer:rs){
            integers.add(integer);
        }
        return integers;
    }

    /**
     * 将List集合转换位int数组
     * @param rs 中间结果
     * @return int[]
     */
    private static int[] listToInt(List<Integer> rs) {
        int[] nums = new int[rs.size()];
        for(int i=0;i<nums.length;i++){
            nums[i] = rs.get(i);
        }
        return nums;
    }

    /**
     * 一层穷举
     * @param num 算数1
     * @param num1 算数2
     * @param num2 算数3
     * @param num3 算数4
     * @param ops 操作符数组
     * @return 是否等于24；
     */
    private static boolean get(int num, int num1, int num2, int num3,String[] ops) {
        if(get(num+num1,num2,num3,ops)) {ops[0]="+"; return true;}
        if(get(num-num1,num2,num3,ops)) {ops[0]="-"; return true;}
        if(get(num*num1,num2,num3,ops)) {ops[0]="*"; return true;}
        if(get(num/num1,num2,num3,ops)) {ops[0]="/"; return true;}
        return false;
    }

    /**
     * 二层穷举
     * @param i 结果1
     * @param num2 算数3
     * @param num3 算数4
     * @param ops 操作符数组
     * @return 是否等于24
     */
    private static boolean get(int i, int num2, int num3, String[] ops) {
        if(get(i+num2,num3,ops)){ops[1]="+";return true;}
        if(get(i-num2,num3,ops)){ops[1]="-";return true;}
        if(get(i*num2,num3,ops)){ops[1]="*";return true;}
        if(get(i/num2,num3,ops)){ops[1]="/";return true;}
        return false;
    }

    /**
     * 三层穷举
     * @param i 结果2
     * @param num3 算数4
     * @param ops 操作符数组
     * @return 是否等于24
     */
    private static boolean get(int i, int num3, String[] ops) {
        if(i+num3==24) {ops[2]="+";return true;}
        if(i-num3==24) {ops[2]="-";return true;}
        if(i*num3==24) {ops[2]="*";return true;}
        if(i/num3==24) {ops[2]="/";return true;}
        return false;
    }

    /**
     * 将扑克牌种特殊字符转换为相应的数字
     * @param pair 特殊字符
     * @return 相应的数字
     */
    private static int switchNum(String pair) {
        switch (pair){
            case "A": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default: return Integer.parseInt(pair);
        }
    }
}
