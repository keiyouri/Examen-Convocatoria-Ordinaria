package Ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaIPO {
    private static SistemaIPO instancia;
    private Map<String, IPOProceso> procesosIPO;
    private List<Actor> actores;

    private SistemaIPO() {
        this.procesosIPO = new HashMap<>();
        this.actores = new ArrayList<>();
    }

    public static synchronized SistemaIPO getInstancia() {
        if (instancia == null) {
            instancia = new SistemaIPO();
        }
        return instancia;
    }

    public void agregarProcesoIPO(String nombreEmpresa, IPOProceso proceso) {
        procesosIPO.put(nombreEmpresa, proceso);
    }

    public IPOProceso getProcesoIPO(String nombreEmpresa) {
        return procesosIPO.get(nombreEmpresa);
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void seguirHito(String nombreEmpresa, String hito) {
        IPOProceso proceso = procesosIPO.get(nombreEmpresa);
        if (proceso != null) {
            proceso.agregarHito(hito);
        }
    }
}
