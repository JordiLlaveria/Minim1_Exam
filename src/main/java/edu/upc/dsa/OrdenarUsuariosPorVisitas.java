package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;

import java.util.Comparator;

public class OrdenarUsuariosPorVisitas implements Comparator<Usuari> {

    public int compare(Usuari u1, Usuari u2){

        return (int)(u1.getNumPuntsInteres() - u2.getNumPuntsInteres());

    }

}