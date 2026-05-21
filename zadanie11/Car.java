package zadanie11;
import java.time.LocalDate;
import java.util.ArrayList;

public class Car {
    private String registry;
    private String type;
    private int year;
    private double howManyKms;
    private static final int timeRn = LocalDate.now().getYear();
    boolean needService;

    public boolean isNeedService() {
        return needService;
    }

    public Car(String registry, String type, int year, double howManyKms) {
        this.registry = registry;

        if (type.equals("osobowy") || type.equals("dostawczy") || type.equals("motocykl")) {
            this.type = type;
        }else{
            System.out.println("Nieprawidlowy typ samochodu");
        }

        if (year < 1900 || year > timeRn) {
            System.out.println("Zła data produkcji");
        }else {
            this.year = year;
        }


//        this.type = type;
//        this.year = year;
        this.howManyKms = howManyKms;
    }

    public void serwis(){
        int serwisKm = timeRn - 5;
        if (howManyKms > 20000 || year < serwisKm){
            needService = true;
            System.out.println("Wymaga serwisu");

        }else{
            needService = false;
            System.out.println("Nie wymaga serwisu");
        }
    }

    public String getRegistry() {
        return registry;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public double getHowManyKms() {
        return howManyKms;
    }

    public int getTimeRn() {
        return timeRn;
    }

    public void setHowManyKms(double howManyKms) {
        if (howManyKms < 0) {
            System.out.println("Błąd: przebieg nie może być ujemny!");
        } else {
            this.howManyKms = howManyKms;
        }
    }


    @Override
    public String toString() {
        return
                "registry: " + registry + '\'' +
                ", type: " + type + '\'' +
                ", year: " + year +
                ", howManyKms: " + howManyKms +
                '}';
    }
}
