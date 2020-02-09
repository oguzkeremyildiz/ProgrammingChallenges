package Strings.S3;/* Created by oguzkeremyildiz on 9.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
/*
*I tested how fast the program worked by selecting random letters from the alphabet
 */
public class InputCommonPermutation {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            Random random = new Random();
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            for (int i = 0; i < 1000; i++){
                outfile.write(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            outfile.write("\n");
            for (int i = 0; i < 1000; i++){
                outfile.write(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Permutation.txt");
    }
}
