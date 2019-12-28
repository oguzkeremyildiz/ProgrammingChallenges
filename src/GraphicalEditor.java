import java.util.Scanner;

public class GraphicalEditor {
    public static void print(String[][] bolge){
        for (String[] strings : bolge) {
            for (int j = 0; j < bolge[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    public static void charL(String [][] bolge){
        Scanner girdi = new Scanner(System.in);
        int sayi1 = girdi.nextInt();
        int sayi2 = girdi.nextInt();
        String harf = girdi.next();
        bolge[sayi2 - 1][sayi1 - 1] = harf;

    }

    public static void charS(String [][] bolge){
        Scanner girdi = new Scanner(System.in);
        String cumle = girdi.next();
        System.out.println(cumle);
        print(bolge);
        for (int i = 0; i < bolge.length; i++){
            for (int j = 0; j < bolge[0].length; j++){
                bolge[i][j] = "O";
            }
        }
    }

    public static void charFRecursive(String[][] bolge, int sayi1, int sayi2, String harf1, String harf2){
        if (bolge[sayi1][sayi2].equals(harf1)){
            bolge[sayi1][sayi2] = harf2;
            if (sayi1 > 0){
                charFRecursive(bolge, sayi1 - 1, sayi2, harf1, harf2);
            }
            if (sayi1 < bolge.length - 1){
                charFRecursive(bolge, sayi1 + 1, sayi2, harf1, harf2);
            }
            if (sayi2 > 0){
                charFRecursive(bolge, sayi1, sayi2 - 1, harf1, harf2);
            }
            if (sayi2 < bolge[0].length - 1){
                charFRecursive(bolge, sayi1, sayi2 + 1, harf1, harf2);
            }
        }
    }

    public static void charF(String[][] bolge){
        Scanner girdi = new Scanner(System.in);
        int sayi1 = girdi.nextInt();
        int sayi2 = girdi.nextInt();
        String harf = girdi.next();
        charFRecursive(bolge, sayi2 - 1, sayi1 - 1, bolge[sayi2 - 1][sayi1 - 1], harf);
    }

    public static void charV(String[][] bolge){
        Scanner girdi = new Scanner(System.in);
        int sayi1 = girdi.nextInt();
        int sayi2 = girdi.nextInt();
        int sayi3 = girdi.nextInt();
        String harf = girdi.next();
        for (int i = sayi2; i <= sayi3; i++){
            bolge[i - 1][sayi1 - 1] = harf;
        }
    }

    public static void charC(String[][] bolge){
        for (int i = 0; i < bolge.length; i++){
            for (int j = 0; j < bolge[0].length; j++){
                bolge[i][j] = "O";
            }
        }
    }

    public static void charH(String[][] bolge){
        Scanner girdi = new Scanner(System.in);
        int sayi1 = girdi.nextInt();
        int sayi2 = girdi.nextInt();
        int sayi3 = girdi.nextInt();
        String harf = girdi.next();
        for (int i = sayi1; i <= sayi2; i++){
            bolge[sayi3 - 1][i - 1] = harf;
        }
    }

    public static void charK(String[][] bolge){
        Scanner girdi = new Scanner(System.in);
        int X1 = girdi.nextInt();
        int Y1 = girdi.nextInt();
        int X2 = girdi.nextInt();
        int Y2 = girdi.nextInt();
        String harf = girdi.next();
        for (int i = X1; i <= X2; i++){
            for (int j = Y1; j <= Y2; j++){
                bolge[j - 1][i - 1] = harf;
            }
        }
    }
    public static void main(String []args){
        Scanner girdi = new Scanner(System.in);
        String[][] bolge = new String[0][0];
        String karakter = girdi.next();
        while (!karakter.equals("X")){
            switch (karakter) {
                case "I":
                    int bolge1 = girdi.nextInt();
                    int bolge2 = girdi.nextInt();
                    bolge = new String[bolge2][bolge1];
                    for (int i = 0; i < bolge.length; i++) {
                        for (int j = 0; j < bolge[0].length; j++) {
                            bolge[i][j] = "O";
                        }
                    }
                    break;
                case "L":
                    charL(bolge);
                    break;
                case "S":
                    charS(bolge);
                    break;
                case "F":
                    charF(bolge);
                    break;
                case "V":
                    charV(bolge);
                    break;
                case "C":
                    charC(bolge);
                    break;
                case "H":
                    charH(bolge);
                    break;
                case "K":
                    charK(bolge);
                    break;
                default:
                    break;
            }
            karakter = girdi.next();
        }
    }
}
