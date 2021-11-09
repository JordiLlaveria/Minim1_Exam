package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ManagerTest {
    ManagerImpl manager;
    Usuari Jordi;
    Usuari Joana;
    Usuari Maria;
    PuntoInteres EETAC;
    PuntoInteres EEAAB;
    PuntoInteres Biblioteca;
    @Before
    public void setUp  () {
        //Declarat null per fer us del Singleton
        manager = null;

        //Comanda per utilitzar funcions manager:

        Joana = new Usuari("Joana","1");
        Jordi = new Usuari("Jordi","2");
        Maria = new Usuari("Maria","3");
        manager.getInstance().añadirUsuario(Joana);
        manager.getInstance().añadirUsuario(Jordi);
        manager.getInstance().añadirUsuario(Maria);

        EETAC = new PuntoInteres("EETAC",17,7);
        EEAAB = new PuntoInteres("EEAAB", 15,8);
        Biblioteca = new PuntoInteres("Biblioteca", 12,1);
        manager.getInstance().añadirPuntoInteres(EETAC);
        manager.getInstance().añadirPuntoInteres(EEAAB);
        manager.getInstance().añadirPuntoInteres(Biblioteca);

        manager.getInstance().añadirVisita(EETAC,Joana);
        manager.getInstance().añadirVisita(EEAAB,Jordi);

    }

    @Test
    public void ProbaañadirVisita() {
        Assert.assertEquals(manager.getInstance().getNumVisitas(),2);
        manager.getInstance().añadirVisita(Biblioteca,Jordi);
        Assert.assertEquals(manager.getInstance().getNumVisitas(),3);

    }
    @Test
    public void ProbaOrdenarAlfabeticamente() throws EmptyList {
        List noms = manager.getInstance().ordenarUsuariosAlfabeticamente();
        Assert.assertEquals(noms.get(0),"Joana");
    }

    @Test
    public void ComprovarInformacio(){
        Assert.assertEquals(manager.getInstance().getUsuari("Joana").getUsuariID(),"1");
    }

    @Test
    public void ComprovarPuntsUsuari(){
        List<PuntoInteres> puntos = manager.getInstance().listadopuntosUser("Joana");
        Assert.assertEquals(puntos.get(0).getNombre(),"EETAC");
    }
    @Test
    public void OrdenarPerPuntsVisitats() throws EmptyList {
        manager.getInstance().añadirVisita(EETAC,Jordi);
        List<Usuari> ordenats = manager.getInstance().ordenarUsuariosPuntosInteresVisitados();
        Assert.assertEquals(ordenats.get(0).getNomUsuari(),"Jordi");
    }

    @Test
    public void UsuariosPuntoInteres(){
        List<Usuari> usuaris = manager.getInstance().listadoUsuariosPuntoInteres(EETAC);
        Assert.assertEquals(usuaris.size(),1);
    }

    @Test
    public void GetPuntoInteres(){
        PuntoInteres p = manager.getInstance().getPuntoInteres("EETAC");

    }

    @After
    public void tearDown(){

        manager.getInstance().borrarTot();

    }
}