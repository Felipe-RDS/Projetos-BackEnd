

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TermosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Object sync = new Object();
	
    public TermosServlet() {
        super();
    }
    
    private int s(int n) {
    	if(n < 2)
    		return 0;
    	if(n < 3)
    		return 1;
    	if(n < 4)
    		return 1;
    	
    	return s(n-1) + 2*s(n-3);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exibe(request, response, "");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		int termoDaSerie = 0;
		
		ServletContext context = getServletContext();
		
		
		HttpSession session = request.getSession();
		int termo = (Integer)session.getAttribute("termo");
		session.setAttribute("termo", ++termo);
		
		
		int ordem = (Integer)session.getAttribute("ordemTermo");
		session.setAttribute("ordemTermo", ++ordem);
		
		
		termoDaSerie = s(termo);
		
		try {
			int termoDigitado = Integer.parseInt(request.getParameter("termoDigitado"));
			
			
			if(termoDigitado == termoDaSerie) {
				resposta = "Parabens voce acertou!";
				int acerto = (Integer)session.getAttribute("acertos");
				session.setAttribute("acertos", ++acerto);
				
				synchronized (sync) {
					int acertosTotais = (Integer) context.getAttribute("acertosTotais");
					context.setAttribute("acertosTotais", ++acertosTotais);
				}
			}
			else {
				resposta = "Voce errou !" + " \nO termo da serie é " + termoDaSerie;
				int erro = (Integer)session.getAttribute("erros");
				session.setAttribute("erros", ++erro);
				
				
				if(erro >= 3) {
					session.setAttribute("ordemTermo", 1);
					resposta = "Voce perdeu, Tente novamente !" + " \nO termo "+ ordem + " da serie é " + termoDaSerie;
				}
				
				synchronized (sync) {
					int errosTotais = (Integer)context.getAttribute("errosTotais");
					context.setAttribute("errosTotais", ++errosTotais);
				}
			}
		}
		catch(NumberFormatException e) {
			resposta = "Digite um valor numerico.";
		}
		
		exibe(request, response, resposta);
	}
	
	private void exibe(HttpServletRequest request, HttpServletResponse response, String resposta) throws IOException {
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	
    	out.println("<html><head><title>");
    	out.println("Termos Serie");
    	out.println("</title></head><body>");
    	out.println("<h1>Calcula termos serie - Resposta</h1>");
    	out.println("<form method='post'>");
    	int ordem = (Integer)session.getAttribute("ordemTermo");
    	out.println("Digite o termo " + ordem +":<input type='text' name='termoDigitado'/>");
    	out.println("<input type='submit'/>");
    	out.println("</form>");
    	out.println(resposta);
    	out.println("<p/>Quantidade de erros do usuario: " + session.getAttribute("erros"));
    	out.println("<p/>Quantidade de erros de todos os usuarios: " + getServletContext().getAttribute("errosTotais")); 
    	out.println("<p/>Quantidade de acertos do usuario: " + session.getAttribute("acertos"));
    	out.println("<p/>Quantidade de acertos de todos os usuarios: " + getServletContext().getAttribute("acertosTotais")); 
    	out.println("<p/><a href='./destroi'>Encerrar Sessao</a>");
    	out.println("</body></html>");
    	
    	out.close();
	}
}
