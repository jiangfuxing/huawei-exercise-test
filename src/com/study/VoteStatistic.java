package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为编程题：计票统计
 */
public class VoteStatistic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int candNum = scanner.nextInt();
            List<String> cands = new ArrayList<>();
            List<String> votes = new ArrayList<>();
            for(int i = 0;i<candNum;i++){
                cands.add(scanner.next());
            }
            int voteNum = scanner.nextInt();
            for(int i = 0;i<voteNum;i++){
                votes.add(scanner.next());
            }
            int validNum = 0;
            for(String cond:cands){
                int count = 0;
                for(String vote:votes){
                    if(cond.equals(vote)){
                        count++;
                        validNum++;
                    }
                }
                System.out.println(cond+" : "+count);
            }

            System.out.println("Invalid : "+(votes.size()-validNum));
        }
    }
}
