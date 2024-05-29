package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    // Paneles del menú principal
    private JPanel panelMenuPrincipal;
    private JButton btnGestionFormacion;
    private JButton btnGestionIPO;
    private JButton btnSalir;

    // Paneles de gestión de formación
    private JPanel panelFormacion;
    private JButton btnInscribirEmpleado;
    private JButton btnRegistrarNota;
    private JButton btnEmitirCertificado;
    private JButton btnCalcularPromedio;
    private JButton btnVolverFormacion;

    // Paneles de gestión de IPO
    private JPanel panelIPO;
    private JButton btnAgregarDocumento;
    private JButton btnMarcarDocumento;
    private JButton btnAgregarRequisito;
    private JButton btnMarcarRequisito;
    private JButton btnSeguirHito;
    private JButton btnVolverIPO;

    public Vista() {
        setTitle("Sistema de Gestión Empresarial");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        add(panelPrincipal);

        // Panel del menú principal
        panelMenuPrincipal = new JPanel();
        panelMenuPrincipal.setLayout(new GridLayout(3, 1));
        btnGestionFormacion = new JButton("Gestión de Formación");
        btnGestionIPO = new JButton("Gestión de IPO");
        btnSalir = new JButton("Salir");
        panelMenuPrincipal.add(btnGestionFormacion);
        panelMenuPrincipal.add(btnGestionIPO);
        panelMenuPrincipal.add(btnSalir);
        panelPrincipal.add(panelMenuPrincipal, "MenuPrincipal");

        // Panel de gestión de formación
        panelFormacion = new JPanel();
        panelFormacion.setLayout(new GridLayout(5, 1));
        btnInscribirEmpleado = new JButton("Inscribir empleado en curso");
        btnRegistrarNota = new JButton("Registrar nota");
        btnEmitirCertificado = new JButton("Emitir certificado");
        btnCalcularPromedio = new JButton("Calcular promedio académico");
        btnVolverFormacion = new JButton("Volver al menú principal");
        panelFormacion.add(btnInscribirEmpleado);
        panelFormacion.add(btnRegistrarNota);
        panelFormacion.add(btnEmitirCertificado);
        panelFormacion.add(btnCalcularPromedio);
        panelFormacion.add(btnVolverFormacion);
        panelPrincipal.add(panelFormacion, "Formacion");

        // Panel de gestión de IPO
        panelIPO = new JPanel();
        panelIPO.setLayout(new GridLayout(6, 1));
        btnAgregarDocumento = new JButton("Agregar documento");
        btnMarcarDocumento = new JButton("Marcar documento como completado");
        btnAgregarRequisito = new JButton("Agregar requisito");
        btnMarcarRequisito = new JButton("Marcar requisito como cumplido");
        btnSeguirHito = new JButton("Seguir hito del proceso");
        btnVolverIPO = new JButton("Volver al menú principal");
        panelIPO.add(btnAgregarDocumento);
        panelIPO.add(btnMarcarDocumento);
        panelIPO.add(btnAgregarRequisito);
        panelIPO.add(btnMarcarRequisito);
        panelIPO.add(btnSeguirHito);
        panelIPO.add(btnVolverIPO);
        panelPrincipal.add(panelIPO, "IPO");
    }

    public void mostrarMenuPrincipal() {
        cardLayout.show(panelPrincipal, "MenuPrincipal");
    }

    public void mostrarMenuFormacion() {
        cardLayout.show(panelPrincipal, "Formacion");
    }

    public void mostrarMenuIPO() {
        cardLayout.show(panelPrincipal, "IPO");
    }

    public void agregarListenerBotonGestionFormacion(ActionListener listener) {
        btnGestionFormacion.addActionListener(listener);
    }

    public void agregarListenerBotonGestionIPO(ActionListener listener) {
        btnGestionIPO.addActionListener(listener);
    }

    public void agregarListenerBotonSalir(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }

    public void agregarListenerBotonInscribirEmpleado(ActionListener listener) {
        btnInscribirEmpleado.addActionListener(listener);
    }

    public void agregarListenerBotonRegistrarNota(ActionListener listener) {
        btnRegistrarNota.addActionListener(listener);
    }

    public void agregarListenerBotonEmitirCertificado(ActionListener listener) {
        btnEmitirCertificado.addActionListener(listener);
    }

    public void agregarListenerBotonCalcularPromedio(ActionListener listener) {
        btnCalcularPromedio.addActionListener(listener);
    }

    public void agregarListenerBotonVolverFormacion(ActionListener listener) {
        btnVolverFormacion.addActionListener(listener);
    }

    public void agregarListenerBotonAgregarDocumento(ActionListener listener) {
        btnAgregarDocumento.addActionListener(listener);
    }

    public void agregarListenerBotonMarcarDocumento(ActionListener listener) {
        btnMarcarDocumento.addActionListener(listener);
    }

    public void agregarListenerBotonAgregarRequisito(ActionListener listener) {
        btnAgregarRequisito.addActionListener(listener);
    }

    public void agregarListenerBotonMarcarRequisito(ActionListener listener) {
        btnMarcarRequisito.addActionListener(listener);
    }

    public void agregarListenerBotonSeguirHito(ActionListener listener) {
        btnSeguirHito.addActionListener(listener);
    }

    public void agregarListenerBotonVolverIPO(ActionListener listener) {
        btnVolverIPO.addActionListener(listener);
    }

    public String obtenerEntrada(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }

    public double obtenerNota(String mensaje) {
        String input = JOptionPane.showInputDialog(this, mensaje);
        return Double.parseDouble(input);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
