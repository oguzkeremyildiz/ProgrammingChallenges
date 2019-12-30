package GettingStarted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AustralianVoting {
    private static void secilen(int[][] oy){
        double[] ilkBolum = new double[oy[0].length];
        ArrayList<Double> enKucuk = new ArrayList<>();
        int i = 0;
        ArrayList<Double> simdiki = new ArrayList<>();
        while (simdiki.size() < ilkBolum.length / 2){
            for (int j = 0; j < oy[0].length; j++){
                if (enKucuk.size() > 0){
                    if (oy[i][j] == enKucuk.get(0)) {
                        ilkBolum[j] = oy[i + 1][j];
                    }else {
                        ilkBolum[j] = oy[i][j];
                    }
                }else {
                    ilkBolum[j] = oy[i][j];
                }
            }
            for (int k = 0; k < ilkBolum.length; k++){
                simdiki.add(ilkBolum[k]);
                for (int z = 0; z < ilkBolum.length; z++){
                    if (k != z){
                        if (ilkBolum[k] == ilkBolum[z]){
                            simdiki.add(ilkBolum[z]);
                        }
                    }
                    if (z == ilkBolum.length - 1){
                        if (simdiki.size() >= ilkBolum.length / 2.0){
                            System.out.println(simdiki.get(0) + " Aday kazandı");
                            return;
                        }else {
                            if (k == 0){
                                enKucuk.addAll(simdiki);
                            } else {
                                if (simdiki.size() < enKucuk.size()){
                                    enKucuk.clear();
                                    enKucuk.addAll(simdiki);
                                }
                            }
                            simdiki.clear();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[]args){
        try {
            Scanner kaynak = new Scanner(new File("Voting.txt"));
            while (true){
                int ilkSatir = kaynak.nextInt();
                int ikinciSatir = kaynak.nextInt();
                if (ilkSatir == 0 && ikinciSatir == 0){
                    break;
                }
                int[][] oy = new int[ilkSatir][ikinciSatir];
                for (int j = 0; j < oy[0].length; j++){
                    for (int i = 0; i < oy.length; i++){
                        oy[i][j] = kaynak.nextInt();
                    }
                }
                secilen(oy);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
