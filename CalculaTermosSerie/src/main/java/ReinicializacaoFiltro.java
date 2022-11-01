

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReinicializacaoFiltro extends HttpFilter implements Filter {
       
    public ReinicializacaoFiltro() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		int erros = (Integer) session.getAttribute("erros");
		if(erros >= 3) {
			session.setAttribute("termo", 0);
			session.setAttribute("erros", 0);
			session.setAttribute("acertos", 0);
			session.setAttribute("ordemTermo", 1);
		}
			
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
