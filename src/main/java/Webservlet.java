import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = "/api"
)

public class Webservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter writer = resp.getWriter();
        writer.println("Hello");
        writer.close();
// bruger servlet tomcat har for at kommunikere med applikationen denne klasse søger for at servlet kan modtage og respondere på anmodninger

    }
}

