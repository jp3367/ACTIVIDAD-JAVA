package banco;

public class CuentaCorriente {

    private double saldo;
    public final String nombre;
    final String dni;
    private double limite;

    private static String nombreBanco = "Banco por Defecto";

    private Banca banco;


    public CuentaCorriente(String nombre, String dni) {
        this.saldo = 0.0;
        this.nombre = nombre;
        this.dni = dni;
        this.limite = -50.0;  // -50€
    }

    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
        this.nombre = "TU NOMBRE AQUÍ";
        this.dni = "12345678A";
        this.limite = 0.0;
    }

    public CuentaCorriente(double saldoInicial, double limite, String dni) {
        this.saldo = saldoInicial;
        this.nombre = "TU NOMBRE AQUÍ";
        this.dni = dni;
        this.limite = limite;
    }

    public boolean sacar(double cant) {
        if (cant <= 0) return false;
        if (saldo - cant >= limite) {
            saldo -= cant;
            return true;
        } else {
            System.out.println("No hay dinero suficiente");
            return false;
        }
    }

    public void ingreso(double cant) {
        if (cant > 0) saldo += cant;
    }

    public boolean transferencia(CuentaCorriente destino, double importe) {
        if (destino == null || importe <= 0) return false;
        if (this.sacar(importe)) {
            destino.ingreso(importe);
            return true;
        }
        return false;
    }

    public void mostrarInformacion() {
        System.out.println("=== Información de la Cuenta ===");
        System.out.println("Titular: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Saldo: " + String.format("%.2f", saldo) + " €");
        System.out.println("Límite descubierto: " + String.format("%.2f", limite) + " €");
        System.out.println("Banco común: " + nombreBanco);
        System.out.println("Entidad: " + (banco != null ? banco.getNombre() : "Sin vincular"));
        System.out.println("====================================\n");
    }

    public static void setNombreBanco(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            nombreBanco = nombre;
        }
    }

    public static String getNombreBanco() {
        return nombreBanco;
    }

    public void vincularBanco(Banca b) { this.banco = b; }
    public Banca getBanco() { return banco; }
    public void desvincularBanco() { this.banco = null; }
}