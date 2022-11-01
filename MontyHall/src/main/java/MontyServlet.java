

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MontyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MontyServlet() {
        super();
    }
    
    private void inicializadorMonty(HttpServletRequest request) {
    	Random r = new Random();
    	int premio = r.nextInt(3) + 1;
    	
    	String[] portas = { "1", "2", "3"};
    	
    	HttpSession session = request.getSession();
    	
    	session.setAttribute("premio", premio);
    	session.setAttribute("portas", portas);
    	session.setAttribute("troca", false);
    	
    
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicializadorMonty(request);
		exibe(request, response, "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resposta = "";
		
		HttpSession session = request.getSession();
		boolean troca = (Boolean) session.getAttribute("troca");
		int premio = (Integer)session.getAttribute("premio");
		
		try {
			int escolha = Integer.parseInt(request.getParameter("escolha"));
			
			if(escolha < 1 || escolha > 3)
				resposta = "Escolha uma porta entre 1 a 3 !";
			else {
				if(!troca) {
					//etapa primeira escolha
					
					int diferente = 0;
					//definir porta != escolha e != premio
					for(int porta = 1; porta <= 3 ; porta++)
						if(porta != premio && porta != escolha) {
							diferente = porta;
							break;
						}
					session.setAttribute("diferente", diferente);
					String[] portas = (String[]) session.getAttribute("portas");
					portas[diferente-1] = "*";
					
					session.setAttribute("portas", portas);
					session.setAttribute("troca", true);
				}
				else {
					// Oportunidade de escolha final
					int diferente = (Integer)session.getAttribute("diferente");
					int pontos = (Integer)session.getAttribute("pontos");
					
					if(escolha == diferente) {
						resposta = "Porta " + escolha + " esta aberta.";
					}
					else {
						//escolha certa
						if(escolha == premio) {
							pontos += 10;
							resposta = "Voce venceu!";
						}
						//escolha errada
						else {
							pontos /= 2;
							resposta = "Voce perdeu!";
						}
						//atualizar pontos na sessao
						session.setAttribute("pontos", pontos);
						inicializadorMonty(request);
					}
				}
				
			}
		}
		catch(NumberFormatException e) {
			resposta = "Escreva um valor numerico inteiro de 1 a 3 para escolha da porta.";
		}
		
		exibe(request, response, resposta);
	}
	
	private void exibe(HttpServletRequest request, HttpServletResponse response, String resposta) throws IOException {
    	HttpSession session = request.getSession();

    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");

    	out.println("<html><head><title>");
    	out.println("Monty Hall");
    	out.println("</title></head><body>");
    	out.println("<h1>Jogo de Monty Hall</h1>");
    	out.println("Portas: ");
    	String[] portas = (String[])session.getAttribute("portas");
    	for(String porta: portas)
    		out.println(porta + " ");

    	out.println("<form method='post'>");
    	out.println("Escolha: <input type='text' name='escolha'/><br>");
    	out.println("<input type='submit'/>");
    	out.println("</form>");

    	out.println("</p>"+ resposta);
    	
    	out.println("</p>Pontuacao: " + session.getAttribute("pontos"));
    	
    	
        out.println("<br><a href='./monty'>Reiniciar</a>");
        out.println("<br><a href='./destroi'>Encerrar Sessao</a>");

       

    }
	
}
