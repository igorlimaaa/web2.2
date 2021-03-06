/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class VisualizarHistoricoServlet extends HttpServlet {

    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private List<Consulta> historicoConsultas;

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

        if (request.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            historicoConsultas = consultaDAO.listarConsultasMarcadas("idUsuario", codigo, true);
            request.setAttribute("codigo", null);
            
            request.setAttribute("consultasRealizadas", historicoConsultas);
        
            rd = request.getRequestDispatcher("/view/visualizarHistorico.jsp");
        } else {
            rd = request.getRequestDispatcher("/view/errorpage.jsp");
        }
        rd.forward(request, response);

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
        return "Servlet responsável pela funcionalidade visualizar histórico de diagnóstico.";
    }// </editor-fold>

}
