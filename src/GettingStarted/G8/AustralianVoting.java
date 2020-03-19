package GettingStarted.G8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AustralianVoting {
    private static void selected(int[][] vote){
        double[] firstSection = new double[vote[0].length];
        ArrayList<Double> smallest = new ArrayList<>();
        int i = 0;
        int t = 0;
        ArrayList<Double> current = new ArrayList<>();
        while (current.size() < firstSection.length / 2){
            for (int j = 0; j < vote[0].length; j++){
                if (smallest.size() > 0){
                    if (vote[i][j] == smallest.get(0)) {
                        firstSection[j] = vote[i + t][j];
                    }else {
                        firstSection[j] = vote[i][j];
                    }
                }else {
                    firstSection[j] = vote[i][j];
                }
            }
            for (int k = 0; k < firstSection.length; k++){
                current.add(firstSection[k]);
                for (int z = 0; z < firstSection.length; z++){
                    if (k != z){
                        if (firstSection[k] == firstSection[z]){
                            current.add(firstSection[z]);
                        }
                    }
                    if (z == firstSection.length - 1){
                        if (current.size() >= firstSection.length / 2.0){
                            System.out.println(current.get(0) + " candidate won.");
                            return;
                        }else {
                            if (k == 0){
                                smallest.addAll(current);
                            } else {
                                if (current.size() < smallest.size()){
                                    smallest.clear();
                                    smallest.addAll(current);
                                }
                            }
                            current.clear();
                        }
                    }
                }
            }
            t++;
        }
    }
    public static void main(String[]args){
        try {
            Scanner source = new Scanner(new File("Voting.txt"));
            while (true){
                int firstSection = source.nextInt();
                int secondSection = source.nextInt();
                if (firstSection == 0 && secondSection == 0){
                    break;
                }
                int[][] vote = new int[firstSection][secondSection];
                for (int j = 0; j < vote[0].length; j++){
                    for (int i = 0; i < vote.length; i++){
                        vote[i][j] = source.nextInt();
                    }
                }
                selected(vote);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
