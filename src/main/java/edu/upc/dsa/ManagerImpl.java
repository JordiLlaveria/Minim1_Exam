package edu.upc.dsa;

import java.util.*;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {

    //private Queue<Comanda> misComandas; (.add("") , .peek() -> Ver primer elemento , .poll() -> Sacar primer elemento)
    private List<PuntoInteres> listaPuntosInteres;
    private List<Usuari> llistaUsuaris; //(.put(<"","">) , .get("") , .remove("") , .size() , .clear())
    //private ArrayList<MarcaVacunas> listMarcas; (.get(position) , .set(position, value) , .remove(position) , .size() , .add("")

    public int NumVisitas=0;
    int size=0;
    //Implementació Singleton
    private static ManagerImpl instance;
    private ManagerImpl(){
        //Creació llistes varies

        listaPuntosInteres = new LinkedList<PuntoInteres>(); //(same as ArrayList)
        llistaUsuaris = new LinkedList<Usuari>(); //(<Identificador amb el que es busca, Element afegit>)
    }
    public static ManagerImpl getInstance(){
        if (instance==null){
            instance=new ManagerImpl();
        }
        return instance;
    }

    //Implementació Log4j
    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    //logger.info("");
    //logger.warn("");

    public void añadirUsuario(Usuari usuari){
        this.llistaUsuaris.add(usuari);
        logger.info("Usuari" + usuari.getNomUsuari() + " afegit");
    }

    @Override
    public void añadirPuntoInteres(PuntoInteres p) {
        this.listaPuntosInteres.add(p);
        logger.info("Punto interes " + p.getNombre() + " añadido");
    }

    @Override
    public List<String> ordenarUsuariosAlfabeticamente() throws EmptyList {
        int i=0;
        List noms = new LinkedList<>();
        while (i<this.llistaUsuaris.size()) {
            noms.add(llistaUsuaris.get(i).getNomUsuari());
            i++;
        }
        Collections.sort(noms);
        logger.info("Lista Ordenada Alfabeticamente");
        return noms;
    }

    @Override
    public void añadirVisita(PuntoInteres punto, Usuari usuari) {
        logger.info("El usuari "+usuari.getNomUsuari()+ " ha realitzat una visita");
        punto.setVisitaUsuari(usuari);
        usuari.afegirPuntsInteres(punto);
        logger.info("La visita ha estat afegida");
        usuari.incrementarNumpuntsinteres();
        this.NumVisitas++;

    }

    @Override
    public List<PuntoInteres> listadopuntosUser(String nombre) {
        double encontrado = 0;
        List<PuntoInteres> puntos = new LinkedList<PuntoInteres>();
        for (int i=0; i<llistaUsuaris.size(); i++)
        {
            if (llistaUsuaris.get(i).getNomUsuari().equals(nombre))
            {
                puntos = llistaUsuaris.get(i).getLlistaPuntsInteres();
                logger.info("Encontrados puntos de interes visitador por " + nombre);
                encontrado = 1;
            }
        }
        if (encontrado==1){
            return puntos;
        }
        else{
            logger.warn("No se han encontrado puntos para este usuario");
            return puntos;
        }
    }

    @Override
    public List<Usuari> listadoUsuariosPuntoInteres(PuntoInteres punto) {
        logger.info("Listado de Usuarios que han visitado un Punto de Interes");
        return punto.getVisitas();
    }

    @Override
    public List<Usuari> ordenarUsuariosPuntosInteresVisitados() throws EmptyList {
        List<Usuari> listaOrdenada = this.llistaUsuaris;
        Collections.sort(listaOrdenada,new OrdenarUsuariosPorVisitas().reversed());
        logger.info("Listado Ordenado por visitas hecho");
        return listaOrdenada;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int setsize(int i) {
        return size=i;
    }

    @Override
    public int getNumVisitas() {
        logger.info("Numero total de visitas encontrado");
        return this.NumVisitas;
    }

    @Override
    public Usuari getUsuari(String nom) {
        int i=0;
        int trobat = -1;
        while (i<this.llistaUsuaris.size()) {
            if (llistaUsuaris.get(i).getNomUsuari().equals(nom)) {
                trobat = i;
                logger.info("He encontrado al usuario de nombre "+llistaUsuaris.get(i).getNomUsuari());
            }
            i++;
        }
        if (trobat==-1){
            logger.info("No he podido encontrar el usuario");
            return null;
        }
        else{
            return llistaUsuaris.get(trobat);
        }
    }

    @Override
    public PuntoInteres getPuntoInteres(String nom) {
        int i=0;
        int trobat = -1;
        while (i<this.listaPuntosInteres.size()) {
            if (listaPuntosInteres.get(i).getNombre().equals(nom)) {
                trobat = i;
                logger.info("He encontrado el punto de nombre "+listaPuntosInteres.get(i).getNombre());
            }
            i++;
        }
        if (trobat==-1){
            logger.info("No he podido encontrar el punto de interes");
            return null;
        }
        else{
            return listaPuntosInteres.get(trobat);
        }
    }

    public void borrarTot(){
        //Funció utilitzada al Test per reiniciar totes les llistes utilitzades

        listaPuntosInteres.clear();
        llistaUsuaris.clear();
        logger.info("Listas reseteadas para seguir con los test");
    }

}
