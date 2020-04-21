package Strings.S6;/* Created by oguzkeremyildiz on 13.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileFragmentation {
    private static void find(ArrayList<String> allElements, ArrayList<String> numbers){
        int times = 0;
        int count;
        int count1;
        int count2;
        int count3;
        ArrayList<String> isHave = new ArrayList<>();
        for (String allElement : allElements) {
            for (int j = 0; j < numbers.size(); j++) {
                count = 0;
                count1 = 0;
                count2 = 0;
                count3 = 0;
                for (int t = 0; t < numbers.size(); t++) {
                    if (t != j) {
                        for (String s : isHave) {
                            if (s.equals(numbers.get(j))) {
                                count++;
                            }
                            if (s.equals(numbers.get(t))) {
                                count2++;
                            }
                        }
                        for (String number : numbers) {
                            if (number.equals(numbers.get(j))) {
                                count1++;
                            }
                            if (number.equals(numbers.get(t))) {
                                count3++;
                            }
                        }
                        if (count != count1 && count2 != count3){
                            if (allElement.equals(numbers.get(j) + numbers.get(t))) {
                                isHave.add(numbers.get(j));
                                isHave.add(numbers.get(t));
                                times += 2;
                                break;
                            }
                        }
                    }
                }
            }
            if (times == numbers.size()) {
                System.out.println(allElement);
                break;
            } else {
                times = 0;
            }
            isHave.clear();
        }
    }
    private static void addAllElement(ArrayList<String> allElements, HashMap<String, ArrayList<String>> match, ArrayList<String> numbers){
        for (String number : numbers) {
            allElements.addAll(match.get(number));
        }
    }
    private static void graphAdd(HashMap<String, ArrayList<String>> match, ArrayList<String> numbers){
        String combine;
        for (String number : numbers) {
            match.put(number, new ArrayList<>());
        }
        for (int j = 0; j < numbers.size(); j++){
            for (int t = 0; t < numbers.size(); t++){
                if (j != t){
                    combine = numbers.get(j) + numbers.get(t);
                    match.get(numbers.get(j)).add(combine);
                }
            }
        }
    }
    public static void main(String[]args){
        try {
            ArrayList<String> allElements = new ArrayList<>();
            HashMap<String, ArrayList<String>> match = new HashMap<>();
            ArrayList<String> numbers = new ArrayList<>();
            String line;
            Scanner source = new Scanner(new File("FileFragmentation.txt"));
            while (source.hasNext()){
                line = source.nextLine();
                numbers.add(line);
            }
            graphAdd(match, numbers);
            addAllElement(allElements, match, numbers);
            find(allElements, numbers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}