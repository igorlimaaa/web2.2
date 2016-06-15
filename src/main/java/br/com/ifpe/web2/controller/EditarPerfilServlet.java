package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.UsuarioDAO;
import br.com.ifpe.web2.model.Endereco;
import br.com.ifpe.web2.model.Telefone;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        if (usuarioLogado != null) {
    
            request.setAttribute("usuarioEditar", usuarioLogado);

        }

        RequestDispatcher rd = request.getRequestDispatcher("/view/editarPerfil.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuarioDAO = new UsuarioDAO();
        RequestDispatcher rd;

        try {
            carregarUsuario(request);
            usuarioDAO.atualizar(usuario);
            rd = request.getRequestDispatcher("/view/homeUsuario.jsp");

        } catch (Exception e) {
            rd = request.getRequestDispatcher("/view/errorpage.jsp");
        }

        rd.forward(request, response);

    }

    private void carregarUsuario(HttpServletRequest request) {
        usuario = usuarioLogado;

        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setEmail(request.getParameter("email"));

        usuario.setEndereco(new Endereco());
        usuario.getEndereco().setLogradouro(request.getParameter("logradouro"));
        usuario.getEndereco().setBairro(request.getParameter("bairro"));
        usuario.getEndereco().setCidade(request.getParameter("cidade"));
        usuario.getEndereco().setEstado(request.getParameter("estado"));

        if (!request.getParameter("cep").isEmpty()) {
            usuario.getEndereco().setCep(Integer.parseInt(request.getParameter("cep")));
        }

        usuario.setTelefone(new Telefone());
        if (!request.getParameter("ddd").isEmpty()) {
            usuario.getTelefone().setDdd(Integer.parseInt(request.getParameter("ddd")));
        }
        if (!request.getParameter("telefone").isEmpty()) {
            usuario.getTelefone().setNumero(Integer.parseInt(request.getParameter("telefone")));
        }
        
        if(!request.getParameter("senha").isEmpty()){
            usuario.setSenha(request.getParameter("senha"));
        }

    }

    @Override
    public String getServletInfo() {
        return "Servlet responsável pela funcionalidade Editar Perfil.";
    }

}
