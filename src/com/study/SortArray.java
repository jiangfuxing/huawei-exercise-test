package com.study;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int length = scanner.nextInt();
            Integer[] array = new Integer[length];
            for(int i = 0;i<length; i++){
                array[i] = scanner.nextInt();
            }
            int sortBy = scanner.nextInt();
            if(sortBy == 0){
                Arrays.sort(array);
            }else{
                Arrays.sort(array,(o1,o2)->{
                    int num1 = (int)o1;
                    int num2 = (int)o2;
                    return num2>num1?1:num2==num1?0:-1;
                });
            }
            for (int i=0;i<length;i++){
                if(i<length-1){
                    System.out.print(array[i]+" ");
                }else {
                    System.out.print(array[i]);
                }
            }
            System.out.println();
        }
    }
}
