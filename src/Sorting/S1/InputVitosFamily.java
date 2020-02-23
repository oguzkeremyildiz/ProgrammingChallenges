package Sorting.S1;/* Created by oguzkeremyildiz on 22.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputVitosFamily {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("500\n");
            for (int j = 1; j <= 500; j++){
                outfile.write("30000 ");
                for (int i = 1; i <= 30000; i++){
                    outfile.write(i + " ");
                }
                outfile.write("\n");
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Vito.txt");
    }
}
