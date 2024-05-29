package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private List<RegistroAcademico> registrosAcademicos;

    public Empleado(String idEmpleado, String nombre) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.registrosAcademicos = new ArrayList<>();
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public List<RegistroAcademico> getRegistrosAcademicos() {
        return registrosAcademicos;
    }

    public void agregarRegistroAcademico(RegistroAcademico registro) {
        this.registrosAcademicos.add(registro);
    }

    public double calcularPromedioAcademico() {
        double totalNotas = 0;
        int totalAsignaturas = 0;
        for (RegistroAcademico registro : registrosAcademicos) {
            for (Double nota : registro.getNotas().values()) {
                totalNotas += nota;
                totalAsignaturas++;
            }
        }
        return totalAsignaturas == 0 ? 0 : totalNotas / totalAsignaturas;
    }
}
