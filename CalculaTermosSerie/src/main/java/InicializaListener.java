

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class InicializaListener implements ServletContextListener, HttpSessionListener {

    public InicializaListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	session.setAttribute("termo", 0);
    	session.setAttribute("ordemTermo", 1);
    	session.setAttribute("erros", 0);
    	session.setAttribute("acertos", 0);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { }

	public void contextDestroyed(ServletContextEvent sce)  { }

	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();
		context.setAttribute("errosTotais", 0);
    	context.setAttribute("acertosTotais", 0);
    }
	
}
