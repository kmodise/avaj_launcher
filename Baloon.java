import java.io.IOException;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){super(name, coordinates);}


	private String craftID()
	{
		return ("Ballon#" + this.name + "(" + Long.toString(this.id) + "): ");
	}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = super.coordinates.getLongitude();
		int latitude = super.coordinates.getLatitude();
		int height = super.coordinates.getHeight();
		
		if (weather.equals("SUN"))
		{
			try {
				Simulation.writeToFile(craftID() + "SUN-> It's so hot this balloon might POP\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += 2;
			height += 4;
		}
		else if (weather.equals("RAIN"))
		{
			try {
				Simulation.writeToFile(craftID()+"RAIN-> is there an umbrella in this BALLOON?!!!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += -5;
		}
		else if (weather.equals("FOG"))
		{
			try {
				Simulation.writeToFile(craftID()+"FOG-> FOG and BALLOONS don't mix!!!!!!!!!!!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += -1;
		}
		else if (weather.equals("SNOW"))
		{
			try {
				Simulation.writeToFile(craftID()+"SNOW-> Do you want to build a.... flying snowman?!!!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			height -= 15;
		}
		if (height > 100)
			height = 100;
		if (height <= 0)
		{
			weatherTower.unregister(this);
			try {
				Simulation.writeToFile("\nBalloon#" + name + "(" + id + ") : Landing\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.coordinates = new Coordinates(longitude, latitude, height);
		
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		try {
			Simulation.writeToFile("Balloon#"+name+"("+id+") : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}












// 	public void updateCondition(){
// 		String weather = this.weatherTower.getWeather(this.coordinates);
// 		int longitude = 0;
// 		int latitude = 0;
// 		int height = 0;


// 		try {
// 			Simulation.writeToFile("Baloon#"+this.name+"("+this.id+") : ");
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
// 		if (weather.equals("SUN")) {
// 			longitude = this.coordinates.getLongitude() + 2;
// 			latitude = this.coordinates.getLatitude();
// 			height = this.coordinates.getHeight() + 4;
// 			try {
// 				Simulation.writeToFile("It's so hot this balloon might POP\n");
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 		if (weather.equals("RAIN")) {

// 			longitude = this.coordinates.getLongitude() - 5;
// 			latitude = this.coordinates.getLatitude();
// 			height = this.coordinates.getHeight();
// 			try {
// 				Simulation.writeToFile("is there an umbrella in this BALLOON?!!!!\n");
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 		if (weather.equals("FOG")) {
// 			longitude = this.coordinates.getLongitude() - 1;
// 			latitude = this.coordinates.getLatitude();
// 			height = this.coordinates.getHeight();
// 			try {
// 				Simulation.writeToFile("FOG and BALLOONS don't mix!!!!!!!!!!!!\n");
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 		if (weather.equals("SNOW")) {
// 			longitude = this.coordinates.getLongitude();
// 			latitude = this.coordinates.getLatitude();
// 			height = this.coordinates.getHeight() - 15;
// 			try {
// 				Simulation.writeToFile("It's so cold!!!!!!!!\n");
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 		}

// 		if (height > 100)
// 			height = 100;
// 		if (height < 1){
// 			try {
// 				Simulation.writeToFile("\nBalloon#"+name+"("+id+") is Landing\n");
// 			} catch (IOException e) {
// 				e.printStackTrace();
// 			}
// 			this.weatherTower.unregister(this);
// 			return ;}
// 		this.coordinates = new Coordinates(longitude, latitude, height);
// }

// 	public void registerTower(WeatherTower weatherTower){
// 		this.weatherTower = weatherTower;
// 		try {
// 			Simulation.writeToFile("Baloon#"+name+"("+id+") : ");
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
// 	}
}