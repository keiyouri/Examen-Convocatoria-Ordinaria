import Ejercicio2.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SistemaFormacionTest {

    private SistemaFormacion sistemaFormacion;
    private Empleado empleado;
    private Curso curso;
    private Asignatura asignatura1;
    private Asignatura asignatura2;

    @Before
    public void setUp() {
        sistemaFormacion = SistemaFormacion.getInstancia();

        // Crear asignaturas
        asignatura1 = new Asignatura("Programación en Java");
        asignatura2 = new Asignatura("Patrones de Diseño");

        // Crear curso
        curso = new Curso("Desarrollo de Software", Arrays.asList(asignatura1, asignatura2));

        // Crear empleado
        empleado = new Empleado("E001", "Juan Pérez");

        // Limpiar datos previos
        sistemaFormacion.getEmpleado().clear();
        sistemaFormacion.getCursos().clear();

        // Añadir curso y empleado al sistema
        sistemaFormacion.agregarCurso(curso);
        sistemaFormacion.agregarEmpleado(empleado);
    }

    @Test
    public void testAgregarEmpleado() {
        Empleado nuevoEmpleado = new Empleado("E002", "María López");
        sistemaFormacion.agregarEmpleado(nuevoEmpleado);
        assertEquals(nuevoEmpleado, sistemaFormacion.getEmpleado("E002"));
    }

    @Test
    public void testAgregarCurso() {
        Curso nuevoCurso = new Curso("Inteligencia Artificial", Arrays.asList(asignatura1));
        sistemaFormacion.agregarCurso(nuevoCurso);
        assertTrue(sistemaFormacion.getCursos().contains(nuevoCurso));
    }

    @Test
    public void testInscribirEmpleadoEnCurso() {
        sistemaFormacion.inscribirEmpleadoEnCurso(empleado.getIdEmpleado(), curso);
        Empleado empleadoInscrito = sistemaFormacion.getEmpleado(empleado.getIdEmpleado());
        assertEquals(1, empleadoInscrito.getRegistrosAcademicos().size());
        assertEquals(curso, empleadoInscrito.getRegistrosAcademicos().get(0).getCurso());
    }

    @Test
    public void testRegistrarNota() {
        sistemaFormacion.inscribirEmpleadoEnCurso(empleado.getIdEmpleado(), curso);
        sistemaFormacion.registrarNota(empleado.getIdEmpleado(), curso, asignatura1, 90.0);
        Empleado empleadoInscrito = sistemaFormacion.getEmpleado(empleado.getIdEmpleado());
        RegistroAcademico registro = empleadoInscrito.getRegistrosAcademicos().get(0);
        assertEquals(90.0, registro.getNotas().get(asignatura1), 0.01);
    }

    @Test
    public void testEmitirCertificado() {
        sistemaFormacion.inscribirEmpleadoEnCurso(empleado.getIdEmpleado(), curso);
        sistemaFormacion.emitirCertificado(empleado.getIdEmpleado(), curso);
        Empleado empleadoInscrito = sistemaFormacion.getEmpleado(empleado.getIdEmpleado());
        RegistroAcademico registro = empleadoInscrito.getRegistrosAcademicos().get(0);
        assertTrue(registro.isCertificadoEmitido());
    }

    @Test
    public void testCalcularPromedioAcademico() {
        sistemaFormacion.inscribirEmpleadoEnCurso(empleado.getIdEmpleado(), curso);
        sistemaFormacion.registrarNota(empleado.getIdEmpleado(), curso, asignatura1, 90.0);
        sistemaFormacion.registrarNota(empleado.getIdEmpleado(), curso, asignatura2, 80.0);
        double promedio = empleado.calcularPromedioAcademico();
        assertEquals(85.0, promedio, 0.01);
    }
}
