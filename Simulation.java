import validate.ProcessFileContents;
import validate.Validate;

import java.util.*;

import java.io.*;

public class Simulation extends AircraftFactory {

	public static void writeToFile(String st) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", true));
		writer.write(st);
		writer.close();
	}

	public static void main(String[] args) {

		Stack<String> fileContentsObj = new Stack<>();

		if (args.length == 0) {
			System.err.println("NO ARGUMENTS");
			System.exit(1);
		}

		try {
			Scanner ScannerObj = new Scanner(new File(args[0]));
			while (ScannerObj.hasNext()) {
				fileContentsObj.push(ScannerObj.nextLine().trim());
			}
			ScannerObj.close();



		} catch (IOException e) {
			System.out.println("WRONG FILE");
		}

		int numberOfSim = Integer.parseInt(fileContentsObj.get(0));
		if (numberOfSim != 25) {
			System.out.println("Invalid numberOfSim");
			return;
		}
		ArrayList<Validate> ProcessedFileContents;
		try {
			WeatherTower WeatherTower = new WeatherTower();
		
			ProcessedFileContents =  ProcessFileContents.fileContents(fileContentsObj);
			System.out.println(ProcessedFileContents);

			for (Validate AircraftData : ProcessedFileContents) {
				WeatherTower.register(newAircraft(AircraftData.getAirCraftName(), AircraftData.getAirCraftType(), AircraftData.getLongitude(),
						AircraftData.getLatitude(), AircraftData.getHeight()));
			}
			while (0 < numberOfSim) {
				WeatherTower.conditionChanged();
				numberOfSim--;
			}
		} catch (Exception e) {
			return;
		}
	}
}
