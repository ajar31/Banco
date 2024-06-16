

public class Account {
    private String iban;
    private double saldo;

    public Account(String iban) {
        this.iban = iban;
        this.saldo = 0;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacarDinero(double dineroRetirar) {
        if (saldo >= dineroRetirar) {
            saldo -= dineroRetirar;
            System.out.println("Se ha retirado " + dineroRetirar + " euros.");
            System.out.println("El saldo es "+saldo);
            return true;

        } else {
            System.out.println("No se ha podido realizar la operación: saldo insuficiente.");
            return false;
        }
    }

    public void ingresarDinero(double dineroIngresar) {
        saldo += dineroIngresar;
        System.out.println("El ingreso de " + dineroIngresar + " euros se ha realizado correctamente.");
        System.out.println("El saldo es "+saldo);
    }

}
