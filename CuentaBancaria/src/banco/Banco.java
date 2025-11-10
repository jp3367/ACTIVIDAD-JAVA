package banco;

public class Banco {
    public static void main(String[] args) {

        System.out.println("=== ACTIVIDAD EVALUABLE - TODO CORRECTO ===\n");

        CuentaCorriente c1 = new CuentaCorriente("Ana García", "98765432B");
        CuentaCorriente c2 = new CuentaCorriente(500.0);
        CuentaCorriente c3 = new CuentaCorriente(1000.0, -50.00, "11223344C");

        c1.ingreso(300);
        c2.ingreso(200);
        c3.ingreso(400);

        System.out.println("1. CUENTAS CREADAS (MIRA LOS LÍMITES):");
        c1.mostrarInformacion();
        c2.mostrarInformacion();
        c3.mostrarInformacion();

        CuentaCorriente.setNombreBanco("Banco Santander");
        c1.mostrarInformacion();

        System.out.println("4. TRANSFERENCIA 150€ de c1 a c2:");
        c1.transferencia(c2, 150);
        c1.mostrarInformacion();
        c2.mostrarInformacion();

        Banca bbva = new Banca("BBVA");
        c1.vincularBanco(bbva);
        c1.mostrarInformacion();


    }
}