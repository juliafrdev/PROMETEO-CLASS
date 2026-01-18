package model;

public class Coche {
    private String marca;
    private String modelo;
    private int km;
    private int puntos;


//ESTO ES EL CONSTRUCTOR (“Para crear un coche, dime su marca y su modelo”)
public Coche(String marca, String modelo) {
    this.marca = marca; //"La marca de ESTE coche será la marca que me han dado"
    this.modelo = modelo;
    this.km = 0;
    this.puntos = 0;

}

//PARA DEVOLVER LOS DATOS A MAIN
public String getMarca() { return marca; }
    public String getModelo() {
    return modelo;
}

    public int getKm() {
    return km;
}
    public int getPuntos() {
    return puntos;
}

    //MÉOTODO PARA SUMAR LOS KILOMÉTROS (DATO + ACCION) sumarKm:
    //- recibe un número
    //- si es positivo, lo suma a los km del coche
    public void sumarKm(int kmSumados) {
        if (kmSumados > 0) {
            this.km += kmSumados;
        }
    }

    public void resetearKm() {
        this.km = 0;
    }

    public void sumarPuntos(int puntosSumados) {
        if (puntosSumados > 0) {
            this.puntos += puntosSumados;
        }
    }

    public String nombreCoche() {
        return marca + " " + modelo;
    }
}