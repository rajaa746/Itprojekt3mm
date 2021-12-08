package api;

import business.LoginController;
import datalayer.UserDAO;
import model.LoginData;
        import business.JWTHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("login")
public class ServiceLogin {
    private static LoginController loginCon = new LoginController();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    // Tager imod deserialiserede data fra frontenden til Java-Object
    public String doLogin(LoginData loginData){
        //returner en valideret token (hvis det går godt) til klienten
        String token = loginCon.validateUser(loginData);
        System.out.println(token);
        return token;
    }
}