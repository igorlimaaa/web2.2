/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Endereco;
import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Telefone;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class VisualizarConsultaServlet extends HttpServlet {

    
    private Endereco endereco = new Endereco("Rua 171, n 0", "x", "y", "PE", 55555123);
    private Telefone telefone = new Telefone(81, 99990000);
    //private Medico medico = new Medico("CRM-0192", "012.345.678-90", "Maria", "Silva", 'F', "mariasilva@x.com", "1234", endereco, telefone, new Date());
    //private Usuario usuario = new Usuario("111.111.111-11", "João", "Silva", 'M', "joaosilva@teste.com", "12345", endereco, telefone, new Date());
    private Clinica clinica = new Clinica("Clínica X", endereco, telefone);
    //private Consulta consulta = new Consulta(usuario, medico, new Date("12/05/2016"), clinica, "Cardiologista", null, false);
    
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
        
      //  request.setAttribute("consulta", consulta);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/visualizarConsulta.jsp");
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
        return "Servlet responsável pela funcionalidade Visualizar Consulta.";
    }// </editor-fold>

}
