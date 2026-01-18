package controller;

import model.Campeonato;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CampeonatoController {

    private final CarreraController carreraController = new CarreraController();

    public void ejecutarCampeonato(Campeonato campeonato, List<Coche> coches) {

        int numCarrera = 1;

        for (Carrera carrera : campeonato.getCarreras()) {
            System.out.println("\n====================");
            System.out.println("=== CARRERA " + numCarrera + " ===");
            System.out.println("====================");

            carreraController.simularCarrera(carrera);

            mostrarClasificacionGeneral(coches);

            numCarrera++;
        }

        System.out.println("\n==============================");
        System.out.println("=== CLASIFICACIÓN FINAL ===");
        System.out.println("==============================");
        mostrarClasificacionGeneral(coches);
    }

    private void mostrarClasificacionGeneral(List<Coche> coches) {
        // Copia para ordenar sin “romper” la lista original
        List<Coche> ordenados = new ArrayList<>(coches);

        // Ordenar por puntos (desc). Si empatan, por nombre
        ordenados.sort((a, b) -> {
            if (b.getPuntos() != a.getPuntos()) {
                return Integer.compare(b.getPuntos(), a.getPuntos());
            }
            return a.nombreCoche().compareToIgnoreCase(b.nombreCoche());
        });

        System.out.println("\n=== CLASIFICACIÓN GENERAL ===");
        for (int i = 0; i < ordenados.size(); i++) {
            Coche c = ordenados.get(i);
            System.out.println((i + 1) + "º - " + c.nombreCoche() + " | Puntos: " + c.getPuntos());
        }

        if (!ordenados.isEmpty()) {
            System.out.println("Líder: " + ordenados.get(0).nombreCoche());
        }
    }
}
