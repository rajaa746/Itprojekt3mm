import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class PatientDao {



        //private List<aftale> Aftale = new ArrayList<>();
        private static PatientDao instance = new PatientDao();

    private PatientDao() {

        }
    public static PatientDao getInstance () {
        return instance;
    }



        public List<Aftale> getAftale () throws SQLException {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://mysql-db.caprover.diplomportal.dk:3306/s205499";
                String user = "s205499";
                String pass = "77BJ4H2NODdIsbVtV8FF0";

                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement statement = conn.createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM aftale");
                List<Aftale> aftaleList=new ArrayList<>();
                while (rs.next()) {
                    String cpr = rs.getString("cpr");
                    String navn = rs.getString("navn");
                   String tidspunkt = rs.getString("tidspunkt");
                    String dato = rs.getString("dato");
                   String notat = rs.getString("notat");

                    Aftale aftale = new Aftale();
                    aftale.setCpr(cpr);
                    aftale.setName(navn);
                    aftale.settidspunkt(tidspunkt);
                    aftale.setNotat(notat);
                    aftaleList.add(aftale);


                    System.out.println(cpr);
                   System.out.println(navn);
                   System.out.println(tidspunkt);
                    System.out.println(dato);
                   System.out.println(notat);



                }
                statement.close();
                return aftaleList;
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());

            }

            return null;

        }

        public void saveAftale (Aftale a){
            Connection conn = null;
            Statement stmt = null;



            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Connecting to database");
                conn = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk:3306/s205499", "s205499", "77BJ4H2NODdIsbVtV8FF0");
                System.out.println("You are now connected to database");

                System.out.println("Inserting data into table called aftale");
                stmt = conn.createStatement();

                //vi ??bner op for sql injection for at udng?? dette skal man lave en pepered statment
                // for at undg??r sql injektion skal der laves prepared statment hvilket filtre tegn

                String sql = "INSERT INTO aftale (cpr, navn,tidspunkt,dato,notat) VALUES ('"+a.getCpr()+"','"+a.getName()+"','"+a.gettidspunkt()+"','"+a.getdato()+"','"+a.getnotat()+"')";

                stmt.executeUpdate(sql);


                System.out.println("Inserted, check ...");

            }catch (SQLException se) {
                se.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();



            }finally {
                try{
                    if(stmt!=null)
                        conn.close();
                }catch (SQLException se){

                }
                try {
                    if (conn != null)
                        conn.close();
                }catch (SQLException se){
                    se.printStackTrace();
                }



            }


        }

    }



