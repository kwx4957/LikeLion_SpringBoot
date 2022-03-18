package dev.projectlion.demo.week2;

public class SmallCar extends AbstractCar implements CarInterface {
    private Driver driver;


    public SmallCar() {
    }

    @Override
    public void setDriver(Driver driver) {
        if (driver.getLicense() < 1){
            throw new RuntimeException("무면허");
        }
        this.driver = driver;
    }

    @Override
    public void accelrate() {
        this.velocity += 10;
    }

    @Override
    public void brake() {
        this.velocity -= 10;
        super.brake();
    }
}
