package simulator.aircrafts;
import java.io.BufferedReader;
import java.io.FileReader;

public class simulator {
    public static void main(String[] args){
        readerObject = new BufferedReader(new FileReader("./scenario.txt"));
        while(strLine = new readerObject.readLine() != null){
            System.out.println(strLine);
        }
    }
}