package Strings.S6;/* Created by oguzkeremyildiz on 13.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FileFragmentation {
    private static void find(ArrayList<String> allElements, ArrayList<String> numbers){
        int times = 0;
        HashSet<String> isHave = new HashSet<>();
        for (String allElement : allElements) {
            for (int j = 0; j < numbers.size(); j++) {
                for (int t = 0; t < numbers.size(); t++) {
                    if (t != j) {
                        if (!isHave.contains(numbers.get(j)) && !isHave.contains(numbers.get(t)))
                            if (allElement.equals(numbers.get(j) + numbers.get(t))) {
                                isHave.add(numbers.get(j));
                                isHave.add(numbers.get(t));
                                times += 2;
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
