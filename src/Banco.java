public class Banco {

    // =========================
    // ATRIBUTOS
    // =========================

    private String titular;
    private double saldo;
    private int noCuenta;


    // =========================
    // CONSTRUCTOR
    // =========================

    public Banco(String titular, double saldo, int noCuenta) {

        this.titular = titular;
        this.saldo = saldo;
        this.noCuenta = noCuenta;
    }


    // =========================
    // GETTERS
    // =========================

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNoCuenta() {
        return noCuenta;
    }


    // =========================
    // SETTERS
    // =========================

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {

        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }


    // =========================
    // DEPOSITAR
    // =========================

    public void depositar(double cantidad) {

        if (cantidad > 0) {

            saldo = saldo + cantidad;

            System.out.println("Depósito realizado correctamente.");
            System.out.println("Nuevo saldo: $" + saldo);

        } else {

            System.out.println("La cantidad debe ser mayor que 0.");
        }
    }


    // =========================
    // RETIRAR
    // =========================

    public boolean retirar(double cantidad) {

        if (cantidad > 0 && saldo >= cantidad) {

            saldo = saldo - cantidad;

            return true;

        } else {

            return false;
        }
    }


    // =========================
    // CONSULTAR
    // =========================

    public void consultar() {

        System.out.println("\n========== CUENTA ==========");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + noCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.println("============================");
    }
}