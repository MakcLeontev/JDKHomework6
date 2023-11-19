package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 1000;
        List<Integer> array = fillingTheArray(size);
        List<Integer> changesHisMind = new ArrayList<>();
        List<Integer> dontChangesHisMind = new ArrayList<>();
        changeSelect(size,array,changesHisMind);
        dontChangeSelect(size,array, dontChangesHisMind);
        System.out.println("Меняет решение");
        countingWinnings(changesHisMind);
        System.out.println();
        System.out.println("Не меняет решение");
        countingWinnings(dontChangesHisMind);
    }
    public static int getRandomInt(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
    public static List<Integer> fillingTheArray(int size){
        List<Integer>array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(getRandomInt(1,3));
        }
        return array;
    }
    public static int emptySlot(int prizeNumber, int rand){
        int empty = 0;
        for (int i = 1; i < 4; i++) {
            if (i != prizeNumber && i!=rand){
                empty = i;
                break;
            }
        }
        return empty;
    }
    public static void changeSelect(int size, List<Integer> array,List<Integer> changesHisMind){
        for (int i = 0; i < size/2; i++) {
            int rand = getRandomInt(1,3);
           // System.out.println("выбрал изначально: " + rand);
            int emptySlot = emptySlot(array.get(i),rand);
            //System.out.println("Пустой слот"+emptySlot);
            for (int j = 1; j < 4; j++) {
                if (j == rand | j == emptySlot){
                }else {
                    rand = j;
                    //System.out.println("поменял на: " + rand);
                    break;
                }
            }
            if (rand == array.get(i)){
                changesHisMind.add(1);
                //System.out.println("Выиграл");
            }else {
                changesHisMind.add(0);
            }
        }
        //System.out.println(array);
        //System.out.println(changesHisMind);
    }
    public static void dontChangeSelect(int size, List<Integer> array,List<Integer> changesHisMind){
        for (int i = size/2; i < size; i++) {
            int rand = getRandomInt(1,3);
           // System.out.println("выбрал изначально: " + rand);
            int emptySlot = emptySlot(array.get(i),rand);
            //System.out.println("Пустой слот"+emptySlot);
//            for (int j = 1; j < 4; j++) {
//                if (j == rand | j == emptySlot){
//                }else {
//                    rand = j;
//                    System.out.println("поменял на: " + rand);
//                    break;
//                }
//            }
            if (rand == array.get(i)){
                changesHisMind.add(1);
               // System.out.println("Выиграл");
            }else {
                changesHisMind.add(0);
            }
        }
        //System.out.println(array);
        //System.out.println(changesHisMind);
    }

    public static void countingWinnings(List<Integer> array){
        int countWin = 0;
        int countLoose = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 1){
                countWin ++;
            }else {
                countLoose++;
            }
        }
        System.out.println("Количество побед: "+ (countWin*100)/ array.size()+"%");
        System.out.println("Количество поражений: "+ (countLoose*100)/ array.size()+"%");
    }
}