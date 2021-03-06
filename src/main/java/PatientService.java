
import business.JWTHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("aftale") //dette gør at den bliver samlet op at tomcat og bliver brugt
public class PatientService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //metoden getAftale får sin token fra script async function hentAftale() den bliver er splitet fra Bearer og derefter valideret i JWThandler og hvis den er godkendt
    //har man adgang til dataen
    public List<Aftale> getAftaler(@HeaderParam("authorization") String token) throws SQLException {//validere en token
        String s = token.split(" ")[1];
        JWTHandler.validate(s);
        return PatientDao.getInstance().getAftale();

    }

    @GET
    @Path("{cpr}")
    public String getAftale(@PathParam("cpr") String cpr) {//

        return null;

    }


    @POST@Consumes(MediaType.APPLICATION_JSON)// @consumes fortæller jason at den skal seralisere  disse data
    @Produces(MediaType.APPLICATION_JSON)

    public Aftale postAftale(Aftale a) throws SQLException {
        System.out.println(a.getCpr());
        System.out.println(a.getName());
        System.out.println(a.gettidspunkt());
        System.out.println(a.getdato());
        System.out.println(a.getnotat());
        PatientDao.getInstance().saveAftale(a);
        Response.status(400).entity("message").build();
        return a;

        }
     }






