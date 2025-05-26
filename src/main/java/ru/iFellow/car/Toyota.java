package ru.iFellow.car;

public class Toyota extends Car{

    public Toyota(String model, int enginePower, String fuelType,
                  String gearShiftBox, String color, int fuelQuantity, int year) {
        super(model, "Toyota", enginePower, fuelType, gearShiftBox, color, fuelQuantity, year);
    }

    /**
     * @param volume Объем топлива которое нужно заправить
     */
    @Override
    public void refuelCar(int volume) {
        setFuelQuantity(getFuelQuantity() + volume);
        System.out.println("Заправка автомобиля " + getBrand() + " " + getModel() + " на " + volume + " литров 95го бензина");
    }

}
