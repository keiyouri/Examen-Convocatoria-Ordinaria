package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class IPOProceso {
    private List<Documento> documentos;
    private List<Requisito> requisitos;
    private List<String> hitos;

    public IPOProceso() {
        this.documentos = new ArrayList<>();
        this.requisitos = new ArrayList<>();
        this.hitos = new ArrayList<>();
    }

    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public void agregarRequisito(Requisito requisito) {
        requisitos.add(requisito);
    }

    public void agregarHito(String hito) {
        hitos.add(hito);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public List<String> getHitos() {
        return hitos;
    }

    public void marcarDocumentoCompletado(String nombreDocumento) {
        for (Documento doc : documentos) {
            if (doc.getNombre().equals(nombreDocumento)) {
                doc.marcarCompletado();
                break;
            }
        }
    }

    public void marcarRequisitoCumplido(String descripcionRequisito) {
        for (Requisito req : requisitos) {
            if (req.getDescripcion().equals(descripcionRequisito)) {
                req.marcarCumplido();
                break;
            }
        }
    }
}
