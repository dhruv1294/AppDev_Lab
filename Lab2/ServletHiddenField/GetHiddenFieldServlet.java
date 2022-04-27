import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 public class GetHiddenFieldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
     public GetHiddenFieldServlet() {
     }
     protected void doPost(HttpServletRequest request, 
	HttpServletResponse response)
	             throws ServletException, IOException {
	response.setContentType("text/html"); 
    	PrintWriter out = response.getWriter();
        	String userName = request.getParameter("userName").trim();
    	String password = request.getParameter("password").trim();
     	out.println("Username: " + userName + "<br/><br/>");
    	out.println("Password: " + password);
     	out.close();
   }
}
