package ru.iFellow;

import ru.iFellow.car.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Toyota("Camry", 249, "Бензин", "Автомат", "Черный", 41, 2022));
        cars.add(new Toyota("Corolla", 149, "Бензин", "Механика", "Зеленый", 30, 2003));
        cars.add(new Toyota("Land Cruser Prado", 249, "Дизель", "Автомат", "Серый", 41, 2005));

        cars.add(new Mercedes("AMG","E63", 450, "Бензин", "Автомат", "Белый", 55, 2023));
        cars.add(new Mercedes("AMG пакет","G63", 350, "Дизель", "Автомат", "Зеленый", 55, 2023));
        cars.add(new Mercedes("нет","GLE", 199, "Бензин", "Автомат", "Синий", 0, 1999));

        cars.add(new Tesla("Model X", 125, "Черный", 100, 2025));

        cars.add(new BMW("532i", 150, "Бензин", "Робот", "Синий", 50, false, 2019));
        cars.add(new BMW("M3", 550, "Бензин", "Робот", "Зеленый", 15, false, 2024));

        cars.add(new Lixiang("L7", 562, "Желтый", 45, 2023));

        Car.findCar(cars, 2006);

        Car.changeColor(cars, "Зеленый", "Фиолетовый");

        Car.refuelCars(cars, 15);
    }
}

