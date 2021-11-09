package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuari;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.*;
import java.util.List;

@Api(value = "/visita", description = "Endpoint to Track Service")
@Path("/visita")
public class VisitasService extends EmptyList{
    private Manager manager;
        public VisitasService() throws EmptyList {
            this.manager = ManagerImpl.getInstance();
            if (this.manager.size()==0){

                Usuari Joana = new Usuari("Joana","1");
                Usuari Jordi = new Usuari("Jordi","2");
                Usuari Maria = new Usuari("Maria","3");
                manager.añadirUsuario(Joana);
                manager.añadirUsuario(Jordi);
                manager.añadirUsuario(Maria);

                PuntoInteres EETAC = new PuntoInteres("EETAC",17,7);
                PuntoInteres EEAAB = new PuntoInteres("EEAAB", 15,8);
                PuntoInteres Biblioteca = new PuntoInteres("Biblioteca", 12,1);
                manager.añadirPuntoInteres(EETAC);
                manager.añadirPuntoInteres(EEAAB);
                manager.añadirPuntoInteres(Biblioteca);

                manager.añadirVisita(EETAC,Joana);
                manager.añadirVisita(Biblioteca,Jordi);
                manager.añadirVisita(EEAAB,Jordi);
                manager.setsize(1);
            }
    }
    /*
    @GET
    @ApiOperation(value = "get Nombres Ordenados Alfabeticamente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = String.class, responseContainer="List"),
    })
    @Path("/ordenats_preu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductosOrdenadosPrecio() throws EmptyList {

        List<String> nombres = new ArrayList<String>();
        nombres = this.manager.ordenarUsuariosAlfabeticamente();

        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(nombres);
        return Response.status(201).entity(entity).build()  ;
    }
     */

    @GET
    @ApiOperation(value = "get puntos interes visitados", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Comanda not found")
    })
    @Path("/{nom_usuari}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosUser(@PathParam("nom_usuari") String nomusuari) {
        List<PuntoInteres> puntos_user = manager.listadopuntosUser(nomusuari);
        GenericEntity<List<PuntoInteres>> entity = new GenericEntity<List<PuntoInteres>>(puntos_user) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get informació usuari", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class),
            @ApiResponse(code = 404, message = "Comanda not found")
    })
    @Path("/informaciousuari/{nom_usuari}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("nom_usuari") String nomusuari) {
        Usuari usuari = manager.getUsuari(nomusuari);
        GenericEntity<Usuari> entity = new GenericEntity<Usuari>(usuari) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get usuaris que han passat per un punt", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class),
            @ApiResponse(code = 404, message = "Comanda not found")
    })
    @Path("/usuaris_punt/{punt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarisPuntoInteres(@PathParam("nom_punt") String nompunt) {
        PuntoInteres punto = manager.getPuntoInteres(nompunt);
        GenericEntity<List<Usuari>> entity = new GenericEntity<List<Usuari>>(punto.getVisitas()) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get usuarios ordenados por visitas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuari.class, responseContainer="List"),
    })
    @Path("/ordenats_visitas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuariosOrdenadosPorVisitas() throws EmptyList {

        List<Usuari> puntosvisitados = this.manager.ordenarUsuariosPuntosInteresVisitados();

        GenericEntity<List<Usuari>> entity = new GenericEntity<List<Usuari>>(puntosvisitados) {};
        return Response.status(201).entity(entity).build()  ;
    }
    /*
    @POST
    @ApiOperation(value = "Añadir visita", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PuntoInteres.class),
            @ApiResponse(code = 404, message = "Comanda couldn't be done")
    })

    @Path("/realitzar_comanda")
    @Produces(MediaType.APPLICATION_JSON)
    public Response realizarPedido(PuntoInteres p) {
        if (p.getPuntointeres()!=null || puntosInteresVisitados.getLlistaUsuaris() != null){
            this.manager.añadirVisita();
            this.manager.realizarPedido(puntosInteresVisitados);
            return Response.status(201).entity(puntosInteresVisitados).build();
        }
        else{
            return Response.status(404).entity(puntosInteresVisitados).build();
        }
    }

        */
}