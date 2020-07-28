package com.study;

import java.util.*;
import java.util.stream.Collectors;

public class CharStatistic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            List<Map<String,Object>> maps = getMap(chars);
            maps.sort((ch1,ch2)->{
                int count1 = (int)ch1.get("count");
                int count2 = (int)ch2.get("count");
                Character char1 = (Character)ch1.get("name");
                Character char2 = (Character)ch2.get("name");
                if(count2>count1){
                    return 1;
                }else if(count2==count1){
                    return char1.compareTo(char2);
                }else {
                    return -1;
                }
            });
            for(Map<String,Object> map:maps){
                System.out.print(map.get("name"));
            }
        }
    }

    private static List<Map<String, Object>> getMap(char[] chars) {
        List<Map<String,Object>> maps = new ArrayList<>();
        List<Character> characterList = destinct(chars);
        for(char ch:characterList){
            Map<String,Object> resultMap = new HashMap<>();
            int count = 0;
            for (char ch1:chars){
                if((int)ch==(int)ch1){
                    count++;
                }
            }
            resultMap.put("name",ch);
            resultMap.put("count",count);
            maps.add(resultMap);
        }
        return maps;
    }

    private static List<Character> destinct(char[] chars) {
        List<Character> characterList = new ArrayList<>();
        for(char ch:chars){
            characterList.add(ch);
        }
        List<Character> resultList = characterList.stream().distinct().collect(Collectors.toList());
        return resultList;
    }
}
