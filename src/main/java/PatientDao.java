import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class PatientDao {



        private List<Aftale> Aftale = new ArrayList<>();
        private static PatientDao instance = new PatientDao();

    private PatientDao() {
        /*
            Patient melman = new Patient();
            Patient marius = new Patient();
            melman.setName("melman");
            marius.setName("marius");
            patients.add(melman);
            patients.add(marius);

         */


        }
    public static PatientDao getInstance () {
        return instance;
    }



        public List<Aftale> getAftale () throws SQLException {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sys";
                String user = "root";
                String pass = "12345678";


                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement statement = conn.createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM aftale");
                while (rs.next()) {
                    String CPR = rs.getString("CPR");
                   // String Navn = rs.getString("Navn");
                   // String tid = rs.getString("tid");
                   // String dato = rs.getString("dato");
                   // String varighed = rs.getString("varighed");
                   // String Notat = rs.getString("Notat");
                   // String Emne = rs.getString("Emne");
                   // String LægeID = rs.getString("LægeID");

                    System.out.println(CPR);
                  //  System.out.println(Navn);
                   // System.out.println(tid);
                   // System.out.println(dato);
                   // System.out.println(varighed);
                   // System.out.println(Notat);
                   // System.out.println(Emne);
                   // System.out.println(LægeID);




                }
                statement.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());

            }


            return Aftale;
        }

        public void saveAftale (Aftale a){
            Connection conn = null;
            Statement stmt = null;



            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Connecting to database");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");
                System.out.println("You are now connected to database");

                System.out.println("Inserting data into table called aftale");
                stmt = conn.createStatement();

                String sql = "INSERT INTO aftale (cpr) VALUES ('"+a.getCpr()+"')";

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



