package Strings.S6;/* Created by oguzkeremyildiz on 13.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputFileFragmentation {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("011\n");
            outfile.write("0111\n");
            outfile.write("01110\n");
            outfile.write("111\n");
            outfile.write("0111\n");
            outfile.write("10111");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("FileFragmentation.txt");
    }
}
