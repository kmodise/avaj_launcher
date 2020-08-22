package aircrafts;

import tower.Coordinates;

public abstract class aircraftFactory {
//name is IDsdfdfsd
    public static Flyable newAircraft(String type,String name, int longitute, int latitude,int height) {
        Coordinates coordinates = new Coordinates(longitute, latitude, height);

        // if (type == "Baloon")
        // {
        //     Helicopter Helicopter = new Helicopter(name, coordinates);
        //     return type;
        // }
            
        if (type == "JetPlane"){
            return new JetPlane(name, coordinates);
        }
            
        // if (type == "Helicopter")
        //     return type;
        // if (type == "Baloon")
        //     return type;
        return null;
    }
}