import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alistirma4 {
    private static void solTaraf(int sayi1, int sayi2, int[][] carpi){
        if (sayi2 - 1 > -1){
            carpi[sayi1][sayi2 - 1]++;
        }
    }

    private static void ustTaraf(int sayi1, int sayi2, int[][] carpi){
        if (sayi1 - 1 > -1){
            carpi[sayi1 - 1][sayi2]++;
        }
    }

    private static void solUstTaraf(int sayi1, int sayi2, int[][] carpi){
        if (sayi1 - 1 > -1 && sayi2 - 1 > -1){
            carpi[sayi1 - 1][sayi2 - 1]++;
        }
    }

    private static void altTaraf(int sayi1, int sayi2, int[][] carpi, int[][] bolge){
        if (sayi1 + 1 < bolge.length){
            carpi[sayi1 + 1][sayi2]++;
        }
    }

    private static void sagTaraf(int sayi1, int sayi2, int[][] carpi, int[][] bolge){
        if (sayi2 + 1 < bolge[0].length){
            carpi[sayi1][sayi2 + 1]++;
        }
    }

    private static void sagUstTaraf(int sayi1, int sayi2, int[][] carpi, int[][] bolge){
        if (sayi1 - 1 > -1 && sayi2 + 1 < bolge[0].length){
            carpi[sayi1 - 1][sayi2 + 1]++;
        }
    }

    private static void sagAltTaraf(int sayi1, int sayi2, int[][] carpi, int[][] bolge){
        if (sayi1 + 1 < bolge.length && sayi2 + 1 < bolge[0].length){
            carpi[sayi1 + 1][sayi2 + 1]++;
        }
    }

    private static void solAltTaraf(int sayi1, int sayi2, int[][] carpi, int[][] bolge){
        if (sayi1 + 1 < bolge.length && sayi2 - 1 > -1){
            carpi[sayi1 + 1][sayi2 - 1]++;
        }
    }

    public static void main(String[]args){
        int count = 0;
        try {
            Scanner kaynak = new Scanner(new File("MayinTarlasi.txt"));

            while (true){
                int bolge1 = kaynak.nextInt();
                int bolge2 = kaynak.nextInt();
                if (bolge1 == 0 && bolge2 == 0){
                    break;
                }
                int[][] bolge = new int[bolge1][bolge2];
                int[][] carpi = new int[bolge1][bolge2];
                count += 1;
                System.out.println(count);
                String satir;
                for (int t = 0; t < bolge.length; t++){
                    satir = kaynak.next();
                    for (int j = 0; j < bolge[0].length; j++){
                            if (satir.charAt(j) == '*'){
                                bolge[t][j] = 1;
                            }
                    }
                }
                for (int z = 0; z < bolge.length; z++){
                    for (int k = 0; k < bolge[0].length; k++){
                        if (bolge[z][k] == 1){
                            solTaraf(z ,k, carpi);
                            sagTaraf(z, k, carpi, bolge);
                            sagUstTaraf(z,k,carpi,bolge);
                            solUstTaraf(z,k,carpi);
                            ustTaraf(z, k, carpi);
                            altTaraf(z,k,carpi,bolge);
                            sagAltTaraf(z,k,carpi,bolge);
                            solAltTaraf(z,k,carpi,bolge);
                        }
                    }
                }
                for (int t = 0; t < bolge.length; t++){
                    for (int j = 0; j < bolge[0].length; j++){
                        if (bolge[t][j] == 1) {
                            System.out.print("*");
                        }else {
                            System.out.print(carpi[t][j]);
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
