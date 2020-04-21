import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class CarTests {
    private Car carEntity;

    //@Test
    public void test() {
        //rewrite using java 8
        Map<String, Integer> modelToPrice = new HashMap<>();
        Map<String, Integer> modelToPriceJava8;
        Car cheapestCar = null;
        Car cheapestCarJava8, expensiveCarJava8;
        Car expensiveCar = null;

        List<Car> cars = Arrays.asList(
                new Car(10000, "megan", 2014, ""),
                new Car(10500, "mazda", 2015, ""),
                new Car(2000, "kia", 2008, ""),
                new Car(13000, "a5", 2012, "")
        );

        for (Car car : cars) {
            modelToPrice.put(car.getModel(), car.getPrice());
        }

        modelToPriceJava8 = cars.stream().collect(
                Collectors.toMap(Car::getModel, Car::getPrice));

        Integer cheapestPrice = Integer.MAX_VALUE;
        for (Car car : cars) {
            if (car.getPrice() < cheapestPrice) {
                cheapestPrice = car.getPrice();
                cheapestCar = car;
            }
        }

        cheapestCarJava8 = cars.stream().min(Comparator.comparing(Car::getPrice))
                .get();

        expensiveCarJava8 = cars.stream().max(Comparator.comparing(Car::getPrice))
                .get();

        Integer expensivePrice = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getPrice() > expensivePrice) {
                expensivePrice = car.getPrice();
                expensiveCar = car;
            }
        }

        List<Car> oldCars = cars.stream().filter(car -> car.getYear() < 2013).collect(Collectors.toList());
        List<Car> expectedOldCar = Arrays.asList(
                new Car(2000, "kia", 2008, ""),
                new Car(13000, "a5", 2012, ""));
        //TODO find most expensive car using java 8 and not java 8
        //TODO find cheapestCarJava8 and modelToPriceJava8
        //TODO find cars which older that 2013 using oldCars

        assertEquals(oldCars, expectedOldCar);
        assertEquals(cheapestCar, cheapestCarJava8);
        assertEquals(expensiveCar, expensiveCarJava8);
        assertEquals(modelToPrice, modelToPriceJava8);
    }

    @Test
    public void test2() {
        List<Car> cars = Arrays.asList(
                new Car(10000, "megan", 2014, ""),
                new Car(10500, "mazda", 2015, ""),
                new Car(2000, "kia", 2008, ""),
                new Car(13000, "a5", 2012, ""),
                new Car(10000, "megan", 2014, ""),
                new Car(10500, "mazda", 2014, ""),
                new Car(2000, "niva", 2008, ""),
                new Car(13000, "a4", 2008, "")
        );

        int yearVal = 2014;

        getIndCar(cars, yearVal);

        Map<Integer, List<Car>> mapCar =
                cars.stream().collect(Collectors.toMap(k -> yearVal, e -> getIndCar(cars, yearVal), (oldValue, newValue) -> newValue
                ));

        mapCar.forEach((k,e)->System.out.println("Year : " + k + " Car : " + e));

    }
    public List<Car> getIndCar(List<Car> carsYear, int year) {
        List<Car> yearCar = carsYear.stream().filter(car -> car.getYear().equals(year))
                .collect(Collectors.toList());
        return yearCar;
    }
}
