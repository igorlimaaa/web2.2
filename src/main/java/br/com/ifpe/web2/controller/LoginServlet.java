/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.DAO.ConsultaDAO;
import br.com.ifpe.web2.DAO.MedicoDAO;
import br.com.ifpe.web2.DAO.UsuarioDAO;
import br.com.ifpe.web2.model.Consulta;
import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.rmi.server.ExportException;
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
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;

        HttpSession session = request.getSession(false);

        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado != null) {
            rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        } else {
            rd = request.getRequestDispatcher("/view/login.jsp");
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

        System.out.println("br.com.ifpe.web2.controller.LoginServlet.doPost()");

        RequestDispatcher rd;

        try {

            HttpSession session = request.getSession();

            String login = request.getParameter("login");

            if (login.contains("@")) {

                Usuario usuario = new Usuario();

                usuario.setEmail(login);
                usuario.setSenha(request.getParameter("senha"));

                usuario = usuarioDAO.fazerLogin(usuario);

                if (usuario != null) {
                    usuario.setLogado(true);
                    session.setAttribute("usuarioLogado", usuario);
                    rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
                } else {
                    throw new Exception("Falha ao logar");
                }

            } else {

                Medico medico = new Medico();

                medico.setCrm(login);
                medico.setSenha(request.getParameter("senha"));

                medico = usuarioDAO.fazerLoginMedico(medico);

                if (medico != null) {
                    medico.setLogado(true);
                    session.setAttribute("usuarioLogado", medico);
                    rd = request.getRequestDispatcher("/view/homeMedico.jsp");
                } else {
                    throw new ExportException("Falha ao logar");
                }

            }

        } catch (Exception e) {
            rd = request.getRequestDispatcher("/view/errorpage.jsp");
        }

        rd.forward(request, response);
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
