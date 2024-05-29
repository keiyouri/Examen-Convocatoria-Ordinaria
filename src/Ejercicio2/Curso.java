package Ejercicio2;

import java.util.List;

public class Curso {
    private String nombreCurso;
    private List<Asignatura> asignaturas;

    public Curso(String nombreCurso, List<Asignatura> asignaturas) {
        this.nombreCurso = nombreCurso;
        this.asignaturas = asignaturas;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
