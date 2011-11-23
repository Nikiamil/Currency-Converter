package redir;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServiceRedirect extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		UrlGet redirectLocation = (UrlGet)getServletContext().getAttribute("targetURL");
		response.sendRedirect(response.encodeRedirectURL(redirectLocation.sendUrl()));
		
	}

}
