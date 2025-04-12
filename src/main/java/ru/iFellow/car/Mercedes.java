package ru.iFellow.car;

import lombok.Setter;

@Setter
public class Mercedes extends Car{
    /**
     * Комплектация автомобиля (amg, base, maybah)
     */
    private String equipment;

    public Mercedes(String equipment, String model, int enginePower, String fuelType, String gearShiftBox,
                    String color, int fuelQuantity, int year){
        super(model, "Mercedes", enginePower, fuelType, gearShiftBox, color, fuelQuantity, year);
        this.equipment = equipment;
    }

    @Override
    public void getInfoCar() {
        super.getInfoCar();
        System.out.println("Комплектация: " + equipment);
    }

    @Override
    public void refuelCar(int volume) {
        setFuelQuantity(getFuelQuantity() + volume);
        System.out.println("Заправка автомобиля " + getBrand() + " " + getModel() + " на " + volume + " литров");
    }

}
