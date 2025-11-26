package YahirSagaste_A2;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria() {
        saldo = 0;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
