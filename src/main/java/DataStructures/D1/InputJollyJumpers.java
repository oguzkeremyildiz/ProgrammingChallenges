package DataStructures.D1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputJollyJumpers {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
                outfile.write("4 \n");
                outfile.write("1 \n");
                outfile.write("4 \n");
                outfile.write("2 \n");
                outfile.write("3 \n");
                outfile.write("5 \n");
                outfile.write("1 \n");
                outfile.write("4 \n");
                outfile.write("2 \n");
                outfile.write("-1 \n");
                outfile.write("6 \n");
                outfile.write("3 \n");
                outfile.write("2 \n");
                outfile.write("4 \n");
                outfile.write("3 \n");
                outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main (String[]args){
        saveAsXml("Jolly.txt");
    }
}
