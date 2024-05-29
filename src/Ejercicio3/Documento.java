package Ejercicio3;

public class Documento {
    private String nombre;
    private String tipo; // Legal, Financiero, Operativo, etc.
    private boolean completado;

    public Documento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.completado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void marcarCompletado() {
        this.completado = true;
    }
}
