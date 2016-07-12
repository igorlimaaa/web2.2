package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ClinicaDAO;
import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.DAO.MedicoDAO;
import br.com.ifpe.web2.DAO.UsuarioDAO;
import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
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
 * @author Igorlima
 */

public class MarcarConsultaServlet extends HttpServlet {

    private Consulta consulta;
    private ConsultaDAO consultaDAO;
    private Clinica clinica;
    private ClinicaDAO clinicaDAO;
    private MedicoDAO medicoDAO;
    private List<String> especialidades;
    private Usuario usuarioLogado;
    
    public MarcarConsultaServlet() {
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
    
    private void listarMedicos(HttpServletRequest request){
        medicoDAO = new MedicoDAO();
        request.setAttribute("medicos", medicoDAO.listarMedicos());
    }
    
    private void listarClinicas(HttpServletRequest request){
        clinicaDAO = new ClinicaDAO();
        request.setAttribute("clinicas", clinicaDAO.obterClinicas());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        listarEspecialidades();
        request.setAttribute("especialidades", especialidades);
        listarMedicos(request);
        listarClinicas(request);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/marcarConsulta.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        consultaDAO = new ConsultaDAO();
        
        try {
            preencherConsulta(request);
            consultaDAO.inserir(consulta);
            rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        } catch (Exception ex) {
            rd = request.getRequestDispatcher("/view/erropage.jsp");
            Logger.getLogger(MarcarConsultaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rd.forward(request, response);
        
    }
    
    private void preencherConsulta(HttpServletRequest request) throws ParseException{
        HttpSession session = request.getSession(false);
        
        usuarioLogado = session != null ? (Usuario) session.getAttribute("usuarioLogado") : null;
        
        consulta = new Consulta();
        consulta.setCodigo(1);
        consulta.setIdUsuario(usuarioLogado.getCodigo());
        consulta.setUsuario(usuarioLogado.getNome() + " " + usuarioLogado.getSobrenome());
        consulta.setAtendida(false);
        consulta.setClinica(request.getParameter("clinica"));
        consulta.setEspecialidade(request.getParameter("especialidade"));
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        Medico medico = userDAO.getMedico(Integer.parseInt(request.getParameter("medico")));
        
        consulta.setMedico(medico.getNome());
        consulta.setIdMedico(Integer.parseInt(request.getParameter("medico")));
        consulta.setDataConsulta(request.getParameter("data"));
                
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet responsável por prover ao usuário a opção de marcar uma consulta";
    }// </editor-fold>

    
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
    
}
