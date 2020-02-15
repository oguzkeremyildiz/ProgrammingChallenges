package Strings.S6;/* Created by oguzkeremyildiz on 13.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class InputFileFragmentation {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        int size = 2000;
        try {
            int number;
            String fullNumbers = "";
            String divide;
            Random random = new Random();
            int randomDivide;
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            for (int i = 0; i < size; i++){
                number = random.nextInt(2);
                fullNumbers = fullNumbers + number;
            }
            for (int j = 0; j < 72; j++){
                randomDivide = random.nextInt(2000);
                divide = fullNumbers.substring(0, randomDivide);
                outfile.write(divide + "\n");
                divide = fullNumbers.substring(randomDivide, 2000);
                outfile.write(divide + "\n");
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("FileFragmentation.txt");
    }
}
