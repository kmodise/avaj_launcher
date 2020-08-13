package simulator.aircrafts;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.logger;

public class simulator {
    public static void main(String[] args){
        try {
            // BufferedWriter bwObject = new BufferedWriter(new FileWriter("/home/the-kb/IdeaProjects/avaj_launcher/src/simulator/test.txt"));
            // bwObject.write("This is the first line\nsecond line!!!");
            BufferedReader brObject = new BufferedReader(new FileReader("/home/the-kb/IdeaProjects/avaj_launcher/src/simulator/scenario.txt"))
            brObject.close();
        } catch (IOException e) {

        }
}
}