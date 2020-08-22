
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import aircrafts.aircraftFactory;

public class simulator {
    public static void main(String[] args) {
        try {
            // BufferedWriter bwObject = new BufferedWriter(new
            // FileWriter("/home/the-kb/IdeaProjects/avaj_launcher/src/simulator/test.txt"));
            // bwObject.write("This is the first line\nsecond line!!!");
            int i = 0;
            String K = null;
            String airCraftName = null;
            ArrayList<String> fileContents = new ArrayList<String>();

            FileReader fileReaderObject = new FileReader(
                    "C:\\Users\\the-kb\\Documents\\avaj_launcher\\src\\scenario.txt");
            BufferedReader buffReaderObject = new BufferedReader(fileReaderObject);

            while ((K = buffReaderObject.readLine()) != null) {
                fileContents.add(i, K);
            //    System.out.println(fileContents.get(i));
                i++;
            }
            
            buffReaderObject.close();
            aircraftFactory getAirCraftObject = new aircraftFactory();
            // airCraftName = getAirCraftObject.typeOfAirCraft({name of the class/method that'll split the'});
            if (airCraftName == null)
                System.exit(0);
            System.out.println("ads");

            // TODO: somewhere here is where the results will be writen to a file
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// private void name() {

// }