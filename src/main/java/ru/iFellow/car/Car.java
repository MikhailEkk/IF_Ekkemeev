package ru.iFellow.car;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public abstract class Car {
    /** Модель автомобиля     */
    private String model;

    /** Бренд автомобиля     */
    private String brand;

    /** Мощность двигателя     */
    private int enginePower;

    /** Тип топлива     */
    private String fuelType;

    /** Тип КПП     */
    private String gearShiftBox;

    /** Цвет автомобиля     */
    private String color;

    /** Количество топлива в баке     */
    private int fuelQuantity;

    /** Год выпуска автомобиля     */
    private int year;

    public Car(String model, String brand, int enginePower, String fuelType, String gearShiftBox, String color, int fuelQuantity, int year) {
        this.model = model;
        this.brand= brand;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.gearShiftBox = gearShiftBox;
        this.color = color;
        this.fuelQuantity = fuelQuantity;
        this.year = year;
    }

    /**
     * Увеличение мощности автомобиля
     * @param diff На сколько л.с. увеличить мощность (должно быть положительным)
     * @throws IllegalArgumentException если {@code diff <= 0}
     */
    public void increaseEnginePower(int diff){
        this.enginePower += diff;
    }

    /**
     * Запустить автомобиль
     */
    public void startEngine(){
        if (getFuelQuantity() > 0) {
            System.out.println(getBrand() + " " + getModel() + " завелся! 🚗💨");
        } else {
            System.out.println("Бак пуст! Нужно заправиться.");
        }
    }

    /**
     * Получить информацию об автомобиле
     */
    public void getInfoCar(){
        System.out.println("Информация об автомобиле:");
        System.out.println("Модель: " + getModel());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Мощность: " + getEnginePower() + " л.с.");
        System.out.println("Тип топлива: " + getFuelType());
        System.out.println("КПП: " + getGearShiftBox());
        System.out.println("Цвет: " + getColor());
        System.out.println("Топливо в баке: " + getFuelQuantity() + " л.");
        System.out.println("Год выпуска: " + getYear());
    }

    /**
     * Заправить машину
     * @param volume Объем топлива которое нужно заправить
     * @throws IllegalArgumentException если {@code volume <= 0}
     */
    public abstract void refuelCar(int volume);

    /**
     * Вывести информацию об автомобилях, выпущенных позже заданного года выпуска
     * @param cars список автомобилей
     * @param year год выпуска
     */
    public static void findCar(List<Car> cars, int year){
        for(Car car : cars){
            if (car.getYear() < year){
                System.out.println(car.getBrand() + " " + car.getModel() + " - устаревший авто\n");
            } else {
                car.getInfoCar();
                System.out.println();
            }
        }
    }

    /**
     * Изменить цвет автомобилей
     * @param cars списко автомобилей
     * @param originalColor цвет автомобиля, который нужно поменять
     * @param newColor новый цвет автомобиля
     */
    public static void changeColor(List<Car> cars, String originalColor, String newColor){
        for(Car car : cars){
            if (Objects.equals(car.getColor(), originalColor)){
                car.setColor(newColor);
                System.out.println("Машина " + car.getBrand() + " " + car.getModel() + " перекрашена в " + newColor + " цвет");
            }
        }
    }

    /**
     * Заправить автомобили из списка
     * @param cars список автомобилей на заправку
     * @param volume объем топлива/энергии
     */
    public static void refuelCars(List<Car> cars, int volume){
        for (Car car : cars){
            car.refuelCar(volume);
        }
    }
}
