package banco;

public class Banca {
    private final String nombre;
    private double capital = 5_200_000.0;
    private String direccion = "No especificada";

    public Banca(String nombre) {
        this.nombre = nombre;
    }

    public Banca(String nombre, double capital, String direccion) {
        this.nombre = nombre;
        this.capital = capital;
        this.direccion = direccion;
    }

    public String getNombre() { return nombre; }
    public double getCapital() { return capital; }
    public String getDireccion() { return direccion; }
    public void setCapital(double capital) { this.capital = capital; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return nombre + " (Capital: " + capital + "€)";
    }
}