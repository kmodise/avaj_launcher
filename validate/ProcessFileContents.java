package validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ProcessFileContents {
    public static ArrayList<Validate> fileContents(Stack<String> AircraftDetails){
        Validate temp;
        ArrayList<Validate> processedDetails = new ArrayList<Validate>();
        Iterator<String> loopThrough = AircraftDetails.iterator();
        loopThrough.next();
        while (loopThrough.hasNext()) {
            temp = new Validate(loopThrough.next());
            processedDetails.add(temp);
        }
        return processedDetails;
    }
}
