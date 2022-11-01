

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DestroiMontyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DestroiMontyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		PrintWriter out = response.getWriter();
		out.println("Sessao Destruida");
		out.println("</p><a href='./monty'>Voltar</a>");
		out.println("</body></html>");
		
	}

}
