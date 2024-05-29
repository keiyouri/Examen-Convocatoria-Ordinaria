import Ejercicio2.SistemaFormacion;
import Ejercicio3.SistemaIPO;
import MVC.Controlador;
import MVC.Vista;

public class Main {
    public static void main(String[] args) {
        // Crear instancias del modelo
        SistemaFormacion sistemaFormacion = SistemaFormacion.getInstancia();
        SistemaIPO sistemaIPO = SistemaIPO.getInstancia();

        // Crear la vista
        Vista vista = new Vista();

        // Crear el controlador
        Controlador controlador = new Controlador(vista, sistemaFormacion, sistemaIPO);

        // Iniciar la aplicación
        controlador.iniciar();
    }
}
