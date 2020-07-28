package com.study;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/15 11:52
 */
public class AppearManyNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int size = scanner.nextInt();
            List<Integer> integers = new ArrayList<>();
            for(int i =0; i<size;i++){
                integers.add(scanner.nextInt());
            }
            List<Integer> nopeatInteger = integers.stream().distinct().collect(Collectors.toList());
            List<Map<String,Integer>> resultMaps = new ArrayList<>();
            for(Integer integer:nopeatInteger){
                int count = 0;
                Map<String,Integer> map = new HashMap<>();
                for (Integer current:integers){
                    if(current == integer){
                        count++;
                    }
                }
                map.put("name",integer);
                map.put("count",count);
                resultMaps.add(map);
            }
            resultMaps.sort((m1,m2)->{
                int count1 = m1.get("count");
                int count2 = m2.get("count");
                return count1>count2?1:count1==count2?0:-1;
            });
            int max = resultMaps.get(resultMaps.size()-1).get("count");
            for(int i=resultMaps.size()-1;i>0;i--){
                Map<String, Integer> map = resultMaps.get(i);
                if(map.get("count")==max){
                    System.out.println(map.get("name")+" "+map.get("count"));
                }
            }
        }


    }
}
