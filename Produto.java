
import java.util.Scanner;

public class Produto {

    private String nombre;
    private double precioUnitario = 0;
    private boolean disponible;
    private int cantidad;

    Scanner in = new Scanner(System.in);

    public Produto(String nombre, double precioUnitario, int cantidad) {
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.disponible = cantidad > 0;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.disponible = cantidad > 0;
    }

    public String getDisponible() {
        return disponible ? "Si" : "No";

    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nPrecioUnitario: " + precioUnitario + "\nDisponible: " + getDisponible()
                + "\nCantidad: " + cantidad;
    }
}
