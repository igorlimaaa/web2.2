/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
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

    private ConsultaDAO consultaDAO;
    private Consulta consultaSelecionada;
    private List<Consulta> lConsultasMarcadas = new ArrayList<Consulta>();

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

        String flag = request.getParameter("consultaflag");

        if ((flag != null && !flag.isEmpty()) && request.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            if (flag.equals("D")) {
                //DELETE
                excluirConsulta(codigo, request, response);
            } else if (flag.equals("U")) {
                //UPDATE
                editarConsulta(codigo, request, response);
            }

            request.setAttribute("codigo", null);
            request.setAttribute("consultaflag", null);

        } else {

            listarConsultas(request);
            RequestDispatcher rd = request.getRequestDispatcher("/view/visualizarConsulta.jsp");
            rd.forward(request, response);
        }

    }

    private void listarConsultas(HttpServletRequest request) {

        lConsultasMarcadas = new ArrayList<Consulta>();

        for (int i = 0; i < 3; i++) {
            Consulta nova = new Consulta();
            Medico medico = new Medico();

            medico.setNome("João" + i);

            nova.setCodigo(i);
            nova.setDataConsulta(new Date());
            nova.setMedico(medico.getNome());
            nova.setUsuario(medico.getNome());
            lConsultasMarcadas.add(nova);
        }

        request.setAttribute("lConsultasMarcadas", lConsultasMarcadas);
    }

    public void editarConsulta(int codigo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Consulta consulta = lConsultasMarcadas.get(codigo);

        request.setAttribute("consultaEditar", consulta);

        RequestDispatcher rd = request.getRequestDispatcher("/view/editarConsulta.jsp");
        rd.forward(request, response);

    }

    public void excluirConsulta(int codigo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        lConsultasMarcadas.remove(codigo);
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
