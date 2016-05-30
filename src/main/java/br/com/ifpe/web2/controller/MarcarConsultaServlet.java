package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ClinicaDAO;
import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.DAO.MedicoDAO;
import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Medico;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public class MarcarConsultaServlet extends HttpServlet {

    private Consulta consulta;
    private ConsultaDAO consultaDAO;
    private Clinica clinica;
    private ClinicaDAO clinicaDAO;
    private MedicoDAO medicoDAO;
    private List<String> especialidades;
    private List<Medico> medicos;
    
    public MarcarConsultaServlet() throws SQLException {
        listarEspecialidades();
        listarMedicos();
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
    
    private void listarEspecialidades(){
        especialidades = new ArrayList<String>();
        
        especialidades.add("Cardiologista");
        especialidades.add("Clínica Geral");
        especialidades.add("Pediatria");
        
    }
    
    private void listarMedicos(){
        medicos = new ArrayList<Medico>();
        medicoDAO = new MedicoDAO();
        medicos = medicoDAO.listarMedicos();
    }
    
    private void listarClinicas(HttpServletRequest request){
        clinicaDAO = new ClinicaDAO();
        request.setAttribute("clinicas", clinicaDAO.obterClinicas());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("especialidades", especialidades);
        request.setAttribute("medicos", medicos);
        listarClinicas(request);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/marcarConsulta.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        preencherConsulta(request);
        consultaDAO.inserir(consulta);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        rd.forward(request, response);
        
    }
    
    private void preencherConsulta(HttpServletRequest request){
        consulta = new Consulta();
        
        //consulta.setUsuario();
        consulta.setAtendida(false);
        consulta.setClinica(request.getParameter("clinica"));
        consulta.setEspecialidade(request.getParameter("especialidade"));
        consulta.setMedico(request.getParameter("medico"));
        consulta.setData(new Date(request.getParameter("data")));
        
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet responsável por prover ao usuário a opção de marcar uma consulta";
    }// </editor-fold>

}
