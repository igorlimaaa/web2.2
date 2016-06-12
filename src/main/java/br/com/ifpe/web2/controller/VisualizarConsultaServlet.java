/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
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
public class VisualizarConsultaServlet extends HttpServlet {

    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private Consulta consultaSelecionada;
    private List<Consulta> lConsultasMarcadas;
    private Usuario usuarioLogado;

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

        if (request.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            //DELETE
            excluirConsulta(codigo, request, response);

            request.setAttribute("codigo", null);
            request.setAttribute("consultaflag", null);

        } else {

            listarConsultas(request);
            RequestDispatcher rd = request.getRequestDispatcher("/view/visualizarConsulta.jsp");
            rd.forward(request, response);
        }

    }

    private void listarConsultas(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        
        if(usuarioLogado != null){
        
            usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
            lConsultasMarcadas = consultaDAO.listarConsultasMarcadas(usuarioLogado.getCodigo());

            request.setAttribute("lConsultasMarcadas", lConsultasMarcadas);
        }
    }

    public void excluirConsulta(int codigo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        consultaSelecionada = consultaDAO.getConsulta(codigo);

        consultaDAO.excluir(consultaSelecionada);

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
