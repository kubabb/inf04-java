package zadanie31;

import java.io.*;
import java.util.ArrayList;

public class ProduktMain {
    public static void main(String[] args)  {
        ArrayList<Produkt> produkty = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("zadanie31/produkty.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");


                if (parts.length < 4){
                    System.out.println("brak danych pominięto");
                    continue;
                }

                String name = parts[0];
                String price = parts[1];
                String count = parts[2];
                String code = parts[3];

                if (price.equals("BRAK")){
                    System.out.println("[POMINIĘTO]  Brak ceny wejściowej: " + name);
                    continue;
                }


                int countInt = Integer.parseInt(count);
                double priceNum = Double.parseDouble(price);

                Produkt produkt = new Produkt(name, priceNum, countInt, code);
                produkty.add(produkt);





            }

            ArrayList<Produkt> properCode = new ArrayList<>();
            ArrayList<Produkt> badCode = new ArrayList<>();

            for (Produkt p : produkty){
                if (p.isCodeRight(p.code)){
                    properCode.add(p);
                }else {
                    badCode.add(p);
                }
            }


            System.out.println("Produkty z poprawnym kodem: " + properCode.size());
            for (Produkt p : properCode){
                System.out.println(p);
            }

            System.out.println("Produkty z błędnym kodem: " + badCode.size());
            for (Produkt p : badCode){
                System.out.println(p);
            }

            System.out.println("Etykiety produktów (poprawny kod):");
            for (Produkt p : produkty) {
                if (p.isCodeRight(p.code)) {
                    System.out.println(p.name + " → " + p.createCode());
                }
            }

        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku");
        }


    }
}
