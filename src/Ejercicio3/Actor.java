package Ejercicio3;

public class Actor {
    private String nombre;
    private String tipo; // Proveedor, Inversionista, etc.

    public Actor(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
