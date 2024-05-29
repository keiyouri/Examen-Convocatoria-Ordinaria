package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFormacion {
    private static SistemaFormacion instancia;
    private Map<String, Empleado> empleados;
    private List<Curso> cursos;

    private SistemaFormacion() {
        empleados = new HashMap<>();
        cursos = new ArrayList<>();
    }

    public static synchronized SistemaFormacion getInstancia() {
        if (instancia == null) {
            instancia = new SistemaFormacion();
        }
        return instancia;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.put(empleado.getIdEmpleado(), empleado);
    }

    public Empleado getEmpleado(String idEmpleado) {
        return empleados.get(idEmpleado);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void inscribirEmpleadoEnCurso(String idEmpleado, Curso curso) {
        Empleado empleado = empleados.get(idEmpleado);
        if (empleado != null) {
            empleado.agregarRegistroAcademico(new RegistroAcademico(curso));
        }
    }

    public void registrarNota(String idEmpleado, Curso curso, Asignatura asignatura, double nota) {
        Empleado empleado = empleados.get(idEmpleado);
        if (empleado != null) {
            for (RegistroAcademico registro : empleado.getRegistrosAcademicos()) {
                if (registro.getCurso().equals(curso)) {
                    registro.agregarNota(asignatura, nota);
                }
            }
        }
    }

    public void emitirCertificado(String idEmpleado, Curso curso) {
        Empleado empleado = empleados.get(idEmpleado);
        if (empleado != null) {
            for (RegistroAcademico registro : empleado.getRegistrosAcademicos()) {
                if (registro.getCurso().equals(curso) && !registro.isCertificadoEmitido()) {
                    registro.emitirCertificado();
                    System.out.println("Certificado emitido para " + empleado.getNombre() + " en el curso " + curso.getNombreCurso());
                }
            }
        }
    }
}
