
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("aftale")
public class PatientService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aftale> getAftale() throws SQLException {
        return PatientDao.getInstance().getAftale();

    }

    @GET
    @Path("{cpr}")
    public String getAftale(@PathParam("cpr") String cpr) {

        return null;
    }

    @POST@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Aftale postAftale(Aftale a) throws SQLException {
        System.out.println(a.getCpr());
        PatientDao.getInstance().saveAftale(a);
        Response.status(400).entity("message").build();
        return a;

        }
     }






