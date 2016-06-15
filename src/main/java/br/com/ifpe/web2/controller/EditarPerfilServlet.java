package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.UsuarioDAO;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Eduardo
 * @author Igor
 */
public class EditarPerfilServlet extends HttpServlet {

    private Usuario usuarioLogado;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (usuarioLogado != null) {

            usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
            request.setAttribute("usuario", usuarioLogado);

        }

//        usuarioDAO = new UsuarioDAO();
//        request.setAttribute("usuario", usuarioDAO.pesquisarUsu());
        RequestDispatcher rd = request.getRequestDispatcher("/view/editarPerfil.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*currentUsuario.setNome(request.getParameter("nome"));
        currentUsuario.setSobrenome(request.getParameter("sobrenome"));
        currentUsuario.setEmail(request.getParameter("email"));
        currentUsuario.getEndereco().setLogradouro(request.getParameter("logradouro"));
        currentUsuario.getEndereco().setCidade(request.getParameter("cidade"));
        currentUsuario.getEndereco().setBairro(request.getParameter("bairro"));
        currentUsuario.getEndereco().setEstado(request.getParameter("estado"));
        currentUsuario.getEndereco().setCep(Integer.parseInt(request.getParameter("cep")));
        currentUsuario.getTelefone().setDdd(Integer.parseInt(request.getParameter("ddd")));
        currentUsuario.getTelefone().setNumero(Integer.parseInt(request.getParameter("telefone")));
        currentUsuario.setSenha(request.getParameter("senha"));
         */
        RequestDispatcher rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Servlet responsável pela funcionalidade Editar Perfil.";
    }

}
