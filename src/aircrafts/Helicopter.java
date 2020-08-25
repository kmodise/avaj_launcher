package aircrafts;

import tower.Coordinates;
import tower.Flyable;
import writetofile.WriteToFile;
import tower.WeatherTower;

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){super(name, coordinates);}

	public void uptateConditions(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = 0;
		int latitude = 0;
		int height = 0;
		
		WriteToFile.puttofile("Helicopter#"+this.name+"("+this.id+") : ");
		switch(weather) {
			case "SUN":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 10;
				height = this.coordinates.getHeight() + 2;
				WriteToFile.puttofile("the sun is shining your cool.");
			break;
			case "RAIN":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 5;
				height = this.coordinates.getHeight();
				WriteToFile.puttofile("i hope you have doors on that thing.");
			break;
			case "FOG":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 1;
				height = this.coordinates.getHeight();
				WriteToFile.puttofile("I JUST GOT A MIND FOG.");
			break;
			case "SNOW":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 7;
				WriteToFile.puttofile("HAVE YOU TRAID YELLOW SNOW.");
			break;
		}
		if (height > 100)height = 100;
		if (height < 1){
			WriteToFile.puttofileln("\nHelicopter#"+name+"("+id+") : Landing");
			this.weatherTower.unregister(this);
			return ;}
		WriteToFile.puttofileln(" weather condition : weather");
		this.coordinates = new Coordinates(longitude, latitude, height);	
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		WriteToFile.puttofile("Helicopter#"+name+"("+id+") : ");
	}

}