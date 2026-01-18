package model;

import java.util.List;

public class Carrera {

    private int kmObjetivo;
    private List<Coche> coches;

    public Carrera(int kmObjetivo, List<Coche> coches) {
        this.kmObjetivo = kmObjetivo;
        this.coches = coches;
    }

    public int getKmObjetivo() {
        return kmObjetivo;
    }

    public List<Coche> getCoches() {
        return coches;
    }
}
