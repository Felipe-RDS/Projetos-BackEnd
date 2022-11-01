

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.ContextConfig;

public class AlertaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object sync = new Object();
    public AlertaServlet() {
        super();
    }

    public String msgAlerta(int index) {
    	String[] alerta = {"Alerta verde","Alerta amarelo","Alerta vermelho"};
    	return alerta[index];
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		
		ServletContext context = getServletContext();
		
		synchronized (sync) {
			int qtdSessoes = (Integer) context.getAttribute("qtdSessoes");
			context.setAttribute("qtdSessoes", ++qtdSessoes);
			if(qtdSessoes > 2)
				resposta = "Numero maximo de sessoes atingido";
		}
		exibe(request, response, resposta);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		
		HttpSession session = request.getSession();
		
		int msgIndex = (Integer) session.getAttribute("msgIndex");
		if(msgIndex > 2) {
			session.setAttribute("msgIndex", 0);
			msgIndex = (Integer) session.getAttribute("msgIndex");
		}
		resposta = msgAlerta(msgIndex);
		session.setAttribute("msgIndex", ++msgIndex);
		
		exibe(request, response, resposta);
	}
				
	
	 private void exibe(HttpServletRequest request, HttpServletResponse response, String resposta) throws IOException {
	    	
	    	PrintWriter out = response.getWriter();
	    	response.setContentType("text/html");
	    	
	    	out.println("<html><head><title>");
	    	out.println("Exemplo - Resposta");
	    	out.println("</title></head><body>");
	    	out.println("<h1>Alerta</h1>");
	    	if((Integer) getServletContext().getAttribute("qtdSessoes") < 3) {
	    		out.println("<form method='post'>");
	    		out.println("<input type='submit'/>");
	    		out.println("</form>");
	    	}
	    	out.println(resposta);
	    	
	    	out.println("<p/><a href='./destroi'>Encerrar Sessao</a>");
	    	out.println("</body></html>");
	    	
	    	out.close();
	    }

}
