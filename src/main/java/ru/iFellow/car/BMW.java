package ru.iFellow.car;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BMW extends Car {

    private boolean driftMode;

    public BMW(String model, int enginePower, String fuelType, String gearShiftBox,
               String color, int fuelQuantity, boolean driftMode, int year) {
        super(model, "BMW", enginePower, fuelType, gearShiftBox, color, fuelQuantity, year);
        this.driftMode = driftMode;
    }

    public void turnOnDriftMode(){
        setDriftMode(true);
        System.out.println("DriftMode включен");
    }

    public void turnOffDriftMode(){
        setDriftMode(false);
        System.out.println("DriftMode выключен");
    }

    /**
     * Заправить автомобиль
     * @param volume Объем топлива которое нужно заправить
     */
    @Override
    public void refuelCar(int volume) {
        setFuelQuantity(getFuelQuantity() + volume);
        System.out.println("Заправка автомобиля " + getBrand() + " " + getModel() + " на " + volume + " литров 100го бензина");
    }
}
