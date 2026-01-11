import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //El usuario introduce la n y se crea la matriz
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la n de su matriz:");
        int n = scanner.nextInt();

        int [][] matriz = new int[n][n];

        // Se recorre la matriz

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++){
                matriz[i][j] = 1;
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }



    }


}