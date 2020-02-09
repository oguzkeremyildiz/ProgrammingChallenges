package DataStructures.D2;/* Created by oguzkeremyildiz on 13.01.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputPokerHands {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("4 \n");
            outfile.write("2H \n");
            outfile.write("3D \n");
            outfile.write("5S \n");
            outfile.write("9C \n");
            outfile.write("KD \n");
            outfile.write("2C \n");
            outfile.write("3H \n");
            outfile.write("4S \n");
            outfile.write("8C \n");
            outfile.write("AH \n");
            outfile.write("2H \n");
            outfile.write("4S \n");
            outfile.write("4C \n");
            outfile.write("2D \n");
            outfile.write("4H \n");
            outfile.write("2S \n");
            outfile.write("8S \n");
            outfile.write("AS \n");
            outfile.write("QS \n");
            outfile.write("3S \n");
            outfile.write("2H \n");
            outfile.write("3D \n");
            outfile.write("5S \n");
            outfile.write("9C \n");
            outfile.write("KD \n");
            outfile.write("2C \n");
            outfile.write("3H \n");
            outfile.write("4S \n");
            outfile.write("8C \n");
            outfile.write("KH \n");
            outfile.write("2H \n");
            outfile.write("3D \n");
            outfile.write("5S \n");
            outfile.write("9C \n");
            outfile.write("KD \n");
            outfile.write("2D \n");
            outfile.write("3H \n");
            outfile.write("5C \n");
            outfile.write("9S \n");
            outfile.write("KH \n");

            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Poker.txt");
    }
}
