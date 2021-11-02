import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String pass = "12345678";


            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT Fname, Address FROM Customers WHERE Fname = 'Meliha'");
            while(rs.next()){
                String Fname = rs.getString("Fname");
                String Address = rs.getString("Address");
                System.out.println(Fname);
                System.out.println(Address);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
    }
}

