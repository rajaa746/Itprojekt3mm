
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("patients")
public class PatientService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getPatients() {
        return PatientDao.getInstance().getPatients();

    }

    @GET
    @Path("{cpr}")
    public Patient getPatient(@PathParam("cpr") String cpr) {

        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        PatientDao.getInstance().getPatients().add(p);
        Response.status(400).entity("message").build();
        return p;

        }
     }






