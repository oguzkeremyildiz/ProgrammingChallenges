import java.util.ArrayList;
import java.util.Scanner;

public class TheTrip {
    public static void paraTransfer(ArrayList<Integer> paralar){
        int transfer = 0;
        int toplam = 0;

        for (Integer integer : paralar) {
            toplam += integer;
        }
        toplam = toplam / paralar.size();
        for (int z = 0; z < paralar.size(); z++){
            if (paralar.get(z) < toplam){
                transfer += toplam - paralar.get(z);
            }
            if (paralar.get(z) > toplam){
                paralar.set(z, toplam);
            }
        }
        System.out.println("$" + transfer / 100.00);
        paralar.clear();
    }
    public static void main(String[]args){
        Scanner girdi = new Scanner(System.in);
        ArrayList<Integer> paralar = new ArrayList<>();
        System.out.println("Kişi sayısını giriniz.");
        int sayi = girdi.nextInt();
        System.out.println("Paraları giriniz.");
        for (int i = 0; i < sayi; i++){
            paralar.add((int) (girdi.nextDouble() * 100));
        }
        paraTransfer(paralar);
        paralar.clear();
        while (sayi != 0){
            System.out.println("Kişi sayısını giriniz.");
            sayi = girdi.nextInt();
            if (sayi != 0){
                System.out.println("Paraları giriniz.");
                for (int i = 0; i < sayi; i++){
                    paralar.add((int) (girdi.nextDouble() * 100.00));
                }
                paraTransfer(paralar);
            }
        }
    }
}
