package model;

import java.util.List;

public class Campeonato {

    private List<Carrera> carreras;

    public Campeonato(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }
}
