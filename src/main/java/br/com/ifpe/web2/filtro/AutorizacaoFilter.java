package br.com.ifpe.web2.filtro;

import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author igor_
 */
@WebFilter("*.jsp")
public class AutorizacaoFilter implements Filter{

    @Inject
    private Usuario usuario;
       
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        if (!usuario.isLogado() && !request.getRequestURI().endsWith("/view/login.jsp")
                && !request.getRequestURI().contains("/javax.faces.resource/")){
            response.sendRedirect(request.getContextPath() + "/view/login.jsp");
        } else {
            chain.doFilter(req, res);
        }       
    }

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void destroy() {
    }

  
    
}
