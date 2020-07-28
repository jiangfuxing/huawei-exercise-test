package com.study;

import java.util.Scanner;

public class PokerGame {
    public static final String ERR = "ERROR";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] firstPokers = line.split("-")[0].split(" ");
            String[] secondPokers = line.split("-")[1].split(" ");
            String result = compare(firstPokers,secondPokers);
            System.out.println(result);
        }
    }

    private static String compare(String[] firstPokers, String[] secondPokers) {
        int length1 = firstPokers.length;
        int lenght2 = secondPokers.length;
        switch (length1){
            case 1:{
                if(lenght2==1){
                    int p1 = switchInt(firstPokers[0]);
                    int p2 = switchInt(secondPokers[0]);
                    if(p1>p2) return firstPokers[0];
                    else return secondPokers[0];

                }else if(lenght2==2) {
                    if(isMax(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }else if(lenght2==4){
                    if(isAllEquas(secondPokers)) return getResult(secondPokers);
                    else return ERR;

                }else return ERR;

            }
            case 2:{
                if(isMax(firstPokers)) return getResult(firstPokers);
                else if(lenght2==2&&isAllEquas(firstPokers)&&isAllEquas(secondPokers)){
                    int p1 = switchInt(firstPokers[0]);
                    int p2 = switchInt(secondPokers[0]);
                    if(p1>p2) return getResult(firstPokers);
                    else return getResult(secondPokers);
                }else if(lenght2==4){
                    if(isAllEquas(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }else return ERR;

            }
            case 3:{
                if(lenght2==3&&isAllEquas(firstPokers)&&isAllEquas(secondPokers)){
                    int p1 = switchInt(firstPokers[0]);
                    int p2 = switchInt(secondPokers[0]);
                    if(p1>p2) return getResult(firstPokers);
                    else return getResult(secondPokers);
                }else if(lenght2==2) {
                    if(isMax(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }
                else if(lenght2==4){
                    if(isAllEquas(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }else return ERR;
            }
            case 4:{
                if(lenght2!=4&&isAllEquas(firstPokers)) return getResult(firstPokers);
                else if(lenght2==4&&isAllEquas(firstPokers)&&isAllEquas(secondPokers)){
                    int p1 = switchInt(firstPokers[0]);
                    int p2 = switchInt(secondPokers[0]);
                    if(p1>p2) return getResult(firstPokers);
                    else return getResult(secondPokers);
                }else if(lenght2==2) {
                    if(isMax(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                } else return ERR;
            }
            case 5:{
                if(lenght2==5){
                    int p1 = switchInt(firstPokers[0]);
                    int p2 = switchInt(secondPokers[0]);
                    if(p1>p2) return getResult(firstPokers);
                    else return getResult(secondPokers);
                }else if(lenght2==2) {
                    if(isMax(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }
                else if(lenght2==4){
                    if(isAllEquas(secondPokers)) return getResult(secondPokers);
                    else return ERR;
                }else return ERR;
            }
            default:return ERR;


        }
    }

    private static boolean isMax(String[] secondPokers) {
        return secondPokers[0].equalsIgnoreCase("JOKER")&&secondPokers[1].equalsIgnoreCase("JOKER");
    }

    private static boolean isAllEquas(String[] secondPokers) {
        for(int i=0;i<secondPokers.length-1;i++){
            if(!secondPokers[i].equalsIgnoreCase(secondPokers[i+1])){
                return false;
            }
        }
        return true;
    }

    private static String getResult(String[] pokers) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<pokers.length;i++){
            stringBuffer.append(pokers[i]);
            if(i<pokers.length-1){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private static int switchInt(String poker) {
        switch (poker){
            case "A": return 14;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "2":return 15;
            case "joker":return 16;
            case "JOKER":return 17;
            default: return Integer.parseInt(poker);
        }
    }
}
