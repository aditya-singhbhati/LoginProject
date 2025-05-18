import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        ServletConfig config = getServletConfig();
        String storedUsername = config.getInitParameter("username");
        String storedPassword = config.getInitParameter("password");

        if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
            out.println("<h2>Login Successful!<h2>");
        } else {
            out.println("<h2>Invalid Username or Password!</h2>");
        }

        out.close();
    }
}
