
import java.io.IOException;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){super(name, coordinates);}

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
				Simulation.writeToFile(craftID() + "SUN-> the SUN and her eyes were the only fire, my dead wife loved the sun\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += 10;
			height += 2;
		}
		else if (weather.equals("RAIN"))
		{
			try {
				Simulation.writeToFile(craftID()+"RAIN-> Must be a leak in heaven, that's a lot of rain!\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

			longitude += 5;
		}
		else if (weather.equals("FOG"))
		{
			try {
				Simulation.writeToFile(craftID()+"FOG-> Am I at a WWE event? it's so fogy, is THE UNDERTAKER 'bout to make his entrance?!!\n");
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

			height -= 12;
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

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		
		try {
			Simulation.writeToFile("JetPlane#"+name+"("+id+") : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}