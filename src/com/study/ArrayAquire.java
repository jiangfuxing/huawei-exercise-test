package com.study;

import java.util.Scanner;

public class ArrayAquire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int size = scanner.nextInt();
            int[] others = new int[size];
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0;i<size;i++){
                int temp = scanner.nextInt();
                if (temp%3==0) sum1+=temp;
                else if (temp%5==0) sum2+=temp;
                else others[i]=temp;
            }
            System.out.println(isEqual(sum1,sum2,others,0));
            System.out.println("sum1:"+sum1+", sum2:"+sum2);
        }
    }

    private static boolean isEqual(int sum1, int sum2, int[] others, int index) {
        if(index==others.length && sum1==sum2) return true;
        else if(index==others.length && sum1!=sum2) return false;
        else return isEqual(sum1+others[index],sum2,others,index+1)
                    ||isEqual(sum1,sum2+others[index],others,index+1);
    }
}
