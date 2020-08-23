package aircrafts;

import tower.Coordinates;
import tower.Flyable;
import tower.WeatherTower;
import tower.Coordinates;
import writetofile.WriteToFile;

class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower; 

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void uptadeConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = 0;
		int latitude = 0;
		int height = 0;

		WriteToFile.puttofile("JetPlane#"+this.name+"("+this.id+") : ");
		switch(weather) {
			case "SUN":
				longitude = this.coordinates.getLongitude() + 10;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() + 2;
				WriteToFile.puttofile("Im am cutting through the sky.");
			break;
			case "RAIN":
				longitude = this.coordinates.getLongitude() + 5;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				WriteToFile.puttofile("Im cutting through water i am like a dolphin.");
			break;
			case "FOG":
				longitude = this.coordinates.getLongitude() + 1;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				WriteToFile.puttofile("I can't see shit i hope there are no idiots fling in baloon.");
			break;
			case "SNOW":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 12;
				WriteToFile.puttofile("i blame amarica for this design flaw.");
			break;
		}
		if (height > 100)height = 100;
		if (height < 1){
			WriteToFile.puttofileln("\nJetPlane#"+name+"("+id+") Landing");
			this.weatherTower.unregister(this);
			return ;}
		WriteToFile.puttofileln(" weather condition : weather");
		this.coordinates = new Coordinates(longitude, latitude, height);
    }

    @Override
    public void registerTower(WeatehrTower WeatehrTower) {
        // TODO Auto-generated method stub
        
    }
}