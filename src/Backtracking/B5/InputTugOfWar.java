package Backtracking.B5;/* Created by oguzkeremyildiz on 12.04.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

public class InputTugOfWar {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("1\n");
            outfile.write("100\n");
            Random random = new Random(new Date().getTime());
            for (int i = 0; i < 100; i++) {
                outfile.write(random.nextInt(450) + 1 + "\n");
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("War.txt");
    }
}
