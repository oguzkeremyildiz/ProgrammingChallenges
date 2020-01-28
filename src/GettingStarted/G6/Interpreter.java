package GettingStarted.G6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    static int t = 0;

    public static void ram(int basamak1, int basamak2, int basamak3, int[] register, int[] ram){
            switch (basamak1){
                case 2:
                    register[basamak2] = basamak3;
                    t++;
                    break;
                case 3:
                    register[basamak2] = (register[basamak2] + basamak3) % 1000;
                    t++;
                    break;
                case 4:
                    register[basamak2] = (register[basamak2] * basamak3) % 1000;
                    t++;
                    break;
                case 5:
                    register[basamak2] = register[basamak3];
                    t++;
                    break;
                case 6:
                    register[basamak2] = (register[basamak2] + register[basamak3]) % 1000;
                    t++;
                    break;
                case 7:
                    register[basamak2] = (register[basamak2] * register[basamak3]) % 1000;
                    t++;
                    break;
                case 8:
                    register[basamak2] = ram[register[basamak3]];
                    t++;
                    break;
                case 9:
                    ram[register[basamak3]] = register[basamak2];
                    t++;
                    break;
                case 0:
                    if (register[basamak3] != 0){
                        t = register[basamak2];
                    } else {
                        t++;
                    }
                    break;
            }
    }
    public static void main(String[] args){
        try {
            int [] register = new int[10];
            int count = 1;
            Scanner kaynak = new Scanner(new File("Interpreter.txt"));
            int ilkSatir = Integer.parseInt(kaynak.nextLine());
            int sayi;
            String line = kaynak.nextLine();
            int j = 0;
            for (int i = 0; i < ilkSatir; i++){
                int [] ram = new int[1000];
                while (kaynak.hasNext()){
                    line = kaynak.nextLine();
                    if (line.length() == 0){
                        break;
                    }
                    sayi = Integer.parseInt(line);
                    ram[j] = sayi;
                    j++;
                }
                t = 0;
                while (ram[t] != 100){
                    int gecici;
                    ArrayList<Integer> basamak = new ArrayList<>();
                    gecici = ram[t] / 100;
                    basamak.add(gecici);
                    gecici = (ram[t] / 10) % 10;
                    basamak.add(gecici);
                    gecici = ram[t] % 10;
                    basamak.add(gecici);
                    ram(basamak.get(basamak.size() - 3), basamak.get(basamak.size() - 2), basamak.get(basamak.size() - 1), register, ram);
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}