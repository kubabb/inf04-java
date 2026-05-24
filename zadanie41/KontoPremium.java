package zadanie41;

public class KontoPremium extends Bank {
    private double limit;
    private double debet = 0;

    public KontoPremium(String nrKonta, double saldo) {
        super(nrKonta, saldo);
        this.limit = saldo * 0.5;
    }

    @Override
    public boolean wyplata(double kwota) {
        double saldoPo = getSaldo() - kwota;

        if (saldoPo < -limit) {
            System.out.println("Nie można wypłacić. Przekroczono limit debetu.");
            return false;
        }

        setSaldo(saldoPo);

        if (saldoPo < 0) {
            debet = odsetkiKarne(-saldoPo);
            System.out.println("Wypłacono z debetem. Debet z odsetkami: " + debet);
        }

        return true;
    }

    public double odsetkiKarne(double debet) {
        return debet + (debet * 0.10);
    }

    @Override
    public String toString() {
        return "[KontoPremium] " + getNrKonta() +
                " | saldo: " + String.format("%.2f", getSaldo()) +
                " zł limit: " + String.format("%.2f", limit) + " zł";
    }
}