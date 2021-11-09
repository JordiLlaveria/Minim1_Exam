package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class PuntoInteres {

    String nombre;
    double puerta;
    double numero;
    List<Usuari> llistaUsuaris = new LinkedList<Usuari>();

    public PuntoInteres(){}

    public PuntoInteres(String nombre, double puerta, double numero) {
        this();
        this.setNombre(nombre);
        this.setPuerta(puerta);
        this.setNumero(numero);
    }

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public double getPuerta() {
        return this.puerta;
    }

    public void setPuerta(double puerta) {
        this.puerta = puerta;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public void setVisitaUsuari(Usuari usuari){this.llistaUsuaris.add(usuari);}
    public List<Usuari> getVisitas(){return this.llistaUsuaris;}

    public void afegirUsuari(Usuari usuari){
        this.setVisitaUsuari(usuari);
    }

    /*
    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public void ventaRealizada(int numero){
        this.ventas = this.ventas + numero;
    }
    */
    public int compareTo(PuntoInteres a)
    {
        int res = (int) (this.getNumero()-a.getNumero());
        return res;
    }
    /*
    public String toString() {
        return "Producto [Nombre= "+ puerta + " precio = " + numero + " ventas = "+ ventas+"]";
    }
    */

}