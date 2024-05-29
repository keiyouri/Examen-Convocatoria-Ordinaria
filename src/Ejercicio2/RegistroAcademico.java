package Ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class RegistroAcademico {
    private Curso curso;
    private Map<Asignatura, Double> notas;
    private boolean certificadoEmitido;

    public RegistroAcademico(Curso curso) {
        this.curso = curso;
        this.notas = new HashMap<>();
        this.certificadoEmitido = false;
    }

    public Curso getCurso() {
        return curso;
    }

    public Map<Asignatura, Double> getNotas() {
        return notas;
    }

    public void agregarNota(Asignatura asignatura, double nota) {
        notas.put(asignatura, nota);
    }

    public boolean isCertificadoEmitido() {
        return certificadoEmitido;
    }

    public void emitirCertificado() {
        this.certificadoEmitido = true;
    }
}
