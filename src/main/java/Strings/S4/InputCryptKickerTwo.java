package Strings.S4;/* Created by oguzkeremyildiz on 10.02.2020 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class InputCryptKickerTwo {
    public static void saveAsXml(String fileName) {
        BufferedWriter outfile;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            outfile = new BufferedWriter(writer);
            outfile.write("vtz ud xnm xugm itr pyy jttk gmv xt otgm xt xnm puk ti xnm fprxq\n");
            outfile.write("xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj\n");
            outfile.write("frtjrpgguvj otvxmdxd prm iev prmvx xnmq");
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
    public static void main(String[]args){
        saveAsXml("CryptTwo.txt");
    }
}
