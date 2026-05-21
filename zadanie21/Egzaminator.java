package zadanie21;


public class Egzaminator {
    private static int licznik;
    public final int id;
    public String imie;

    public static int getLicznik() {
        return licznik;
    }

    public String nazwisko;
    Specjalizacja specjalizacja;

    enum Specjalizacja{
        INF02("Inf02"),
        INF03("Inf03"),
        INF04("Inf04");

        private final String nazwa;

        Specjalizacja(String nazwa) {
            this.nazwa = nazwa;
        }

        public String getNazwa() {
            return nazwa;
        }
    }


    public Egzaminator(String imie, String nazwisko, Specjalizacja specjalizacja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.specjalizacja = specjalizacja;
        licznik++;
        id = licznik;
    }

    @Override
    public String toString() {
        System.out.println("Licznik teraz: " + getLicznik());
        return
                "[ID:" + String.format("%03d", id) + "] " +
                 imie + " " +
                nazwisko + " " + " | " + specjalizacja.getNazwa();


    }
}
