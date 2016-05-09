/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.controller;

import br.com.ifpe.web2.model.Endereco;
import br.com.ifpe.web2.model.Telefone;
import br.com.ifpe.web2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class EditarPerfilServlet extends HttpServlet {
    
    private Endereco endereco = new Endereco("Rua 171, n 0", "x", "y", "PE", 55555123);
    private Telefone telefone = new Telefone(81, 99990000);
    private Usuario currentUsuario = new Usuario("111.111.111-11", "João", "Silva", 'M', "joaosilva@teste.com", "12345", endereco, telefone, new Date());

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
        
        request.setAttribute("usuario", currentUsuario);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/editarPerfil.jsp");
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
        
        currentUsuario.setNome(request.getParameter("nome"));
        currentUsuario.setSobrenome(request.getParameter("sobrenome"));
        currentUsuario.setEmail(request.getParameter("email"));
        currentUsuario.getEndereco().setLogradouro(request.getParameter("logradouro"));
        currentUsuario.getEndereco().setCidade(request.getParameter("cidade"));
        currentUsuario.getEndereco().setBairro(request.getParameter("bairro"));
        currentUsuario.getEndereco().setEstado(request.getParameter("estado"));
        currentUsuario.getEndereco().setCep(Integer.parseInt(request.getParameter("cep")));
        currentUsuario.getTelefone().setDdd(Integer.parseInt(request.getParameter("ddd")));
        currentUsuario.getTelefone().setNumero(Integer.parseInt(request.getParameter("telefone")));
        currentUsuario.setSenha(request.getParameter("senha"));
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/homeUsuario.jsp");
        rd.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet responsável pela funcionalidade Editar Perfil.";
    }// </editor-fold>

}
