package ru.iFellow.car;

public class Lixiang extends Car {

    public Lixiang(String model, int enginePower, String color, int fuelQuantity, int year) {
        super(model, "Lixiang", enginePower, "Hybrid", "automatic", color, fuelQuantity, year);
    }

    @Override
    public void startEngine(){
        if (getFuelQuantity() > 0) {
            System.out.println(getBrand() + " " + getModel() + " завелся бесслышно)");
        } else {
            System.out.println("Бак пуст! Нужно заправиться. Или китаец сломался(");
        }
    };

    /**
     * Заправить/подзарядить автомобиль
     * @param volume Объем топлива которое нужно заправить
     */
    @Override
    public void refuelCar(int volume) {

    }
}
