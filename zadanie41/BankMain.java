package zadanie41;

public class BankMain {
    public static void main(String[] args) {
        Bank[] konta = {
                new Bank("PL001", 1000.0),
                new KontoOszczednosciowe("PL002", 1000.0),
                new KontoPremium("PL003", 1000.0)
        };

        for (Bank konto : konta) {
            System.out.println("--- " + konto.getClass().getSimpleName() + " " + konto.getNrKonta() + " ---");

            boolean wp = konto.wplata(1000.0);
            if (wp) {
                System.out.println("Wpłata 1000 zł → saldo: " + konto.getSaldo());
            }

            boolean wyp = konto.wyplata(1200.0);
            if (wyp) {
                System.out.println("Wypłata 1200 zł → saldo: " + konto.getSaldo());
            } else {
                System.out.println("Wypłata 1200 zł nie doszła do skutku.");
            }

            if (konto instanceof KontoPremium premium) {
                if (premium.getSaldo() < 0) {
                    double odsetki = premium.odsetkiKarne(-premium.getSaldo());
                    System.out.println("Odsetki karne: " + odsetki);
                } else {
                    System.out.println("Odsetki karne: 0.0");
                }
            }

            System.out.println("Końcowe saldo: " + konto.getSaldo());
            System.out.println();
        }
    }
}