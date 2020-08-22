package tower;

public class Coordinates {
    private int longitude;
    private int altitude;
    private int height;

    public Coordinates(int longitude, int altitude, int height){
        longitude = this.longitude;
        altitude = this.altitude;
        height = this.height;
    }

    public int getAltitude() {
        return altitude;
    }
    public int getLongitude() {
        return longitude;
    }
    public int getHeight(){
        return height;
    }
}