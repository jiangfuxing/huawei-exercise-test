package com.study;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/12 18:26
 */
public class Sort {
    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        int length = array.length;
        for(int i = length-1;i>0; i--){
            for(int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] array){
        int length = array.length;
        for(int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if(array[i]>array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] =temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,9,8,2,3,10,6,7,4};
        bubbleSort(array);
        System.out.println("冒泡排序结果：");
        printArray(array);
        System.out.println("选择排序的结果：");
        array = new int[]{1,5,9,8,2,3,10,6,7,4};
        selectSort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int ele:array){
            System.out.print(ele+",");
        }
    }
}
