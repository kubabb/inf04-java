package zadanie41;

public class KontoOszczednosciowe extends Bank{

    private int prowizja;

    public KontoOszczednosciowe(String nrKonta, double saldo) {
        super(nrKonta, saldo);
    }

    @Override
    public boolean wyplata(double kwota) {
        double saldo = getSaldo();
        kwota = kwota + 5;

        if (kwota > saldo){
            System.out.println("nie mozna wyplacic");
            return false;
        }else {
            return super.wyplata(kwota);
        }

    }

    @Override
    public boolean wplata(double kwota) {
        double saldo = getSaldo();
        double plus =  kwota * 0.01;
        return super.wplata(kwota + plus);
    }

    @Override
    public String toString() {
        return "[KontoOszczednosciowe] " + getNrKonta() +
                " | saldo: " + String.format("%.2f", getSaldo()) + " zł";
    }
}
