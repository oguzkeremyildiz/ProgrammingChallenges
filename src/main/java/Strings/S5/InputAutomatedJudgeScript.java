package Strings.S5;/* Created by oguzkeremyildiz on 13.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputAutomatedJudgeScript {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is: 5\n");
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is: 5\n");
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is: 5\n");
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is: 15\n");
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is:  5\n");
            outfile.write("2\n");
            outfile.write("The answer is: 10\n");
            outfile.write("The answer is: 5\n");
            outfile.write("3\n");
            outfile.write("Input Set# 1: YES\n");
            outfile.write("Input Set# 2: NO\n");
            outfile.write("Input Set# 3: NO\n");
            outfile.write("3\n");
            outfile.write("Input Set# 0: YES\n");
            outfile.write("Input Set# 1: NO\n");
            outfile.write("Input Set# 2: NO\n");
            outfile.write("1\n");
            outfile.write("1 0 1 0\n");
            outfile.write("1\n");
            outfile.write("1010\n");
            outfile.write("1\n");
            outfile.write("The judges are mean!\n");
            outfile.write("1\n");
            outfile.write("The judges are good!\n");
            outfile.write("0\n");
            outfile.write("0");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("Script.txt");
    }
}
