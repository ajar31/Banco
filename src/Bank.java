import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String nombre;
    private double interes;
    private List<Account> listadoCuentasCorrientes;

    public Bank(String nombre, double interes) {
        this.nombre = nombre;
        this.interes = interes;
        this.listadoCuentasCorrientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getInteres() {
        return interes;
    }

    public List<Account> getListadoCuentasCorrientes() {
        return listadoCuentasCorrientes;
    }

    public void crearCuentaCorriente(String iban) {
        Account nuevaCuentaCorriente = new Account(iban);
        listadoCuentasCorrientes.add(nuevaCuentaCorriente);
        System.out.println("Se ha creado una nueva cuenta con IBAN: " + iban);
    }

    public void eliminarCuentaCorriente(String ibanEliminar) {
        listadoCuentasCorrientes.removeIf(cuenta -> cuenta.getIban().equals(ibanEliminar));
        System.out.println("La cuenta con IBAN: " + ibanEliminar + " ha sido eliminada.");
    }

    public boolean realizarIngreso(double dineroIngreso, String iban) {
        for (Account cuenta : listadoCuentasCorrientes) {
            if (cuenta.getIban().equals(iban)) {
                cuenta.ingresarDinero(dineroIngreso);
                return true;
            }
        }
        System.out.println("No se ha encontrado la cuenta con IBAN: " + iban);
        return false;
    }

    public boolean realizarRetirada(double dineroRetirada, String iban) {
        for (Account cuenta : listadoCuentasCorrientes) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.sacarDinero(dineroRetirada);
            }
        }
        System.out.println("No se ha encontrado la cuenta con IBAN: " + iban);
        return false;
    }
}

