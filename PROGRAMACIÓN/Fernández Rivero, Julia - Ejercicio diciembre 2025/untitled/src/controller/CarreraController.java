package controller;

import model.Carrera;
import model.Coche;

import java.util.*;

public class CarreraController {

    private final Random random = new Random();

    // Simula una carrera, asigna puntos, y devuelve los coches ordenados (1º, 2º, 3º...)
    public List<Coche> simularCarrera(Carrera carrera) {

        // 1) Resetear km al iniciar la carrera (lo exige el enunciado para campeonato) :contentReference[oaicite:3]{index=3}
        for (Coche c : carrera.getCoches()) {
            c.resetearKm();
        }

        // 2) “Tiempo total” lo medimos como número de vueltas (simple y coherente)
        Map<Coche, Integer> vueltas = new HashMap<>();
        for (Coche c : carrera.getCoches()) {
            vueltas.put(c, 0);
        }

        // 3) Simulación por vueltas: todos avanzan 20-50 km
        boolean hayGanador = false;
        while (!hayGanador) {

            for (Coche c : carrera.getCoches()) {
                int kmAleatorios = random.nextInt(31) + 20; // 20..50 :contentReference[oaicite:4]{index=4}
                c.sumarKm(kmAleatorios);

                // suma 1 vuelta a ese coche
                vueltas.put(c, vueltas.get(c) + 1);
            }

            // ¿ya llegó alguien?
            for (Coche c : carrera.getCoches()) {
                if (c.getKm() >= carrera.getKmObjetivo()) {
                    hayGanador = true;
                    break;
                }
            }
        }

        // 4) Ordenar resultados: más km primero. Si empatan, menos vueltas primero
        List<Coche> ordenados = new ArrayList<>(carrera.getCoches());
        ordenados.sort((a, b) -> {
            if (b.getKm() != a.getKm()) return Integer.compare(b.getKm(), a.getKm()); // desc km
            return Integer.compare(vueltas.get(a), vueltas.get(b)); // asc vueltas
        });

        // 5) Asignar puntos (10, 8, 6 al top 3) :contentReference[oaicite:5]{index=5}
        if (ordenados.size() > 0) ordenados.get(0).sumarPuntos(10);
        if (ordenados.size() > 1) ordenados.get(1).sumarPuntos(8);
        if (ordenados.size() > 2) ordenados.get(2).sumarPuntos(6);

        // 6) Mostrar podio
        System.out.println("=== RESULTADO CARRERA ===");
        for (int i = 0; i < Math.min(3, ordenados.size()); i++) {
            Coche c = ordenados.get(i);
            int puntos = (i == 0) ? 10 : (i == 1) ? 8 : 6;
            System.out.println((i + 1) + "º - " + c.nombreCoche()
                    + " | Km: " + c.getKm()
                    + " | Vueltas: " + vueltas.get(c)
                    + " | +" + puntos + " puntos");
        }

        return ordenados;
    }
}
