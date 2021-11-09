package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Usuari {

    List<PuntoInteres> llistaPuntsInteres = new LinkedList<PuntoInteres>();
    String usuariID;
    String nomusuari;
    double numpuntsinteres;

    public Usuari(){}
    public Usuari (String nomusuari, String usuariID) {
        this();
        this.setNomUsuari(nomusuari);
        this.setUsuariID(usuariID);
        this.setNumpuntsinteres(0);
    }

    public void setNomUsuari(String nom) {
        this.nomusuari = nom;
    }
    public void setUsuariID(String id){this.usuariID=id;}
    public String getUsuariID(){
            return this.usuariID;
    }
    public String getNomUsuari(){return this.nomusuari;}
    public void setNumpuntsinteres(int i){this.numpuntsinteres=i;}
    public void incrementarNumpuntsinteres(){this.numpuntsinteres++;}
    public double getNumPuntsInteres(){return this.numpuntsinteres;}
    public List<PuntoInteres> getLlistaPuntsInteres(){return this.llistaPuntsInteres;}
    public void setLlistaPuntsInteres(PuntoInteres punto){this.llistaPuntsInteres.add(punto);}

    public void afegirPuntsInteres(PuntoInteres punto){
        this.setLlistaPuntsInteres(punto);
        this.incrementarNumpuntsinteres();
    }

    /*
    public List<Comanda> getLlistaComandesServides(){
            return this.llistaComandesServides;
        }

    //public String toString() {
        //return "Producto [Nombre= "+nombre+ " precio = " + precio + " ventas = "+ ventas+"]";
    //}

     */
}

