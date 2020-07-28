package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RedRaiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNextInt()){
            int nums = scanner.nextInt();
            for(int i = 0; i<nums; i++){
                integers.add(scanner.nextInt());
            }
            int[] moves = getAllMoves(integers);
            int maxMove = Arrays.stream(moves).max().orElse(0);
            System.out.println(maxMove);
        }
    }
    //2 3 5 1 5 4 5 7 6 5 4 8
    private static int[] getAllMoves(List<Integer> integers) {
        int[] moves = new int[integers.size()];
        for (int i = 0;i<integers.size();i++){
            moves[i] = 1;
            for(int j = 0; j<i;j++){
                if(integers.get(j)<integers.get(i)){
                    moves[i] = Math.max(moves[i],moves[j]+1);
                }
            }
        }
        return moves;
    }


}
