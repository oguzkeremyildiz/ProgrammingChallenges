import java.util.ArrayList;
import java.util.Scanner;

public class LCDDisplay {
    public static void print(int alan, String [][] bolge, ArrayList<Integer> basamakTers){
        for (int m = 0; m < basamakTers.size(); m++){
            if (basamakTers.get(m) == 1){
                if (m == 0){
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                }
                if (m != 0){
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + (alan + 1)] = "|";
                    }
                }
                for (int d = alan + 3; d < (2 * alan) + 3; d++){
                    bolge[d - 1][m * (alan + 2) + (alan + 1)] = "|";
                }
            }
            if (basamakTers.get(m) == 2){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][0] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 3){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 4){
                if (m == 0){
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                }
                if (m != 0){
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                }
            }
            if (basamakTers.get(m) == 5){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 6){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2)  ] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 7){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + alan + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                }
            }
            if (basamakTers.get(m) == 8){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2)  ] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 9){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][i + 1] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + alan + 1] = "|";
                    }
                    for (int i = 0; i < alan; i++){
                        bolge[alan + 1][m * (alan + 2) + i + 2] = "-";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
            if (basamakTers.get(m) == 0){
                if (m == 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][t + 1] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][0] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][alan + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2)  ] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][alan + 1] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][z + 1] = "-";
                    }
                }
                if (m != 0){
                    for (int t = 0; t < alan; t++){
                        bolge[0][m * (alan + 2) + t + 2] = "-";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1] = "|";
                    }
                    for (int k = 1; k < alan + 1; k++){
                        bolge[k][m * (alan + 2) + 1 + alan + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1] = "|";
                    }
                    for (int d = alan + 3; d < (2 * alan) + 3; d++){
                        bolge[d - 1][m * (alan + 2) + 1 + (alan + 1)] = "|";
                    }
                    for (int z = 0; z < alan; z++){
                        bolge[(2 * alan) + 2][m * (alan + 2) + z + 2] = "-";
                    }
                }
            }
        }
        for (int i = 0; i < bolge.length; i++){
            for (int j = 0; j < bolge[0].length; j++){
                System.out.print(bolge[i][j]);
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
            gecici = 0;
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
            for (int i = 0; i < bolge.length; i++){
                for (int j = 0; j < bolge[0].length; j++){
                    bolge[i][j] = " ";
                }
            }
            print(alan, bolge, basamakTers);
        }
    }
}
