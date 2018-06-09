/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.negocio;

import com.control.dao.EvaluacionPropuestaDAO;
import com.control.dao.TrabajoDeGradoDAO;
import com.control.dao.UsuariosDAO;
import com.model.dto.EvaluacionPropuestaDTO;
import com.model.dto.TrabajoDeGradoDTO;
import com.model.dto.UsuariosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "GestionJurado", urlPatterns = {"/GestionJurado"})
public class GestionJurado extends HttpServlet {

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
        if(session.getAttribute("id") == null){
                response.sendRedirect("Login.jsp");
        }
        String opcion = request.getParameter("opcion");
        UsuariosDTO usuario = (UsuariosDTO) request.getAttribute("usuario");
        EvaluacionPropuestaDAO evaluacionpropuestadao = new EvaluacionPropuestaDAO();
        TrabajoDeGradoDAO trabajodao = new TrabajoDeGradoDAO();
        UsuariosDAO usuariosdao = new UsuariosDAO();
        if(usuario != null){
            ArrayList<TrabajoDeGradoDTO> evaluaciones = trabajodao.EvaluacionesPPendientes(usuario);
            request.setAttribute("evaluacionesP", evaluaciones);
            request.getRequestDispatcher("jurado.jsp").forward(request, response);
        }
        if(opcion.equals("registrar")){
            String[] caracteristicas = request.getParameterValues("caracteristicas");
            String observaciones = request.getParameter("observaciones");
            int nproyecto = Integer.parseInt(request.getParameter("nproyecto"));
            int resultado = Integer.parseInt(request.getParameter("resultado"));
            //String[] caracteristicasb = {"titulo","descripcion","hipotesis","objetivog","objetivoe","justificacion","marcor","metodologia","resultadose","cronograma","recursos","literatura","redaccion","pertinencia"};
            EvaluacionPropuestaDTO evaluacion = new EvaluacionPropuestaDTO();
            TrabajoDeGradoDTO trabajo = new TrabajoDeGradoDTO();
            trabajo.setN_proyecto(nproyecto);
            evaluacion.setN_proyecto(nproyecto);
            for (int i = 0; i < caracteristicas.length; i++) {
                if(caracteristicas[i].equals("titulo")){
                    evaluacion.setTitulo(1);
                }
                if(caracteristicas[i].equals("descripcion")){
                    evaluacion.setDescripcion(1);
                }
                if(caracteristicas[i].equals("hipotesis")){
                    evaluacion.setHipotesis(1);
                }
                if(caracteristicas[i].equals("objetivog")){
                    evaluacion.setObjetivos_generales(1);
                }
                if(caracteristicas[i].equals("objetivoe")){
                    evaluacion.setObjetivos_especificos(1);
                }
                if(caracteristicas[i].equals("justificacion")){
                    evaluacion.setJustificacion(1);
                }
                if(caracteristicas[i].equals("marcor")){
                    evaluacion.setMarco_referencia(1);
                }
                if(caracteristicas[i].equals("metodologia")){
                    evaluacion.setMetodologia(1);
                }
                if(caracteristicas[i].equals("resultadose")){
                    evaluacion.setResultados_esperados(1);
                }
                if(caracteristicas[i].equals("cronograma")){
                    evaluacion.setCronograma(1);
                }
                if(caracteristicas[i].equals("recursos")){
                    evaluacion.setRecursos(1);
                }
                if(caracteristicas[i].equals("literatura")){
                    evaluacion.setLiteratura(1);
                }
                if(caracteristicas[i].equals("redaccion")){
                    evaluacion.setRedaccion_ortografia(1);
                }
                if(caracteristicas[i].equals("pertinencia")){
                    evaluacion.setPertinencia_formacion(1);
                }
            }
            evaluacion.setObservaciones(observaciones);
            evaluacion.setResultado(resultado);
            trabajo.setResultado_propuesta(resultado);
            usuario = new UsuariosDTO();
            usuario.setId_usuario(session.getAttribute("id").toString());
            usuario = usuariosdao.ObtenerUsuario(usuario);
            if(evaluacionpropuestadao.actualizarEvaluacionP(evaluacion) && trabajodao.actualizarEvaluacionP(trabajo)){
                ArrayList<TrabajoDeGradoDTO> evaluaciones = trabajodao.EvaluacionesPPendientes(usuario);
                request.setAttribute("evaluacionesP", evaluaciones);
                request.setAttribute("correcto", "Evaluación Registrada");
            }else{
                request.setAttribute("inorrecto", "Evaluación no Registrada");
            }
            request.getRequestDispatcher("jurado.jsp").forward(request, response);
        }
        if(opcion.equals("evaluar")){
            int nproyecto = Integer.parseInt(request.getParameter("evalucionesPendientes"));
            EvaluacionPropuestaDTO evaluacion = evaluacionpropuestadao.traerCaracteristicas(nproyecto);
            ArrayList<String> info = trabajodao.obtenerInfoProyecto(nproyecto);
            request.setAttribute("info", info);
            request.setAttribute("evaluacion", evaluacion);
            request.getRequestDispatcher("jurado.jsp").forward(request, response);
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
