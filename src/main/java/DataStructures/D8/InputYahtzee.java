package DataStructures.D8;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class InputYahtzee {

    public static void saveAsXml(String fileName, int count, int seed) {
        Random random = new Random(seed);
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 13; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (k != 4) {
                            outfile.write(random.nextInt(6) + 1 + " ");
                        } else {
                            outfile.write(random.nextInt(6) + 1 + "");
                        }
                    }
                    outfile.write("\n");
                }
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Yahtzee.txt", 30, 1);
    }
}
