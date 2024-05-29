package MVC;

import Ejercicio2.Asignatura;
import Ejercicio2.Curso;
import Ejercicio2.Empleado;
import Ejercicio2.SistemaFormacion;
import Ejercicio3.Documento;
import Ejercicio3.Requisito;
import Ejercicio3.SistemaIPO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Vista vista;
    private SistemaFormacion sistemaFormacion;
    private SistemaIPO sistemaIPO;

    public Controlador(Vista vista, SistemaFormacion sistemaFormacion, SistemaIPO sistemaIPO) {
        this.vista = vista;
        this.sistemaFormacion = sistemaFormacion;
        this.sistemaIPO = sistemaIPO;

        this.vista.agregarListenerBotonGestionFormacion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.mostrarMenuFormacion();
            }
        });

        this.vista.agregarListenerBotonGestionIPO(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.mostrarMenuIPO();
            }
        });

        this.vista.agregarListenerBotonSalir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.vista.agregarListenerBotonVolverFormacion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.mostrarMenuPrincipal();
            }
        });

        this.vista.agregarListenerBotonVolverIPO(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.mostrarMenuPrincipal();
            }
        });

        // Listeners para gestión de formación
        this.vista.agregarListenerBotonInscribirEmpleado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirEmpleadoEnCurso();
            }
        });

        this.vista.agregarListenerBotonRegistrarNota(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarNota();
            }
        });

        this.vista.agregarListenerBotonEmitirCertificado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emitirCertificado();
            }
        });

        this.vista.agregarListenerBotonCalcularPromedio(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPromedioAcademico();
            }
        });

        // Listeners para gestión de IPO
        this.vista.agregarListenerBotonAgregarDocumento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDocumento();
            }
        });

        this.vista.agregarListenerBotonMarcarDocumento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarDocumentoCompletado();
            }
        });

        this.vista.agregarListenerBotonAgregarRequisito(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRequisito();
            }
        });

        this.vista.agregarListenerBotonMarcarRequisito(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarRequisitoCumplido();
            }
        });

        this.vista.agregarListenerBotonSeguirHito(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seguirHito();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void inscribirEmpleadoEnCurso() {
        String idEmpleado = vista.obtenerEntrada("Ingrese ID del empleado: ");
        String nombreCurso = vista.obtenerEntrada("Ingrese nombre del curso: ");
        Empleado empleado = sistemaFormacion.getEmpleado(idEmpleado);
        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado.");
            return;
        }

        Curso curso = sistemaFormacion.getCursos().stream()
                .filter(c -> c.getNombreCurso().equals(nombreCurso))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            vista.mostrarMensaje("Curso no encontrado.");
            return;
        }

        sistemaFormacion.inscribirEmpleadoEnCurso(idEmpleado, curso);
        vista.mostrarMensaje("Empleado inscrito en el curso exitosamente.");
    }

    private void registrarNota() {
        String idEmpleado = vista.obtenerEntrada("Ingrese ID del empleado: ");
        String nombreCurso = vista.obtenerEntrada("Ingrese nombre del curso: ");
        String nombreAsignatura = vista.obtenerEntrada("Ingrese nombre de la asignatura: ");
        double nota = vista.obtenerNota("Ingrese la nota: ");

        Empleado empleado = sistemaFormacion.getEmpleado(idEmpleado);
        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado.");
            return;
        }

        Curso curso = sistemaFormacion.getCursos().stream()
                .filter(c -> c.getNombreCurso().equals(nombreCurso))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            vista.mostrarMensaje("Curso no encontrado.");
            return;
        }

        Asignatura asignatura = curso.getAsignaturas().stream()
                .filter(a -> a.getNombreAsignatura().equals(nombreAsignatura))
                .findFirst()
                .orElse(null);

        if (asignatura == null) {
            vista.mostrarMensaje("Asignatura no encontrada.");
            return;
        }

        sistemaFormacion.registrarNota(idEmpleado, curso, asignatura, nota);
        vista.mostrarMensaje("Nota registrada exitosamente.");
    }

    private void emitirCertificado() {
        String idEmpleado = vista.obtenerEntrada("Ingrese ID del empleado: ");
        String nombreCurso = vista.obtenerEntrada("Ingrese nombre del curso: ");

        Empleado empleado = sistemaFormacion.getEmpleado(idEmpleado);
        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado.");
            return;
        }

        Curso curso = sistemaFormacion.getCursos().stream()
                .filter(c -> c.getNombreCurso().equals(nombreCurso))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            vista.mostrarMensaje("Curso no encontrado.");
            return;
        }

        sistemaFormacion.emitirCertificado(idEmpleado, curso);
        vista.mostrarMensaje("Certificado emitido exitosamente.");
    }

    private void calcularPromedioAcademico() {
        String idEmpleado = vista.obtenerEntrada("Ingrese ID del empleado: ");
        Empleado empleado = sistemaFormacion.getEmpleado(idEmpleado);
        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado.");
            return;
        }

        double promedio = empleado.calcularPromedioAcademico();
        vista.mostrarMensaje("El promedio académico de " + empleado.getNombre() + " es " + promedio);
    }

    private void agregarDocumento() {
        String nombreDocumento = vista.obtenerEntrada("Ingrese nombre del documento: ");
        String tipoDocumento = vista.obtenerEntrada("Ingrese tipo del documento (Legal, Financiero, Operativo, etc.): ");

        Documento documento = new Documento(nombreDocumento, tipoDocumento);
        sistemaIPO.getProcesoIPO("CosmeticaGlamour").agregarDocumento(documento);
        vista.mostrarMensaje("Documento agregado exitosamente.");
    }

    private void marcarDocumentoCompletado() {
        String nombreDocumento = vista.obtenerEntrada("Ingrese nombre del documento: ");

        sistemaIPO.getProcesoIPO("CosmeticaGlamour").marcarDocumentoCompletado(nombreDocumento);
        vista.mostrarMensaje("Documento marcado como completado.");
    }

    private void agregarRequisito() {
        String descripcionRequisito = vista.obtenerEntrada("Ingrese descripción del requisito: ");

        Requisito requisito = new Requisito(descripcionRequisito);
        sistemaIPO.getProcesoIPO("CosmeticaGlamour").agregarRequisito(requisito);
        vista.mostrarMensaje("Requisito agregado exitosamente.");
    }

    private void marcarRequisitoCumplido() {
        String descripcionRequisito = vista.obtenerEntrada("Ingrese descripción del requisito: ");

        sistemaIPO.getProcesoIPO("CosmeticaGlamour").marcarRequisitoCumplido(descripcionRequisito);
        vista.mostrarMensaje("Requisito marcado como cumplido.");
    }

    private void seguirHito() {
        String hito = vista.obtenerEntrada("Ingrese hito del proceso: ");

        sistemaIPO.seguirHito("CosmeticaGlamour", hito);
        vista.mostrarMensaje("Hito agregado al seguimiento del proceso.");
    }
}
