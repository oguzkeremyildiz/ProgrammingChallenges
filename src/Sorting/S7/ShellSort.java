package Sorting.S7;/* Created by oguzkeremyildiz on 14.03.2020 */

import java.io.File;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class ShellSort {
    private static void print(LinkedHashSet<String> elements, LinkedList<String> sortedList){
        for (int i = 0; i < sortedList.size(); i++) {
            if (elements.contains(sortedList.get(sortedList.size() - 1 - i))){
                System.out.println(sortedList.get(sortedList.size() - 1 - i));
            }
        }
    }
    private static void swapToFirst(int index, LinkedList<String> turtles){
        String turtle = turtles.get(index);
        turtles.remove(index);
        turtles.addFirst(turtle);
    }
    private static void editList(LinkedList<String> turtle, LinkedList<String> sortedTurtle){
        LinkedHashSet<String> elements = new LinkedHashSet<>();
        while (!turtle.equals(sortedTurtle)){
            for (int i = 0; i < turtle.size(); i++) {
                if (!turtle.get(turtle.size() - 1 - i).equals(sortedTurtle.get(sortedTurtle.size() - 1 - i))){
                    elements.add(turtle.get(turtle.size() - 1 - i));
                    swapToFirst(turtle.size() - 1 - i, turtle);
                    break;
                }
            }
        }
        if (turtle.equals(sortedTurtle)){
            print(elements, sortedTurtle);
        }
    }
    public static void main(String[]args){
        try {
            LinkedList<String> turtle = new LinkedList<>();
            LinkedList<String> sortedTurtle = new LinkedList<>();
            Scanner source = new Scanner(new File("Turtles.txt"));
            String timesString = source.nextLine();
            int times = Integer.parseInt(timesString);
            String line;
            for (int i = 0; i < times; i++) {
                turtle.clear();
                sortedTurtle.clear();
                String turtlesString = source.nextLine();
                int turtles = Integer.parseInt(turtlesString);
                for (int j = 0; j < turtles * 2; j++) {
                    if (j > turtles - 1){
                        line = source.nextLine();
                        sortedTurtle.add(line);
                    } else {
                        line = source.nextLine();
                        turtle.add(line);
                    }
                }
                editList(turtle, sortedTurtle);
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
