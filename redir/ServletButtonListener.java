package redir;
import javax.servlet.*;

public class ServletButtonListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent ev){
		ServletContext con = ev.getServletContext();
		String partarget = con.getInitParameter("target");
		UrlGet redir = new UrlGet(partarget);
		con.setAttribute("targetURL", redir);
		
		
	}
	public void contextDestroyed(ServletContextEvent ev){
		
	}
}
