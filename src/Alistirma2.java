import java.util.ArrayList;
import java.util.Scanner;

public class Alistirma2 {
    public static int sayiToplam(int sayi){
        int toplam = 0;
        if (sayi == 0){
            return 0;
        }else {
            for (int i = 1; i <= sayi; i++){
                toplam += i;
            }
        }
        return toplam;
    }
    public static void main(String[]args){
        Scanner girdi = new Scanner(System.in);
        int girdiSayisi = girdi.nextInt();
        for (int i = 1; i <= girdiSayisi; i++){
            int sayi1 = girdi.nextInt();
            int sayi2 = girdi.nextInt();
            int sayi = sayi2 - sayi1;
            int sayiYD = 0;
            ArrayList<Integer> kisaYol = new ArrayList<>();
            if (sayi2 > sayi1){
                while (sayi != 0){
                    while (sayiToplam(sayiYD) < sayi){
                        sayiYD++;
                        if (sayiToplam(sayiYD) < sayi){
                            if (sayiYD != 0){
                                sayi -= sayiYD;
                                kisaYol.add(sayiYD);
                            }
                        }
                    }while (sayiToplam(sayiYD) == sayi){
                        sayi -= sayiYD;
                        if (sayiYD != 0){
                            kisaYol.add(sayiYD);
                        }
                    }while (sayiToplam(sayiYD) > sayi){
                        sayiYD--;
                        if (sayiYD != 0){
                            sayi -= sayiYD;
                            kisaYol.add(sayiYD);
                        }
                    }
                }
            }
            System.out.print(kisaYol.size());
        }
    }
}
