package tower;


import java.util.ArrayList;

import writetofile.WriteToFile;

public abstract class Tower{
    private ArrayList<Flyable> observers;

	public void register(Flyable Flyable){
		if (observers == null)
			observers = new ArrayList<Flyable>();
		observers.add(Flyable);
		WriteToFile.puttofile("Tower Says : ");
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		WriteToFile.puttofileln(" registered to weather tower.");
	}

	public void unregister(Flyable Flyable){
		WriteToFile.puttofile("Tower Says : ");
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		WriteToFile.puttofileln(" unregisterd");
		ArrayList<Flyable> HoldObservers = this.observers;
		this.observers = new ArrayList<Flyable>();
		for (Flyable Fly : HoldObservers)
			if (Fly != Flyable)
				this.observers.add(Fly);
	}
	protected void conditionChanged(){
		WriteToFile.puttofileln("");
		for (Flyable Fly : this.observers){
			Fly.uptadeConditions();
		}
	}
}