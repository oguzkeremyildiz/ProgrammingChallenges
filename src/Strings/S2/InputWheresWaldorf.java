package Strings.S2;/* Created by oguzkeremyildiz on 8.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputWheresWaldorf {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("1\n");
            outfile.write("8 ");
            outfile.write("11\n");
            outfile.write("a b c D E F G h i g g\n");
            outfile.write("h E b k W a l D o r k\n");
            outfile.write("F t y A w a l d O R m\n");
            outfile.write("F t s i m r L q s r c\n");
            outfile.write("b y o A r B e D e y v\n");
            outfile.write("K l c b q w i k o m k\n");
            outfile.write("s t r E B G a d h r b\n");
            outfile.write("y U i q l x c n B j f\n");
            outfile.write("4\n");
            outfile.write("Waldorf\n");
            outfile.write("Bambi\n");
            outfile.write("Betty\n");
            outfile.write("Dagbert\n");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Waldorf.txt");
    }
}
