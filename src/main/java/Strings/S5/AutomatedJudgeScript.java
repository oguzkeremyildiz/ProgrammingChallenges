package Strings.S5;/* Created by oguzkeremyildiz on 12.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AutomatedJudgeScript {
    private static void print(HashSet<Integer> outputs, int current){
        if (outputs.contains(3)){
            System.out.println("Run #" + current + ": Wrong Answer");
        } else if (outputs.contains(2)){
            System.out.println("Run #" + current + ": Presentation Error");
        } else if (outputs.contains(1)){
            System.out.println("Run #" + current + ": Accepted");
        }
    }
    private static boolean controlString(String correct, String answer){
        boolean bool = true;
        if (correct.length() != answer.length()){
            bool = false;
        } else {
            for (int i = 0; i < answer.length(); i++){
                if (answer.charAt(i) != correct.charAt(i)){
                    bool = false;
                    break;
                }
            }
        }
        return bool;
    }
    private static boolean controlIntegers(ArrayList<Integer> integersCorrect, ArrayList<Integer> integersAnswers){
        boolean bool = true;
        if (integersAnswers.size() == integersCorrect.size()){
            for (int i = 0; i < integersAnswers.size(); i++){
                if (!integersAnswers.get(i).equals(integersCorrect.get(i))){
                    bool = false;
                    break;
                }
            }
        } else {
            bool = false;
        }
        return bool;
    }
    private static void control(ArrayList<Integer> integersCorrect, ArrayList<Integer> integersAnswers, String correct, String answer, HashSet<Integer> outputs){
        if (integersAnswers.size() != 0 && integersCorrect.size() != 0){
            if (controlIntegers(integersCorrect, integersAnswers)){
                if (controlString(correct, answer)){
                    outputs.add(1);
                }
            }
        }
        if (controlIntegers(integersCorrect, integersAnswers)){
            if (!controlString(correct, answer)){
                outputs.add(2);
            }
        }
        if (!controlIntegers(integersCorrect, integersAnswers)){
            outputs.add(3);
        }
    }
    private static void convert(String inputs, ArrayList<Integer> integer){
        for (int i = 0; i < inputs.length(); i++){
            switch (inputs.charAt(i)){
                case '0':
                    integer.add(0);
                    break;
                case '1':
                    integer.add(1);
                    break;
                case '2':
                    integer.add(2);
                    break;
                case '3':
                    integer.add(3);
                    break;
                case '4':
                    integer.add(4);
                    break;
                case '5':
                    integer.add(5);
                    break;
                case '6':
                    integer.add(6);
                    break;
                case '7':
                    integer.add(7);
                    break;
                case '8':
                    integer.add(8);
                    break;
                case '9':
                    integer.add(9);
                    break;
            }
        }
    }
    public static void main(String[]args){
        try {
            int current = 0;
            int times = 1;
            String timesString;
            String inputs;
            HashSet<Integer> outputs = new HashSet<>();
            ArrayList<Integer> integersCorrect = new ArrayList<>();
            ArrayList<Integer> integersAnswers = new ArrayList<>();
            ArrayList<String> correct = new ArrayList<>();
            ArrayList<String> answer = new ArrayList<>();
            Scanner source = new Scanner(new File("Script.txt"));
            while (times != 0){
                current++;
                timesString = source.nextLine();
                times = Integer.parseInt(timesString);
                for (int i = 0; i < times; i++){
                    inputs = source.nextLine();
                    correct.add(inputs);
                }
                timesString = source.nextLine();
                times = Integer.parseInt(timesString);
                for (int j = 0; j < times; j++){
                    inputs = source.nextLine();
                    answer.add(inputs);
                }
                for (int i = 0; i < correct.size(); i++){
                    convert(correct.get(i), integersCorrect);
                    convert(answer.get(i), integersAnswers);
                    control(integersCorrect, integersAnswers, correct.get(i), answer.get(i), outputs);
                    integersCorrect.clear();
                    integersAnswers.clear();
                }
                print(outputs, current);
                correct.clear();
                answer.clear();
                outputs.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
