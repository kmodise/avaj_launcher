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

		int RunTime = Integer.parseInt(fileContentsObj.get(0));
		if (RunTime != 25) {
			System.out.println("Invalid Runtime");
			return;
		}
		ArrayList<Validate> InPutData;
		try {
			WeatherTower WeatherTower = new WeatherTower();
			int j = 0;

			Validate temp;

			InPutData =  ProcessFileContents.fileContents(fileContentsObj);
			System.out.println(InPutData);

			for (Validate i : InPutData) {
				System.out.println(i.getAirCraftName() + " " + i.getAirCraftType() + " " + i.getLongitude() + " " + i.getLatitude() + " " + i.getHeight());
				WeatherTower.register(newAircraft(i.getAirCraftName(), i.getAirCraftType(), i.getLongitude(),
						i.getLatitude(), i.getHeight()));
			}
			while (0 < RunTime--) {
				WeatherTower.conditionChanged();

			}
		} catch (Exception e) {
			return;
		}
	}
}
