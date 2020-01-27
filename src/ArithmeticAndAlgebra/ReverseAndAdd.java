package ArithmeticAndAlgebra;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseAndAdd {
    public static int us(int x, int y){
        int result = 1;
        if (y == 0){
            return 1;
        } else {
            for (int i = 1; i <= y; i++){
                result *= x;
            }
        }
        return result;
    }

    public static void main (String[]args){
        Scanner girdi = new Scanner(System.in);
        int sayi = girdi.nextInt();
        int sayiT = sayi;
        int gecici;
        ArrayList<Integer> basamakTers = new ArrayList<>();
        while (sayi != 0){
            gecici = sayi % 10;
            sayi = (sayi - gecici) / 10;
            basamakTers.add(gecici);
        }
        int sayiTTers = 0;

        for (int i = 0; i < basamakTers.size(); i++){
            sayiTTers += basamakTers.get(basamakTers.size() - i - 1) * us(10,i);
        }
        int sonuc = sayiT + sayiTTers;
        System.out.println("toplam: " + sonuc);
    }
}
