import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alistirma3 {
    private static int kural(int sayi1, int sayi2){
        int enBuyuk = 0;
        int count = 0;
        if (sayi2 > sayi1){
            for (int i = sayi1; i <= sayi2; i++){
                int gecici = i;
                count++;
                while (gecici != 1){
                    if (gecici % 2 == 0){
                        gecici /= 2;
                        count++;
                    } else{
                        gecici *= 3;
                        gecici += 1;
                        count++;
                    }
                }
                if (count > enBuyuk){
                    enBuyuk = count;
                }
                count = 0;
            }
        }
        return enBuyuk;
    }

    public static void main(String[]args){
        int i = 0;
        ArrayList<Integer> sayi = new ArrayList<>();
        try {
            Scanner kaynak = new Scanner(new File("Sayilar.txt"));
            while (kaynak.hasNext()){
                i++;
                sayi.add(kaynak.nextInt());
                if (i % 2 == 0){
                    System.out.println(sayi.get(i - 2) + " " + sayi.get(i - 1) + " " + kural(sayi.get(i - 2), sayi.get(i - 1)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
