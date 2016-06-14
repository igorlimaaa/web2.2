package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.UsuarioDAO;
import br.com.ifpe.web2.model.Endereco;
import br.com.ifpe.web2.model.Telefone;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Eduardo
 * @author IgorLima
 */
@ManagedBean
@SessionScoped
public class RegistrarServlet extends HttpServlet implements Serializable {

    private Usuario usuario = new Usuario();

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public String fazerLogin(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuarioDAO.fazerLogin(usuario) != null){
            usuario.setLogado(true);
            return "/view/login.jsp?faces-redirect=true";
        } else {
            usuario.setLogado(false);
            FacesMessage mensagem = new FacesMessage ("Usuário/Senha" + "Inválidos!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
        return null;
    }

    public RegistrarServlet() throws SQLException {
        usuarioDAO = new UsuarioDAO();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void novo(ActionEvent actionEvent) {
        usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        usuarioDAO.cadastrarUsuario(usuario);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dialogCadastrarProduto.hide()");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/registrar.jsp");
        rd.forward(request, response);

    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario = carregarUsuario(request);
        usuarioDAO.cadastrarUsuario(usuario);
        RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
        rd.forward(request, response);
    }
    
    private Usuario carregarUsuario(HttpServletRequest request) {
        usuario = new Usuario();
        
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setSexo(request.getParameter("sexo").charAt(0));
        usuario.setDataNasc(new Date(request.getParameter("dataNasc")));
        usuario.setDataCadastro(new Date());
        
        Telefone tel = new Telefone();
        usuario.setTelefone(tel);
        usuario.getTelefone().setDdd(Integer.parseInt(request.getParameter("ddd")));
        usuario.getTelefone().setNumero(Integer.parseInt(request.getParameter("telefone")));
        
        Endereco endereco = new Endereco();
        usuario.setEndereco(endereco);
        usuario.getEndereco().setBairro(request.getParameter("bairro"));
        usuario.getEndereco().setCidade(request.getParameter("cidade"));
        usuario.getEndereco().setEstado(request.getParameter("estado"));
        usuario.getEndereco().setCep(Integer.parseInt(request.getParameter("cep")));
        usuario.getEndereco().setLogradouro(request.getParameter("logradouro"));
        
        return usuario;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
