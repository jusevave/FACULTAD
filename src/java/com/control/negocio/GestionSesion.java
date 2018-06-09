/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.negocio;

import com.model.dto.UsuariosDTO;
import com.control.dao.UsuariosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DidierPC
 */
@WebServlet(name = "GestionSesion", urlPatterns = {"/GestionSesion"})
public class GestionSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        HttpSession session = request.getSession();
        String opcion = request.getParameter("opcion");
        if(opcion.equals("iniciar")){
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            UsuariosDTO usuario = new UsuariosDTO();
            UsuariosDAO usuariodao = new UsuariosDAO();
            usuario.setId_usuario(user);
            usuario.setContrasena(pass);
            if(usuariodao.validarUsuario(usuario)){
                usuario = usuariodao.ObtenerUsuario(usuario);
                session.setAttribute("nombre", usuario.getNombre());
                session.setAttribute("id", usuario.getId_usuario());
                if(usuario.getId_tipo() == 1){
                    response.sendRedirect("secretaria.jsp");
                }
                if(usuario.getId_tipo() == 2){
                    response.sendRedirect("director.jsp");
                }
                if(usuario.getId_tipo() == 3){
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("GestionJurado").forward(request, response);
                    //response.sendRedirect("jurado.jsp");
                }
                
            }else{
                request.setAttribute("incorrecto", "Usuario o Contraseña incorrectos");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
        if(opcion.equals("cerrar")){
            session.setAttribute("nombre", null);
            session.invalidate();
            response.sendRedirect("Login.jsp");
        }
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
