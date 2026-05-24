package zadanie41;

public class Bank {
    private String nrKonta;
    private double saldo;

    public Bank(String nrKonta, double saldo) {
        this.nrKonta = nrKonta;
        this.saldo = saldo;
    }

    public boolean wyplata(double kwota){
        if (saldo - kwota < 0){
            System.out.println("Saldo po wypłacie jest ujemne, operacja zablokowana");
            return false;
        }else {
            saldo = saldo - kwota;
        }
        return true;
    }

    public boolean wplata(double kwota){
        if (kwota <= 0){
            System.out.println("wpłata nie może być ujemna, operacja zablokowana");
            return false;
        }else {
            saldo = saldo + kwota;
        }
        return true;
    }


    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nrKonta='" + nrKonta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
