package DataStructures.D4;/* Created by oguzkeremyildiz on 19.01.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputCryptKicker {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("6 \n");
            outfile.write("and \n");
            outfile.write("dick \n");
            outfile.write("jane \n");
            outfile.write("puff \n");
            outfile.write("spot \n");
            outfile.write("yertle \n");
            outfile.write("bjvg xsb hxsn xsb qymm xsb rqat xsb pnetfn \n");
            outfile.write("xxxx yyy zzzz www yyyy aaa bbbb ccc dddddd \n");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Crypt.txt");
    }
}
