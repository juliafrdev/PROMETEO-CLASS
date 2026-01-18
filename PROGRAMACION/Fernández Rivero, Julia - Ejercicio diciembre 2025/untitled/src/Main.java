import controller.CampeonatoController;
import model.Campeonato;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1) Pedir coches
        List<Coche> coches = new ArrayList<>();

        System.out.print("¿Cuántos coches participan? ");
        int numCoches = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numCoches; i++) {
            System.out.println("\nCoche " + i);

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            coches.add(new Coche(marca, modelo));
        }

        // 2) Pedir número de carreras del campeonato
        System.out.print("\n¿Cuántas carreras tiene el campeonato? ");
        int numCarreras = sc.nextInt();
        sc.nextLine();

        // 3) Crear lista de carreras (cada una con sus km objetivo)
        List<Carrera> carreras = new ArrayList<>();

        for (int i = 1; i <= numCarreras; i++) {
            System.out.print("Km objetivo de la carrera " + i + ": ");
            int kmObjetivo = sc.nextInt();
            sc.nextLine();

            // La carrera usa los mismos coches (participan en todas)
            carreras.add(new Carrera(kmObjetivo, coches));
        }

        // 4) Crear campeonato y ejecutarlo
        Campeonato campeonato = new Campeonato(carreras);

        CampeonatoController campeonatoController = new CampeonatoController();
        campeonatoController.ejecutarCampeonato(campeonato, coches);
    }
}
