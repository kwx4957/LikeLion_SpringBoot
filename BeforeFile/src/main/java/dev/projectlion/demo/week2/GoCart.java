package dev.projectlion.demo.week2;

public class GoCart extends AbstractCar implements CarInterface{
    private Driver driver;

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void accelrate() {
        this.velocity += 5;
    }

    @Override
    public void brake() {
        this.velocity -= 5;
        super.brake();
    }

    public GoCart() {
    }
}
