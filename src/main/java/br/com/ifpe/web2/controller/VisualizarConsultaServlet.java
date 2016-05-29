/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Medico;
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
public class VisualizarConsultaServlet extends HttpServlet {

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
        listarConsultas(request);

        RequestDispatcher rd = request.getRequestDispatcher("/view/visualizarConsulta.jsp");
        rd.forward(request, response);

    }

    private void listarConsultas(HttpServletRequest request) {
        List<Consulta> lConsultasMarcadas = new ArrayList<Consulta>();

        for (int i = 0; i < 3; i++) {
            Consulta nova = new Consulta();
            Medico medico = new Medico();

            medico.setEspecialidade("Cardiologia");
            medico.setNome("João" + i);

            nova.setCodigo(i);
            nova.setData(new Date());
            nova.setMedico(medico);
            nova.setUsuario(medico);
            lConsultasMarcadas.add(nova);
        }

        request.setAttribute("lConsultasMarcadas", lConsultasMarcadas);
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
