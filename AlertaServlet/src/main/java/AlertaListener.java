

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AlertaListener implements ServletContextListener, HttpSessionListener {

    public AlertaListener() {
        
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	session.setAttribute("msgIndex", 0);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { }

    public void contextDestroyed(ServletContextEvent sce)  { }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("qtdSessoes", 0);
    }
	
}
