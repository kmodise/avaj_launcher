
import java.io.IOException;

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){super(name, coordinates);}



	private String craftID()
	{
		return ("Jetplane#" + this.name + "(" + Long.toString(this.id) + "): ");
	}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = super.coordinates.getLongitude();
		int latitude = super.coordinates.getLatitude();
		int height = super.coordinates.getHeight();

		if (weather.equals("SUN"))
		{
			try {
				Simulation.writeToFile(craftID() + "SUN-> is there a way we could use that propeller as a fan? IT'S SO HOT!!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			latitude += 10;
	 		height  += 2;
		}
		else if (weather.equals("RAIN"))
		{
			try {
				Simulation.writeToFile(craftID()+"RAIN-> Why isn't the propeller chopping all this rain??!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			latitude += 5;
		}
		else if (weather.equals("FOG"))
		{
			try {
				Simulation.writeToFile(craftID()+"FOG-> Anyone has a sharingan TO see through this FOG?!!!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += 1;
		}
		else if (weather.equals("SNOW"))
		{
			try {
				Simulation.writeToFile(craftID()+"SNOW-> all that is missing is a beautiful angel amongst all this SNOW\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			height -= 7;
		}
		if (height > 100)
			height = 100;
		if (height <= 0)
		{
			weatherTower.unregister(this);
			try {
				Simulation.writeToFile("\nHelicopter#" + name + "(" + id + ") : Landing\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.coordinates = new Coordinates(longitude, latitude, height);
		
	}



	// public void updateCondition(){
	// 	String weather = this.weatherTower.getWeather(this.coordinates);

	// 	int longitude = 0;
	// 	int latitude = 0;
	// 	int height = 0;

	// 	try {
	// 		Simulation.writeToFile("Helicopter#"+this.name+"("+this.id+") : ");
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// 	if (weather.equals("SUN")) {
	// 		longitude = this.coordinates.getLongitude();
	// 		latitude = this.coordinates.getLatitude() + 10;
	// 		height = this.coordinates.getHeight() + 2;
	// 		try {
	// 			Simulation.writeToFile("is there a way we could use that propeller as a fan? IT'S SO HOT!!!\n");
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	if (weather.equals("RAIN")) {
	// 		longitude = this.coordinates.getLongitude();
	// 		latitude = this.coordinates.getLatitude() + 5;
	// 		height = this.coordinates.getHeight();
	// 		try {
	// 			Simulation.writeToFile("Why isn't the propeller chopping all this rain??!!\n");
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	if (weather.equals("FOG")) {
	// 		longitude = this.coordinates.getLongitude();
	// 		latitude = this.coordinates.getLatitude() + 1;
	// 		height = this.coordinates.getHeight();
	// 		try {
	// 			Simulation.writeToFile("Anyone has a sharingan TO see through this FOG?!!!\n");
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	if (weather.equals("SNOW")) {


	// 		longitude = this.coordinates.getLongitude();
	// 		latitude = this.coordinates.getLatitude();
	// 		height = this.coordinates.getHeight() - 7;
	// 		try {
	// 			Simulation.writeToFile("all that is missing is a beautiful angel amongst all this SNOW\n");
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}

	// 	if (height > 100)
	// 		height = 100;
	// 	if (height < 1){
	// 		try {
	// 			Simulation.writeToFile("\nHelicopter#"+name+"("+id+") : Landing\n");//ljd;lfjds;flkjdsflk
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 		this.weatherTower.unregister(this);
	// 		return ;
	// 	}
	// 	this.coordinates = new Coordinates(longitude, latitude, height);	
	// }

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		try {
			Simulation.writeToFile("Helicopter#"+name+"("+id+") : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}