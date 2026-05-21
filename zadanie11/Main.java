package zadanie11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
        public static void main(String[] args) {

        Car car1 = new Car("KR99887", "dostawczy", 2014, 48120.5);
        Car car2 = new Car("GD44321", "osobowy", 2019, 21050.0);
        Car car3 = new Car("WA00001", "motocykl", 1999, 2300.0);
        Car car4 = new Car("PO12345", "osobowy", 2021, 8700.0);
        Car car5 = new Car("LU77777", "dostawczy", 2018, 19999.9);
        Car car6 = new Car("SB24680", "motocykl", 2016, 24500.0);

        ArrayList<Car> fleet = new ArrayList<>();
        fleet.add(car1);
        fleet.add(car2);
        fleet.add(car3);
        fleet.add(car4);
        fleet.add(car5);
        fleet.add(car6);

        doesNeedSerwice(fleet);




    }

    public static void doesNeedSerwice(ArrayList<Car> fleet){
        double totalCars = fleet.size();
        ArrayList<Car> carsThatNeedService = new ArrayList<Car>();


        for (int i = 0; i < fleet.size(); i++) {
            fleet.get(i).serwis();
            if (fleet.get(i).needService){
                carsThatNeedService.add(fleet.get(i));
            }
        }
        double serviceNum = (carsThatNeedService.size()/totalCars) * 100;

        System.out.println("Pojazdy wymagajace serisu:");
        System.out.println("% pojazdow wymagajacych serisu: " + serviceNum);
        Collections.sort(carsThatNeedService, Comparator.comparingInt(Car::getYear));

        for (int i = 0; i < carsThatNeedService.size(); i++) {
            System.out.println(carsThatNeedService.get(i) );
        }

    }

}
