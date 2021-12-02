package datalayer;

import model.LoginData;

import java.sql.*;



public class UserDAO {



    public LoginData findUser(String brugernavn) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-db.caprover.diplomportal.dk:3306/s205499";
            String user = "s205499";
            String pass = "77BJ4H2NODdIsbVtV8FF0";

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM bruger WHERE brugernavn = ?;");
            preparedStatement.setString(1,brugernavn);
            ResultSet rs = preparedStatement.executeQuery();
            LoginData loginData=new LoginData();
            while (rs.next()) {
                String username = rs.getString("brugernavn");
                String password = rs.getString("kode");
                System.out.println(username);
                System.out.println(password);
                loginData.setUsername(username);
                loginData.setPassword(password);
            statement.close();
            return loginData;

        }} catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
}


