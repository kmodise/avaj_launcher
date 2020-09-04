import java.io.IOException;
import java.util.*;

public abstract class Tower{
	private ArrayList<Flyable> observers;

	public void register(Flyable Flyable){
		if (observers == null)
			observers = new ArrayList<Flyable>();
		observers.add(Flyable);
		try {
			Simulation.writeToFile("Tower Says : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Flyable);
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		try {
			Simulation.writeToFile("registered to weather tower\n");
		}catch (IOException e){
			e.printStackTrace();
		}

	}

	public void unregister(Flyable Flyable){

		try {
			Simulation.writeToFile("Tower Says : ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		try {
			Simulation.writeToFile(" unregistered\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Flyable> HoldObservers = this.observers;
		this.observers = new ArrayList<Flyable>();
		for (Flyable Fly : HoldObservers)
			if (Fly != Flyable)
				this.observers.add(Fly);
	}
	protected void conditionChanged(){
		try {
			Simulation.writeToFile("\nNEW CONDITIONS\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Flyable Fly : this.observers){
			Fly.updateCondition();
		}
	}
}