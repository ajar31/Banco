import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank banco = new Bank("Banco DAM1", 1.5);
        int op;

        do {
            System.out.println(
                    """
                            Banco DAM1
                            1. Crear una cuenta bancaria.
                            2. Depositar una cantidad en la cuenta.
                            3. Retirar una cantidad de la cuenta.
                            4. Salir
                            """);

            System.out.println("Introduce una opción:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Introduce el IBAN:");
                    String iban = sc.next();
                    banco.crearCuentaCorriente(iban);
                    break;

                case 2:
                    System.out.println("Introduce el IBAN:");
                    iban = sc.next();
                    System.out.println("Introduce la cantidad a ingresar:");
                    double dineroIngresar = sc.nextDouble();
                    if (!banco.realizarIngreso(dineroIngresar, iban)) {
                        System.out.println("No se pudo realizar el ingreso. Cuenta no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Introduce el IBAN:");
                    iban = sc.next();
                    System.out.println("Introduce la cantidad a retirar:");
                    double dineroSacar = sc.nextDouble();
                    if (!banco.realizarRetirada(dineroSacar, iban)) {
                        System.out.println("No se pudo realizar la retirada. Cuenta no encontrada o saldo insuficiente.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el Banco DAM1");
                    break;

                default:
                    System.out.println("La opción seleccionada no es correcta");
                    break;
            }

        } while (op != 4);

    }
}
