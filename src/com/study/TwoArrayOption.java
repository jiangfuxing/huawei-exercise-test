package com.study;

import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION 二维数组的操作
 * @date 2020/7/21 12:49
 */
public class TwoArrayOption {
    private static final int ERROR_CODE = -1;

    private static final int SUCCESS_CODE = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int[] rowAndCol = getRowCol(scanner);
            int row = rowAndCol[0];
            int col = rowAndCol[1];

            int[][] array = new int[row][col];
            int result = initArray(array,row,col);
            System.out.println(result);
            if(result==ERROR_CODE){
                continue;
            }
            rowAndCol=getRowCol(scanner);
            int proRow =rowAndCol[0];
            int proCol = rowAndCol[1];

            rowAndCol = getRowCol(scanner);

            int lastRow = rowAndCol[0];
            int lastCol = rowAndCol[1];
            System.out.println(swichCell(array,proRow,proCol,lastRow,lastCol));

            int rowValue = Integer.parseInt(scanner.nextLine());
            int colValue = Integer.parseInt(scanner.nextLine());
            System.out.println(insert(array,rowValue,0));
            System.out.println(insert(array,colValue,1));

            rowAndCol = getRowCol(scanner);
            int rowIndex = rowAndCol[0];
            int colIndex = rowAndCol[1];
            System.out.println(query(array,rowIndex,colIndex));


        }

    }

    private static int[] getRowCol(Scanner scanner) {
        int[] rowCol = new int[2];
        String line1 = scanner.nextLine();
        int row = Integer.parseInt(line1.split(" ")[0]);
        int col = Integer.parseInt(line1.split(" ")[1]);
        rowCol[0] = row;
        rowCol[1] = col;
        return rowCol;
    }

    private static int initArray(int[][] array,int rowLength,int colLength){
        if(isOutBound(rowLength)||isOutBound(colLength)){
            return ERROR_CODE;
        }else {
            array = new int[rowLength][colLength];
        }
        return SUCCESS_CODE;
    }


    private static int swichCell(int[][] array,
                                 int preRowIndex,int preColIndex,
                                 int lastRowIndex,int lastColIndex){
        int rowLength = array.length;
        int colLength = array[rowLength-1].length;

        if(isOutBound(rowLength,preRowIndex)||isOutBound(colLength,preColIndex)
                ||isOutBound(colLength,lastColIndex)||isOutBound(rowLength,lastRowIndex)){
            return ERROR_CODE;
        }else {
            int temp = array[preRowIndex][preColIndex];
            array[preRowIndex][preColIndex] = array[lastRowIndex][lastColIndex];
            array[lastRowIndex][lastColIndex] = temp;
            return SUCCESS_CODE;
        }

    }

    private static boolean isOutBound(int oldLength,int newLength){
        if(newLength>oldLength-1){
            return true;
        }else {
            return false;
        }

    }
    private static int insert(int[][] array,int num,int isRow){
        int rowLength = array.length;
        int colLength = array[rowLength-1].length;
        if(isRow==0&&isOutBound(rowLength,num)){
            return ERROR_CODE;
        }else if(isRow==1&& isOutBound(colLength,num)) {
            return ERROR_CODE;
        }
        else {
            return SUCCESS_CODE;
        }
    }

    private static int query(int[][] array,int row,int col){
        int rowLength = array.length;
        int colLength = array[rowLength-1].length;
        if(isOutBound(rowLength,row)||isOutBound(colLength,col)){
            return ERROR_CODE;
        }else {
            return SUCCESS_CODE;
        }
    }

    private static boolean isOutBound(int index) {
        return index<0||index>9;
    }

}
