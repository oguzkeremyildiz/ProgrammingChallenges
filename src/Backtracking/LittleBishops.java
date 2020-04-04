package Backtracking;/* Created by oguzkeremyildiz on 2.04.2020 */


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LittleBishops {

    private static int biggest(int[] arrayList, int currentBishopNumber){
        if (currentBishopNumber < 1){
            return -1;
        }
        return arrayList[currentBishopNumber - 1];
    }

    private static void constructCandidates(int[] arrayList, int currentBishopNumber, ArrayList<Integer> result, int boardLength){
        int x;
        int y;
        if (biggest(arrayList, currentBishopNumber) + arrayList.length - currentBishopNumber >= boardLength * boardLength){
            return;
        }
        for (int i = biggest(arrayList, currentBishopNumber) + 1; i < boardLength * boardLength; i++) {
            x = i / boardLength;
            y = i % boardLength;
            if (!isMatchWithBishop(arrayList, currentBishopNumber, x, y, boardLength)){
                result.add(i);
            }
        }
    }

    private static int backtrack(int[] arrayList, int currentBishopNumber, int size, int boardLength){
        int times = 0;
        ArrayList<Integer> result = new ArrayList<>();
        if (currentBishopNumber == size){
            times++;
        } else {
            constructCandidates(arrayList, currentBishopNumber, result, boardLength);
            for (Integer integer : result) {
                arrayList[currentBishopNumber] = integer;
                times += backtrack(arrayList, currentBishopNumber + 1, size, boardLength);
            }
        }
        return times;
    }

    private static boolean isMatchWithBishop(int[] arrayList, int currentBishopNumber, int i, int j, int boardLength){
        for (int k = 0; k < currentBishopNumber; k++){
            int x = arrayList[k] / boardLength;
            int y = arrayList[k] % boardLength;
            if (Math.abs(x - i) == Math.abs(y - j)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        try {
            int size;
            int bishopsNumber;
            Scanner source = new Scanner(new File("Bishops.txt"));
            while (source.hasNext()){
                size = source.nextInt();
                bishopsNumber = source.nextInt();
                int total;
                if (size != 0 && bishopsNumber != 0){
                    int[] arrayList = new int[bishopsNumber];
                    Date date1 = new Date();
                    total = backtrack(arrayList, 0, bishopsNumber, size);
                    Date date2 = new Date();
                    System.out.println(total);
                    System.out.println(date2.getTime() - date1.getTime());
                } else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
