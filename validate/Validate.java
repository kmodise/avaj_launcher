package validate;

import java.util.ArrayList;

public class Validate {
    private String AirCraftType;
    private String AirCraftName;
    private int Longitude;
    private int Latitude;
    private int Height;

    public  Validate(String FileLine) {

        String[] HoldFileData = FileLine.split(" ");
        if (HoldFileData.length != 5){
            System.out.println("Invalid File Format");
            System.exit(1);
        }


        if ((HoldFileData[0].length() < 1) || (HoldFileData[1].length() < 1) || (HoldFileData[2].length() < 1) || (HoldFileData[3].length() < 1) || (HoldFileData[4].length() < 1)) {
            System.out.println("invalid value");
            System.exit(1);
        }
        if ( HoldFileData[0].trim().equals("Helicopter") || HoldFileData[0].trim().equals("JetPlane") || HoldFileData[0].trim().equals("Baloon")) {
            AirCraftType = HoldFileData[0].trim();
        } else {
            System.out.println("Invalid aircraft type");
            System.exit(1);
        }
        AirCraftName = HoldFileData[1].trim();
        Longitude = Integer.parseInt(HoldFileData[2].trim());
        Latitude = Integer.parseInt(HoldFileData[3].trim());
        Height = Integer.parseInt(HoldFileData[4].trim());
        if (Latitude < 0 || Longitude < 0){
			System.out.println("invalid altitude longitude range");
			System.exit(1);
		}
        if (Height > 100)
                Height = 100;
    }

    public String getAirCraftType() {
        return (AirCraftType);
    }

    public String getAirCraftName() {
        return (AirCraftName);
    }

    public int getLongitude() {
        return (Longitude);
    }

    public int getLatitude() {
        return (Latitude);
    }

    public int getHeight() {
        return (Height);
    }
}