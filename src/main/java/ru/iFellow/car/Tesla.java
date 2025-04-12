package ru.iFellow.car;

public class Tesla extends Car {

    public Tesla(String model, int enginePower, String color, int fuelQuantity, int year) {
        super(model, "Tesla", enginePower, "Electric", "Automatic", color, fuelQuantity, year);
    }

    /**
     * Получить время разгона автомобиля от 100 до 200 км/ч
     */
    public void getAcceleration100_200(){
        System.out.println("Разгон от 100 до 200 км/ч составляет 10 секунд");
    }

    /**
     * Подзарядка автомобиля
     * @param volume Объем электричества которое нужно "заправить"
     */
    @Override
    public void refuelCar(int volume) {
        setFuelQuantity(getFuelQuantity() + volume);
        System.out.println("Заправка автомобиля " + getBrand() + " " + getModel() + " на " + volume + "% ");
    }
}
