
import java.io.IOException;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = 0;
		int latitude = 0;
		int height = 0;

		try {
			Simulation.writeToFile("JetPlane#"+this.name+"("+this.id+") : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(weather.equals("SUN")) {

			longitude = this.coordinates.getLongitude() + 10;
			latitude = this.coordinates.getLatitude();
			height = this.coordinates.getHeight() + 2;
			try {
				Simulation.writeToFile("the SUN and her eyes were the only fire, my dead wife loved the sun\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			if (weather.equals("RAIN")) {
				longitude = this.coordinates.getLongitude() + 5;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				try {
					Simulation.writeToFile("Must be a leak in heaven, that's a lot of rain!\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (weather.equals("FOG")) {
				longitude = this.coordinates.getLongitude() + 1;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				try {
					Simulation.writeToFile("Am I at a WWE event? it's so fogy, is THE UNDERTAKER 'bout to make his entrance?!!!\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (weather.equals("SNOW")) {
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 12;
				try {
					Simulation.writeToFile("all that is missing is a beautiful angel amongst all this SNOW\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		if (height > 100)
			height = 100;
		if (height < 1){
			try {
				Simulation.writeToFile("\nJetPlane#"+name+"("+id+") Landing\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.weatherTower.unregister(this);
			return ;
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