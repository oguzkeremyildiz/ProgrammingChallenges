package GettingStarted.G4;

import java.util.ArrayList;
import java.util.Scanner;

public class LCDDisplay {
    public static void ustTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int t = 0; t < alan; t++){
                bolge[0][t + 1] = "-";
            }
        } else {
            for (int t = 0; t < alan; t++){
                bolge[0][m * (alan + 2) + t + 2] = "-";
            }
        }
    }
    public static void solUstTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int k = 1; k < alan + 1; k++){
                bolge[k][0] = "|";
            }
        } else {
            for (int k = 1; k < alan + 1; k++){
                bolge[k][m * (alan + 2) + 1] = "|";
            }
        }
    }
    public static void sagUstTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int k = 1; k < alan + 1; k++){
                bolge[k][alan + 1] = "|";
            }
        } else {
            for (int k = 1; k < alan + 1; k++){
                bolge[k][m * (alan + 2) + 1 + (alan + 1)] = "|";
            }
        }
    }
    public static void ortaTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int i = 0; i < alan; i++){
                bolge[alan + 1][i + 1] = "-";
            }
        } else {
            for (int i = 0; i < alan; i++){
                bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
            }
        }
    }
    public static void solAltTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int d = alan + 3; d < (2 * alan) + 3; d++){
                bolge[d - 1][0] = "|";
            }
        } else {
            for (int d = alan + 3; d < (2 * alan) + 3; d++){
                bolge[d - 1][m * (alan + 2) + 1] = "|";
            }
        }
    }
    public static void sagAltTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int d = alan + 3; d < (2 * alan) + 3; d++){
                bolge[d - 1][alan + 1] = "|";
            }
        } else {
            for (int d = alan + 3; d < (2 * alan) + 3; d++){
                bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
            }
        }
    }
    public static void altTaraf(int alan, String [][] bolge, int m){
        if (m == 0){
            for (int z = 0; z < alan; z++){
                bolge[(2 * alan) + 2][z + 1] = "-";
            }
        } else {
            for (int z = 0; z < alan; z++){
                bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
            }
        }
    }
    public static void print(int alan, String [][] bolge, ArrayList<Integer> basamakTers){
        for (int m = 0; m < basamakTers.size(); m++){
            switch (basamakTers.get(m)){
                case 1:
                    sagUstTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    break;
                case 2:
                    ustTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    solAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 3:
                    ustTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 4:
                    solUstTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    break;
                case 5:
                    ustTaraf(alan,bolge,m);
                    solUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 6:
                    ustTaraf(alan,bolge,m);
                    solUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    solAltTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 7:
                    ustTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    break;
                case 8:
                    ustTaraf(alan,bolge,m);
                    solUstTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    solAltTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 9:
                    ustTaraf(alan,bolge,m);
                    solUstTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    ortaTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                case 0:
                    ustTaraf(alan,bolge,m);
                    solUstTaraf(alan,bolge,m);
                    sagUstTaraf(alan,bolge,m);
                    solAltTaraf(alan,bolge,m);
                    sagAltTaraf(alan,bolge,m);
                    altTaraf(alan,bolge,m);
                    break;
                default:
                    break;
            }
        }
        for (String[] strings : bolge) {
            for (int j = 0; j < bolge[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner girdi = new Scanner(System.in);
        int alan = girdi.nextInt();
        int sayi = girdi.nextInt();
        int gecici;
        ArrayList<Integer> basamak = new ArrayList<>();
        ArrayList<Integer> basamakTers = new ArrayList<>();
        while (sayi != 0){
            gecici = sayi % 10;
            sayi = (sayi - gecici) / 10;
            basamak.add(gecici);
        }
        for (int m = 0; m < basamak.size(); m++){
            basamakTers.add(basamak.get(basamak.size() - m - 1));
        }
        String [][] bolge = new String[(2 * alan) + 4][((alan + 2) * basamak.size()) + (basamak.size())];
        for (int i = 0; i < bolge.length; i++){
            for (int j = 0; j < bolge[0].length; j++){
                bolge[i][j] = " ";
            }
        }
            print(alan, bolge, basamakTers);
        while (alan != 0){
            alan = girdi.nextInt();
            sayi = girdi.nextInt();
            basamak = new ArrayList<>();
            basamakTers = new ArrayList<>();
            while (sayi != 0){
                gecici = sayi % 10;
                sayi = (sayi - gecici) / 10;
                basamak.add(gecici);
            }
            for (int m = 0; m < basamak.size(); m++){
                basamakTers.add(basamak.get(basamak.size() - m - 1));
            }
            bolge = new String[(2 * alan) + 4][((alan + 2) * basamak.size()) + (basamak.size())];
            if (alan != 0){
                for (int i = 0; i < bolge.length; i++){
                    for (int j = 0; j < bolge[0].length; j++){
                        bolge[i][j] = " ";
                    }
                }
                print(alan, bolge, basamakTers);
            }
        }
    }
}
