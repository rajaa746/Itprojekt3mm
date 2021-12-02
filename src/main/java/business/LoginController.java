package business;

import javax.ws.rs.WebApplicationException;
import datalayer.UserDAO;
import model.LoginData;


public class LoginController {
    private static UserDAO userDAO = new UserDAO();


    public String validateUser(LoginData loginData) {
        //Prøv at se om der er en bruger der matcher username?

        System.out.println(loginData);
        LoginData user = userDAO.findUser(loginData.getUsername());
        System.out.println(user);
        //Kontroller om der var en bruger med det rette kodeord?
        if (user !=null && user.getPassword().equals(loginData.getPassword())) {
            //returner en token!
            return JWTHandler.generateJwtToken(loginData);

        }
        //Afvis med en 401 hvis login fejler!
        throw new WebApplicationException(401);
    }
}

