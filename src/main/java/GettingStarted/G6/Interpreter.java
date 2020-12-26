package GettingStarted.G6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {

    static int t = 0;

    public static void ram(int digit1, int digit2, int digit3, int[] register, int[] ram) {
            switch (digit1) {
                case 2:
                    register[digit2] = digit3;
                    t++;
                    break;
                case 3:
                    register[digit2] = (register[digit2] + digit3) % 1000;
                    t++;
                    break;
                case 4:
                    register[digit2] = (register[digit2] * digit3) % 1000;
                    t++;
                    break;
                case 5:
                    register[digit2] = register[digit3];
                    t++;
                    break;
                case 6:
                    register[digit2] = (register[digit2] + register[digit3]) % 1000;
                    t++;
                    break;
                case 7:
                    register[digit2] = (register[digit2] * register[digit3]) % 1000;
                    t++;
                    break;
                case 8:
                    register[digit2] = ram[register[digit3]];
                    t++;
                    break;
                case 9:
                    ram[register[digit3]] = register[digit2];
                    t++;
                    break;
                case 0:
                    if (register[digit3] != 0){
                        t = register[digit2];
                    } else {
                        t++;
                    }
                    break;
            }
    }

    public static void main(String[]args) {
        try {
            int [] register = new int[10];
            int count = 1;
            Scanner source = new Scanner(new File("Interpreter.txt"));
            int firstLine = Integer.parseInt(source.nextLine());
            int number;
            String line = source.nextLine();
            int j = 0;
            for (int i = 0; i < firstLine; i++) {
                int [] ram = new int[1000];
                while (source.hasNext()){
                    line = source.nextLine();
                    if (line.length() == 0){
                        break;
                    }
                    number = Integer.parseInt(line);
                    ram[j] = number;
                    j++;
                }
                t = 0;
                while (ram[t] != 100) {
                    int temporary;
                    ArrayList<Integer> digit = new ArrayList<>();
                    temporary = ram[t] / 100;
                    digit.add(temporary);
                    temporary = (ram[t] / 10) % 10;
                    digit.add(temporary);
                    temporary = ram[t] % 10;
                    digit.add(temporary);
                    ram(digit.get(digit.size() - 3), digit.get(digit.size() - 2), digit.get(digit.size() - 1), register, ram);
                    count++;
                }
                System.out.println(count);
                register = new int[10];
                j = 0;
                count = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}