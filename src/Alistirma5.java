import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alistirma5 {
    private  static void blackKnight(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'n'){
            if (sayi1 - 2 >= 0 && sayi2 + 1 < tahta[0].length) {
                if (tahta[sayi1 - 2][sayi2 + 1] == 'K'){ // sağ üst
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 - 2 >= 0 && sayi2 - 1 >= 0) {
                if (tahta[sayi1 - 2][sayi2 - 1] == 'K'){ // sol üst
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 - 1 >= 0 && sayi2 - 2 >= 0) {
                if (tahta[sayi1 - 1][sayi2 - 2] == 'K'){ // sol üst alt
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 - 1 >= 0 && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 - 1][sayi2 + 2] == 'K'){ // sağ üst alt
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 + 1][sayi2 + 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 + 1][sayi2 + 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 + 2 < tahta.length && sayi2 - 1 >= 0) {
                if (tahta[sayi1 + 2][sayi2 - 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 - 2 >= 0) {
                if (tahta[sayi1 + 1][sayi2 - 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
        }
    }
    private  static void whiteKnight(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'N'){
            if (sayi1 - 2 >= 0 && sayi2 + 1 < tahta[0].length) {
                if (tahta[sayi1 - 2][sayi2 + 1] == 'k'){ // sağ üst
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 - 2 >= 0 && sayi2 - 1 >= 0) {
                if (tahta[sayi1 - 2][sayi2 - 1] == 'k'){ // sol üst
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 - 1 >= 0 && sayi2 - 2 >= 0) {
                if (tahta[sayi1 - 1][sayi2 - 2] == 'k'){ // sol üst alt
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 - 1 >= 0 && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 - 1][sayi2 + 2] == 'k'){ // sağ üst alt
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 + 1][sayi2 + 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 + 2 < tahta[0].length) {
                if (tahta[sayi1 + 1][sayi2 + 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 + 2 < tahta.length && sayi2 - 1 >= 0) {
                if (tahta[sayi1 + 2][sayi2 - 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 + 1 < tahta.length && sayi2 - 2 >= 0) {
                if (tahta[sayi1 + 1][sayi2 - 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
        }
    }
    private  static void blackPawn(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'p'){
            if (sayi1 - 1 > 0 && sayi2 - 1 > 0) {
                if (tahta[sayi1 - 1][sayi2 - 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (sayi1 - 1 > 0 && sayi2 + 1 < tahta[0].length) {
                if (tahta[sayi1 - 1][sayi2 + 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
        }
    }
    private  static void whitePawn(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'P'){
            if (sayi1 - 1 > 0 && sayi2 - 1 > 0) {
                if (tahta[sayi1 - 1][sayi2 - 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (sayi1 - 1 > 0 && sayi2 + 1 < tahta[0].length) {
                if (tahta[sayi1 - 1][sayi2 + 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
        }
    }
    private static void blackQueen(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'q'){
            int k = 1;
            while (sayi2 + k < tahta[0].length){
                if (tahta[sayi1][sayi2 + k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            int t = 1;
            while (sayi1 + t < tahta.length){
                if (tahta[sayi1 + t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 + t][sayi2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            k = 1;
            while (sayi2 - k >= 0){
                if (tahta[sayi1][sayi2 - k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            while (sayi1 - t >= 0){
                if (tahta[sayi1 - t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 - t][sayi2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 + t < tahta.length && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 + t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 - t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 - k >= 0){
                if (tahta[sayi1 - t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 + t < tahta.length && sayi2 - k >= 0){
                if (tahta[sayi1 + t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteQueen(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'Q'){
            int k = 1;
            while (sayi2 + k < tahta[0].length){
                if (tahta[sayi1][sayi2 + k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            int t = 1;
            while (sayi1 + t < tahta.length){
                if (tahta[sayi1 + t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 + t][sayi2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            k = 1;
            while (sayi2 - k >= 0){
                if (tahta[sayi1][sayi2 - k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            while (sayi1 - t >= 0){
                if (tahta[sayi1 - t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 - t][sayi2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 + t < tahta.length && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 + t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 - t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 - k >= 0){
                if (tahta[sayi1 - t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 + t < tahta.length && sayi2 - k >= 0){
                if (tahta[sayi1 + t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void blackRook(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'r'){
            int x = 1;
            while (sayi2 + x < tahta[0].length){
                if (tahta[sayi1][sayi2 + x] == '.'){
                    x++;
                } else {
                    if (tahta[sayi1][sayi2 + x] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'r'){
            int y = 1;
            while (sayi1 + y < tahta.length){
                if (tahta[sayi1 + y][sayi2] == '.'){
                    y++;
                } else {
                    if (tahta[sayi1 + y][sayi2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'r'){
            int k = 1;
            while (sayi2 - k >= 0){
                if (tahta[sayi1][sayi2 - k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'r'){
            int t = 1;
            while (sayi1 - t >= 0){
                if (tahta[sayi1 - t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 - t][sayi2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteRook(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'R'){
            int k = 1;
            while (sayi2 + k < tahta[0].length){
                if (tahta[sayi1][sayi2 + k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'R'){
            int t = 1;
            while (sayi1 + t < tahta.length){
                if (tahta[sayi1 + t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 + t][sayi2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'R'){
            int k = 1;
            while (sayi2 - k >= 0){
                if (tahta[sayi1][sayi2 - k] == '.'){
                    k++;
                } else {
                    if (tahta[sayi1][sayi2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (tahta[sayi1][sayi2] == 'R'){
            int t = 1;
            while (sayi1 - t >= 0){
                if (tahta[sayi1 - t][sayi2] == '.'){
                    t++;
                } else {
                    if (tahta[sayi1 - t][sayi2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteBishop(char[][] tahta, int sayi1, int sayi2){
                if (tahta[sayi1][sayi2] == 'B'){
                    int t = 1;
                    int k = 1;
                    while (sayi1 + t < tahta.length && sayi2 + k < tahta[0].length){
                        if (tahta[sayi1 + t][sayi2 + k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (tahta[sayi1 + t][sayi2 + k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (sayi1 - t >= 0 && sayi2 + k < tahta[0].length){
                        if (tahta[sayi1 - t][sayi2 + k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (tahta[sayi1 - t][sayi2 + k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (sayi1 - t >= 0 && sayi2 - k >= 0){
                        if (tahta[sayi1 - t][sayi2 - k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (tahta[sayi1 - t][sayi2 - k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (sayi1 + t < tahta.length && sayi2 - k >= 0){
                        if (tahta[sayi1 + t][sayi2 - k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (tahta[sayi1 + t][sayi2 - k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                }

    }
    private static void blackBishop(char[][] tahta, int sayi1, int sayi2){
        if (tahta[sayi1][sayi2] == 'b'){
            int t = 1;
            int k = 1;
            while (sayi1 + t < tahta.length && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 + t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 + k < tahta[0].length){
                if (tahta[sayi1 - t][sayi2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 - t >= 0 && sayi2 - k >= 0){
                if (tahta[sayi1 - t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 - t][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (sayi1 + t < tahta.length && sayi2 - k >= 0){
                if (tahta[sayi1 + t][sayi2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (tahta[sayi1 + t][sayi2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }

    }
    public static void main(String[]args){
        int count = 0;
        try {
            Scanner kaynak = new Scanner(new File("Satranc.txt"));
            while (true){
                int tahta1 = kaynak.nextInt();
                int tahta2 = kaynak.nextInt();
                if (tahta1 == 0 && tahta2 == 0){
                    break;
                }
                char[][] tahta = new char[tahta1][tahta2];
                for (int i = 0; i < tahta.length; i++){
                    String satir = kaynak.next();
                    for (int j = 0; j < tahta[0].length; j++){
                        tahta[i][j] = satir.charAt(j);
                    }
                }

                for (int z = 0; z < tahta.length; z++){
                    for (int t = 0; t < tahta[0].length; t++){
                        whiteBishop(tahta, z, t);
                        blackBishop(tahta, z, t);
                        whiteRook(tahta, z, t);
                        blackRook(tahta, z, t);
                        whiteQueen(tahta, z, t);
                        blackQueen(tahta, z, t);
                        whitePawn(tahta, z, t);
                        blackPawn(tahta, z, t);
                        whiteKnight(tahta, z, t);
                        blackKnight(tahta, z, t);
                    }
                }
                count++;
                System.out.println(count);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
