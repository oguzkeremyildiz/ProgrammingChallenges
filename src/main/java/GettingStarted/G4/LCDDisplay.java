package GettingStarted.G4;

import java.util.ArrayList;
import java.util.Scanner;

public class LCDDisplay {
    public static void upSide(int area, String [][] region, int m){
        if (m == 0){
            for (int t = 0; t < area; t++){
                region[0][t + 1] = "-";
            }
        } else {
            for (int t = 0; t < area; t++){
                region[0][m * (area + 2) + t + 2] = "-";
            }
        }
    }
    public static void leftUpSide(int area, String [][] region, int m){
        if (m == 0){
            for (int k = 1; k < area + 1; k++){
                region[k][0] = "|";
            }
        } else {
            for (int k = 1; k < area + 1; k++){
                region[k][m * (area + 2) + 1] = "|";
            }
        }
    }
    public static void rightUpSide(int area, String [][] region, int m){
        if (m == 0){
            for (int k = 1; k < area + 1; k++){
                region[k][area + 1] = "|";
            }
        } else {
            for (int k = 1; k < area + 1; k++){
                region[k][m * (area + 2) + 1 + (area + 1)] = "|";
            }
        }
    }
    public static void middleSide(int area, String [][] region, int m){
        if (m == 0){
            for (int i = 0; i < area; i++){
                region[area + 1][i + 1] = "-";
            }
        } else {
            for (int i = 0; i < area; i++){
                region[area + 1][m * (area + 2) + i + 2] = "-";
            }
        }
    }
    public static void leftUnderSide(int area, String [][] region, int m){
        if (m == 0){
            for (int d = area + 3; d < (2 * area) + 3; d++){
                region[d - 1][0] = "|";
            }
        } else {
            for (int d = area + 3; d < (2 * area) + 3; d++){
                region[d - 1][m * (area + 2) + 1] = "|";
            }
        }
    }
    public static void rightUnderSide(int area, String [][] region, int m){
        if (m == 0){
            for (int d = area + 3; d < (2 * area) + 3; d++){
                region[d - 1][area + 1] = "|";
            }
        } else {
            for (int d = area + 3; d < (2 * area) + 3; d++){
                region[d - 1][m * (area + 2) + 1 + (area + 1)] = "|";
            }
        }
    }
    public static void underSide(int area, String [][] region, int m){
        if (m == 0){
            for (int z = 0; z < area; z++){
                region[(2 * area) + 2][z + 1] = "-";
            }
        } else {
            for (int z = 0; z < area; z++){
                region[(2 * area) + 2][m * (area + 2) + z + 2] = "-";
            }
        }
    }
    public static void print(int area, String [][] region, ArrayList<Integer> digitReverse){
        for (int m = 0; m < digitReverse.size(); m++){
            switch (digitReverse.get(m)){
                case 1:
                    rightUpSide(area,region,m);
                    rightUnderSide(area,region,m);
                    break;
                case 2:
                    upSide(area,region,m);
                    rightUpSide(area,region,m);
                    middleSide(area,region,m);
                    leftUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 3:
                    upSide(area,region,m);
                    rightUpSide(area,region,m);
                    middleSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 4:
                    leftUpSide(area,region,m);
                    rightUpSide(area,region,m);
                    middleSide(area,region,m);
                    rightUnderSide(area,region,m);
                    break;
                case 5:
                    upSide(area,region,m);
                    leftUpSide(area,region,m);
                    middleSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 6:
                    upSide(area,region,m);
                    leftUpSide(area,region,m);
                    middleSide(area,region,m);
                    leftUnderSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 7:
                    upSide(area,region,m);
                    rightUpSide(area,region,m);
                    rightUnderSide(area,region,m);
                    break;
                case 8:
                    upSide(area,region,m);
                    leftUpSide(area,region,m);
                    rightUpSide(area,region,m);
                    middleSide(area,region,m);
                    leftUnderSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 9:
                    upSide(area,region,m);
                    leftUpSide(area,region,m);
                    rightUpSide(area,region,m);
                    middleSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                case 0:
                    upSide(area,region,m);
                    leftUpSide(area,region,m);
                    rightUpSide(area,region,m);
                    leftUnderSide(area,region,m);
                    rightUnderSide(area,region,m);
                    underSide(area,region,m);
                    break;
                default:
                    break;
            }
        }
        for (String[] strings : region) {
            for (int j = 0; j < region[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int region = input.nextInt();
        int number = input.nextInt();
        int temporary;
        ArrayList<Integer> digit = new ArrayList<>();
        ArrayList<Integer> digitReverse = new ArrayList<>();
        while (number != 0){
            temporary = number % 10;
            number = (number - temporary) / 10;
            digit.add(temporary);
        }
        for (int m = 0; m < digit.size(); m++){
            digitReverse.add(digit.get(digit.size() - m - 1));
        }
        String [][] area = new String[(2 * region) + 4][((region + 2) * digit.size()) + (digit.size())];
        for (int i = 0; i < area.length; i++){
            for (int j = 0; j < area[0].length; j++){
                area[i][j] = " ";
            }
        }
            print(region, area, digitReverse);
        while (region != 0){
            region = input.nextInt();
            number = input.nextInt();
            digit = new ArrayList<>();
            digitReverse = new ArrayList<>();
            while (number != 0){
                temporary = number % 10;
                number = (number - temporary) / 10;
                digit.add(temporary);
            }
            for (int m = 0; m < digit.size(); m++){
                digitReverse.add(digit.get(digit.size() - m - 1));
            }
            area = new String[(2 * region) + 4][((region + 2) * digit.size()) + (digit.size())];
            if (region != 0){
                for (int i = 0; i < area.length; i++){
                    for (int j = 0; j < area[0].length; j++){
                        area[i][j] = " ";
                    }
                }
                print(region, area, digitReverse);
            }
        }
    }
}
