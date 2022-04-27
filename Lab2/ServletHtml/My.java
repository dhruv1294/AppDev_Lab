import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class My extends HttpServlet{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

    PrintWriter pw = res.getWriter();
 
    Enumeration e = req.getParameterNames();
     
    while(e.hasMoreElements())
     
    {
     
    String pname = (String)e.nextElement();
     
    pw.print(pname + " = ");
     
    String pvalue = request.getParameter(pname);
     
    pw.println(pvalue);
     
    }
     
    pw.close();
}

}