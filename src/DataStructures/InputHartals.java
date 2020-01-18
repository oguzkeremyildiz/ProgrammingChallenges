package DataStructures;/* Created by oguzkeremyildiz on 18.01.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class InputHartals {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
            outfile = new BufferedWriter(writer);
            outfile.write("2 \n");
            outfile.write("14 \n");
            outfile.write("3 \n");
            outfile.write("3 \n");
            outfile.write("4 \n");
            outfile.write("8 \n");
            outfile.write("100 \n");
            outfile.write("4 \n");
            outfile.write("12 \n");
            outfile.write("15 \n");
            outfile.write("25 \n");
            outfile.write("40 \n");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Hartals.txt");
    }
}
