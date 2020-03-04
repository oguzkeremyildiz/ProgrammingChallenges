package Sorting.S4;/* Created by oguzkeremyildiz on 1.03.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestNap {
    private static void swap(ArrayList<Integer> list, int i, int j){
        int tmp;
        tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    private static int partition(ArrayList<Integer> list, int first, int last){
        int x = list.get(last);
        int i = first - 1, j;
        for (j = first; j < last; j++){
            if (list.get(j) <= x){
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, last);
        return i + 1;
    }
    private static void quickSort(ArrayList<Integer> list, int first, int last){
        int pivot;
        if (first < last){
            pivot = partition(list, first, last);
            quickSort(list, first, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }
    private static void convert(String line, ArrayList<Integer> first, ArrayList<Integer> last){
        String firstString = "";
        int firstInt;
        String lastString = "";
        int lastInt;
        for (int i = 0; i < line.length(); i++) {
            if (i < 5){
                switch (line.charAt(i)){
                    case '1':
                        firstString += '1';
                        break;
                    case '2':
                        firstString += '2';
                        break;
                    case '3':
                        firstString += '3';
                        break;
                    case '4':
                        firstString += '4';
                        break;
                    case '5':
                        firstString += '5';
                        break;
                    case '6':
                        firstString += '6';
                        break;
                    case '7':
                        firstString += '7';
                        break;
                    case '8':
                        firstString += '8';
                        break;
                    case '9':
                        firstString += '9';
                        break;
                    case '0':
                        firstString += '0';
                        break;
                    default:
                        break;
                }
            } else {
                switch (line.charAt(i)){
                    case '1':
                        lastString += '1';
                        break;
                    case '2':
                        lastString += '2';
                        break;
                    case '3':
                        lastString += '3';
                        break;
                    case '4':
                        lastString += '4';
                        break;
                    case '5':
                        lastString += '5';
                        break;
                    case '6':
                        lastString += '6';
                        break;
                    case '7':
                        lastString += '7';
                        break;
                    case '8':
                        lastString += '8';
                        break;
                    case '9':
                        lastString += '9';
                        break;
                    case '0':
                        lastString += '0';
                        break;
                    default:
                        break;
                }
            }
        }
        firstInt = Integer.parseInt(firstString);
        lastInt = Integer.parseInt(lastString);
        first.add(firstInt);
        last.add(lastInt);
    }
    private static void print(int napStart, int longestNap, int day){
        String napStartString = Integer.toString(napStart);
        int hour;
        int minute;
        napStartString = napStartString.substring(0, 2) + ":" + napStartString.substring(2);
        if (longestNap < 60){
            System.out.println("Day #" + day + " the longest nap starts at " + napStartString + " and will last for " + longestNap + " minutes.");
        } else {
            hour = longestNap / 60;
            minute = longestNap % 60;
            System.out.println("Day #" + day + " the longest nap starts at " + napStartString + " and will last for " + hour + " hours and " + minute + " minutes.");
        }
    }
    private static void longestNap(ArrayList<Integer> first, ArrayList<Integer> last, int napStart, int day){
        int longestNap = 0;
        final int timeFirst = 1000;
        final int timeLast = 1800;
        quickSort(first, 0, first.size() - 1);
        quickSort(last, 0, last.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            if (i + 1 < first.size()){
                if (i == 0){
                    if (first.get(i + 1) - last.get(i) > 60){
                        longestNap = ((first.get(i + 1) / 100) * 60) - ((last.get(i) / 100) * 60) + (first.get(i + 1) % 100) - (last.get(i) % 100);
                        napStart = last.get(i);
                    } else {
                        longestNap = first.get(i + 1) - last.get(i);
                        napStart = last.get(i);
                    }
                } else {
                    if (first.get(i + 1) - last.get(i) > 60){
                        if (((first.get(i + 1) / 100) * 60) - ((last.get(i) / 100) * 60) + (first.get(i + 1) % 100) - (last.get(i) % 100) > longestNap) {
                            longestNap = ((first.get(i + 1) / 100) * 60) - ((last.get(i) / 100) * 60) + (first.get(i + 1) % 100) - (last.get(i) % 100);
                            napStart = last.get(i);
                        }
                    } else {
                        if (first.get(i + 1) - last.get(i) > longestNap) {
                            longestNap = first.get(i + 1) - last.get(i);
                            napStart = last.get(i);
                        }
                    }
                }
            }
        }
        if (timeLast - last.get(last.size() - 1) > longestNap){
            if (timeLast - last.get(last.size() - 1) > 60){
                longestNap = ((timeLast / 100) * 60) - ((last.get(last.size() - 1) / 100) * 60) - last.get(last.size() - 1) % 100;
                napStart = last.get(last.size() - 1);
            }
        } else {
            if (1760 - last.get(last.size() - 1) > longestNap){
                longestNap = 1760 - last.get(last.size() - 1);
                napStart = last.get(last.size() - 1);
            }
        }
        if (first.get(0) - timeFirst > longestNap){
            if (first.get(0) - timeFirst > 60){
                if (((first.get(0) / 100) * 60) - ((timeFirst / 100) * 60) + first.get(0) % 100 > longestNap){
                    longestNap = ((first.get(0) / 100) * 60) - ((timeFirst / 100) * 60) + first.get(0) % 100;
                    napStart = timeFirst;
                }
            } else {
                if (first.get(0) - timeFirst > longestNap){
                    longestNap = first.get(0) - timeFirst;
                    napStart = timeFirst;
                }
            }
        }
        print(napStart, longestNap, day);
    }
    public static void main(String[]args){
        try {
            int day = 0;
            int times;
            int napStart;
            String line;
            Scanner source = new Scanner(new File("Nap.txt"));
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> last = new ArrayList<>();
            while (source.hasNext()){
                day++;
                first.clear();
                last.clear();
                napStart = 0;
                line = source.nextLine();
                times = Integer.parseInt(line);
                for (int i = 0; i < times; i++) {
                    line = source.nextLine();
                    convert(line, first, last);
                }
                longestNap(first, last, napStart, day);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
