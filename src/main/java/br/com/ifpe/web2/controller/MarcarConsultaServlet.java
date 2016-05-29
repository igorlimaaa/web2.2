package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ClinicaDAO;
import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Eduardo
 * @author Igorlima
 */

@ManagedBean
@SessionScoped
public class MarcarConsultaServlet extends HttpServlet {

    private Consulta consulta;
    private ConsultaDAO consultaDAO;
    private Clinica clinica;
    private ClinicaDAO clinicaDAO;
    
    public MarcarConsultaServlet() throws SQLException {
        consultaDAO = new ConsultaDAO();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    
    public void novoCli(ActionEvent actionEvent){
        clinica = new Clinica();
    }

    public void novo(ActionEvent actionEvent) {
        consulta = new Consulta();
    }
    
    
    
    public void gravar(ActionEvent actionEvent) {
        consultaDAO.inserir(consulta);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dialogCadastrarProduto.hide()");
    }
    
    public void gravarCli(ActionEvent actionEvent){
        clinicaDAO.pesquisarTodos();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dialogListar.hide()");
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        clinicaDAO = new ClinicaDAO();
        request.setAttribute("clinicas", clinicaDAO.obterClinicas());


        
        RequestDispatcher rd = request.getRequestDispatcher("/view/marcarConsulta.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getParameter("comboClinica");

        
        consulta = inserir(request);
        consultaDAO.inserir(consulta);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        rd.forward(request, response);
        
    }
    
    private Consulta inserir(HttpServletRequest request){
        consulta = new Consulta();
        
        //consulta.setUsuario();
        
        consulta.setAtendida(false);
        consulta.setData(new Date(request.getParameter("data")));
        
        return consulta;
        
    }
    
    private Clinica pesquisarTodos(HttpServletResponse response){
        clinica = new Clinica();
        
        return clinica;
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
