package DataStructures.D7;/* Created by oguzkeremyildiz on 29.01.2020 */

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ContestScoreboard {
    private static void print(HashMap<Integer, Integer> totalMinutes, HashMap<Integer, Integer> questions){
        int person;
        int minute;
        int value;
        for (int i = 0; i < totalMinutes.size(); i++){
            person = (int) totalMinutes.keySet().toArray()[i];
            minute = (int) totalMinutes.values().toArray()[i];
            value = (int) questions.values().toArray()[i];
            System.out.println(person);
            System.out.println(value);
            System.out.println(minute);
        }
    }
    private static void score(int person, int question, int minute, String type, HashMap<Integer, Integer> totalMinutes,  HashMap<Integer, Integer> questions){
        int currentMinute;
        int total;
        if (type.equals("I")){
            if (!totalMinutes.containsKey(person)){
                totalMinutes.put(person, 20);
            } else {
                currentMinute = totalMinutes.get(person) + 20;
                totalMinutes.put(person, currentMinute);
            }
        } else if (type.equals("C")){
            if (questions.containsKey(person)){
                total = questions.get(person) + 1;
                questions.put(person, total);
            } else {
                questions.put(person, 1);
            }
            if (!totalMinutes.containsKey(person)){
                totalMinutes.put(person, minute);
            } else {
                currentMinute = totalMinutes.get(person) + minute;
                totalMinutes.put(person, currentMinute);
            }
        }
    }
    public static void main(String[]args){
        try {
            int times;
            int person;
            int question;
            int minute;
            String type;
            Scanner source = new Scanner(new File("Scoreboard.txt"));
            times = source.nextInt();
            for (int i = 0; i < times; i++){
                HashMap<Integer, Integer> totalMinutes = new HashMap<>();
                HashMap<Integer, Integer> questions = new HashMap<>();
                while (source.hasNext()){
                    person = source.nextInt();;
                    question = source.nextInt();
                    minute = source.nextInt();
                    type = source.next();
                    score(person,question,minute,type,totalMinutes,questions);
                }
                print(totalMinutes,questions);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
