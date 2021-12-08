package business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import model.LoginData;


import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.NotAuthorizedException;
import java.security.Key;
import java.util.Calendar;




public class JWTHandler {

    private static Key key; //der laves en private key
    private static final int TOKEN_EXPIRY = 2880; //2 days længden på hvor længde vores token skal overleve

    public static String generateJwtToken(LoginData user){ //
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        return Jwts.builder()
                .setIssuer("test")
                .claim("user", user.getUsername()) //data, token skal indholde
                .signWith(SignatureAlgorithm.HS512, getKey()) //signatur
                .setExpiration(expiry.getTime())
                .compact();
    }



    private static Key getKey(){ //server genere en krypteret JWT med en hemmelige nøgler og sender tilbage til klienten
        //der bruges en hemmelige nøgle til at signere token

        if (key==null) {
            if (System.getenv("JWT_SECRET_KEY")!= null && System.getenv("JWT_SECRET_KEY") != "") {
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }
// validerng af token
    public static String validate(String authentication) {
        String[] tokenArray = authentication.split(" ");
        String token = tokenArray[tokenArray.length - 1];
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getKey())
                    .parseClaimsJws(token)
                    .getBody();
            String user = claims.get("user", String.class);
            System.out.println(user);
            return user;
        } catch (JwtException e){
            System.out.println(e.getClass() +":  "+ e.getMessage() );
            throw new NotAuthorizedException(e.getMessage());
        }
    }



}




