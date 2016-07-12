/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Endereco;
import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Telefone;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eduardo
 */
public class HomeMedicoServlet extends HttpServlet {

    private List<Consulta> consultasMarcadas;
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private Medico usuarioLogado;
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;

        if (request.getParameter("logout") != null) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            rd = request.getRequestDispatcher("/view/login.jsp");
        } else {
            
            listarConsultas(request);
            
            rd = request.getRequestDispatcher("/view/homeMedico.jsp");
        }

        rd.forward(request, response);
    }

    private void listarConsultas(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        
        usuarioLogado = (Medico) session.getAttribute("usuarioLogado");
        
        if(usuarioLogado != null){
        
            consultasMarcadas = consultaDAO.listarConsultasMarcadasMedico(usuarioLogado.getCodigo());

            request.setAttribute("consultasMarcadas", consultasMarcadas);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
