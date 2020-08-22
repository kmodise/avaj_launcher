package aircrafts;

import tower.Coordinates;
import tower.Flyable;
import tower.WeatehrTower;

class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower; 

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void uptadeConditions() {

    }

    @Override
    public void registerTower(WeatehrTower WeatehrTower) {
        // TODO Auto-generated method stub

    }
}