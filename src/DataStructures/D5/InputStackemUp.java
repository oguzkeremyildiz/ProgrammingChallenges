package DataStructures.D5;/* Created by oguzkeremyildiz on 22.01.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputStackemUp {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("1 \n");
            outfile.write("2 \n");
            outfile.write("2 \n");
            outfile.write("1 \n");
            outfile.write("3 \n");
            outfile.write("4 \n");
            outfile.write("5 \n");
            outfile.write("6 \n");
            outfile.write("7 \n");
            outfile.write("8 \n");
            outfile.write("9 \n");
            outfile.write("10 \n");
            outfile.write("11 \n");
            outfile.write("12 \n");
            outfile.write("13 \n");
            outfile.write("14 \n");
            outfile.write("15 \n");
            outfile.write("16 \n");
            outfile.write("17 \n");
            outfile.write("18 \n");
            outfile.write("19 \n");
            outfile.write("20 \n");
            outfile.write("21 \n");
            outfile.write("22 \n");
            outfile.write("23 \n");
            outfile.write("24 \n");
            outfile.write("25 \n");
            outfile.write("26 \n");
            outfile.write("27 \n");
            outfile.write("28 \n");
            outfile.write("29 \n");
            outfile.write("30 \n");
            outfile.write("31 \n");
            outfile.write("32 \n");
            outfile.write("33 \n");
            outfile.write("34 \n");
            outfile.write("35 \n");
            outfile.write("36 \n");
            outfile.write("37 \n");
            outfile.write("38 \n");
            outfile.write("39 \n");
            outfile.write("40 \n");
            outfile.write("41 \n");
            outfile.write("42 \n");
            outfile.write("43 \n");
            outfile.write("44 \n");
            outfile.write("45 \n");
            outfile.write("46 \n");
            outfile.write("47 \n");
            outfile.write("48 \n");
            outfile.write("49 \n");
            outfile.write("50 \n");
            outfile.write("52 \n");
            outfile.write("51 \n");
            outfile.write("52 \n");
            outfile.write("2 \n");
            outfile.write("3 \n");
            outfile.write("4 \n");
            outfile.write("5 \n");
            outfile.write("6 \n");
            outfile.write("7 \n");
            outfile.write("8 \n");
            outfile.write("9 \n");
            outfile.write("10 \n");
            outfile.write("11 \n");
            outfile.write("12 \n");
            outfile.write("13 \n");
            outfile.write("14 \n");
            outfile.write("15 \n");
            outfile.write("16 \n");
            outfile.write("17 \n");
            outfile.write("18 \n");
            outfile.write("19 \n");
            outfile.write("20 \n");
            outfile.write("21 \n");
            outfile.write("22 \n");
            outfile.write("23 \n");
            outfile.write("24 \n");
            outfile.write("25 \n");
            outfile.write("26 \n");
            outfile.write("27 \n");
            outfile.write("28 \n");
            outfile.write("29 \n");
            outfile.write("30 \n");
            outfile.write("31 \n");
            outfile.write("32 \n");
            outfile.write("33 \n");
            outfile.write("34 \n");
            outfile.write("35 \n");
            outfile.write("36 \n");
            outfile.write("37 \n");
            outfile.write("38 \n");
            outfile.write("39 \n");
            outfile.write("40 \n");
            outfile.write("41 \n");
            outfile.write("42 \n");
            outfile.write("43 \n");
            outfile.write("44 \n");
            outfile.write("45 \n");
            outfile.write("46 \n");
            outfile.write("47 \n");
            outfile.write("48 \n");
            outfile.write("49 \n");
            outfile.write("50 \n");
            outfile.write("51 \n");
            outfile.write("1 \n");
            outfile.write("1 \n");
            outfile.write("2 \n");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("deck.txt");
    }
}
