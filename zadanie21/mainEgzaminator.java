package zadanie21;

public class mainEgzaminator {
    static void main(String[] args) {
        System.out.println("Licznik przed tworzeniem obiektow: " + Egzaminator.getLicznik());

        Egzaminator egz1 = new Egzaminator("Jan", "Nowak", Egzaminator.Specjalizacja.INF02);
        System.out.println(egz1);
        Egzaminator egz2 = new Egzaminator("Jan", "Nowak", Egzaminator.Specjalizacja.INF03);
        System.out.println(egz1);
        Egzaminator egz3 = new Egzaminator("Jan", "Nowak", Egzaminator.Specjalizacja.INF04);
        System.out.println(egz1);

        int idDiffrence = egz2.id - egz1.id;
        System.out.println("Różnica id: " + idDiffrence);

        System.out.println("Licznik po tworzeniu obiektow: " + Egzaminator.getLicznik());
    }
}
