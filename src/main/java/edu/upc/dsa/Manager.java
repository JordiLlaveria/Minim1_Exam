package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;

import java.util.List;

public interface Manager {
    //Aquí s'han d'afegir totes les accions que es volen realitzar i que es demanen al exercici

    public void añadirUsuario(Usuari usuari);
    public void añadirPuntoInteres(PuntoInteres p);
    public List ordenarUsuariosAlfabeticamente() throws EmptyList;
    public void añadirVisita(PuntoInteres punto, Usuari usuari);
    public List<PuntoInteres> listadopuntosUser(String nombre);
    public List<Usuari> listadoUsuariosPuntoInteres(PuntoInteres punto);
    public List<Usuari> ordenarUsuariosPuntosInteresVisitados() throws EmptyList;

    public int size();
    public int setsize(int i);
    public int getNumVisitas();
    public Usuari getUsuari(String nom);
    public PuntoInteres getPuntoInteres (String nom);

}
