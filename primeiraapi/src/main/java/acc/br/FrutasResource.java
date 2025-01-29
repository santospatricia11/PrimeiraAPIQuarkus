package acc.br;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import acc.br.model.Fruta;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutasResource {

   @Inject
    EntityManager entityManager;

    @GET
    public List<Fruta> listarFrutas() {
        return Fruta.listAll();
    }
 
    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
        try {
            fruta.persist(); // Não precisa setar o id manualmente
        return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Caso haja algum erro, retorne uma resposta de erro
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Erro ao adicionar fruta: " + e.getMessage()).build();
        }
    }

}

