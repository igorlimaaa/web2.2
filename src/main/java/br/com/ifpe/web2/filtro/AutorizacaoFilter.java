package br.com.ifpe.web2.filtro;

import br.com.ifpe.web2.model.Medico;
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
import javax.servlet.http.HttpSession;


/**
 *
 * @author igor_
 */
@WebFilter("/*")
public class AutorizacaoFilter implements Filter{

//    @Inject
    private Usuario usuario;
    private Medico medico;
       
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        HttpSession session = request.getSession(true);
        String loginURL = request.getContextPath() + "/LoginServlet";
        String registrarURL = request.getContextPath() + "/RegistrarServlet";
        
        usuario = (Usuario) session.getAttribute("usuarioLogado");
        try{
            medico = (Medico) session.getAttribute("usuarioLogado");
        } catch(Exception e){
            System.out.println("Não é médico.");
        }
        
        if (request.getRequestURI().equals(loginURL) || (usuario != null && usuario.isLogado()) || (medico != null && medico.isLogado()) || request.getRequestURI().equals(registrarURL)) {
            chain.doFilter(req, res);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
            rd.forward(request, response);
        }       
    }

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void destroy() {
    }

  
    
}
