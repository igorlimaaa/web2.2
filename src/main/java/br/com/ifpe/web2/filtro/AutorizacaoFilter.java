package br.com.ifpe.web2.filtro;

import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
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
@WebFilter("/*")
public class AutorizacaoFilter implements Filter{

    //@Inject
    private Usuario usuario;
       
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;
//        
//        if (!usuario.isLogado()) {
//            RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
//            rd.forward(request, response);
 //       }else {
            chain.doFilter(req, res);
        }       
    //}

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void destroy() {
    }

  
    
}
