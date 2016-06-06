/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.model.Consulta;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class EditarConsultaServlet extends HttpServlet {

    private Consulta consultaSelecionada;
    private ConsultaDAO consultaDAO = new ConsultaDAO();

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

            consultaSelecionada = consultaDAO.getConsulta(codigo);
            request.setAttribute("consultaEditar", consultaSelecionada);
            rd = request.getRequestDispatcher("view/editarConsulta.jsp");

        } else {
            rd = request.getRequestDispatcher("/view/erropage.jsp");
        }

        rd.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method. ;
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;

        try {

            if (consultaSelecionada.getCodigo() > 0) {
                editarConsulta(request);
                rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            rd = request.getRequestDispatcher("/view/errorpage.jsp");
            rd.forward(request, response);
        }
        
        

    }

    public void editarConsulta(HttpServletRequest request) throws ParseException {

        SimpleDateFormat novaData = new SimpleDateFormat("yyyy-mm-dd");

        consultaSelecionada = consultaDAO.getConsulta(consultaSelecionada.getCodigo());
        consultaSelecionada.setDataConsulta(novaData.parse(request.getParameter("dataremarcada")));

        consultaDAO.atualizar(consultaSelecionada);

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
