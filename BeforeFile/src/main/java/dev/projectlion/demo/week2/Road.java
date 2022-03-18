package dev.projectlion.demo.week2;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private ArrayList<CarInterface> carsOnRoad;

    public Road() {
        this.carsOnRoad = new ArrayList<>();
    }

    public Road(List<CarInterface> carsOnRoad) {
        this.carsOnRoad = (ArrayList<CarInterface>) carsOnRoad;
    }

}
