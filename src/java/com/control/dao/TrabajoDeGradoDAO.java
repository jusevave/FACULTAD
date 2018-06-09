/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.dao;

import com.datos.BaseDeDatos;
import com.model.dto.EvaluacionPropuestaDTO;
import com.model.dto.TrabajoDeGradoDTO;
import com.model.dto.UsuariosDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DidierPC
 */
public class TrabajoDeGradoDAO {
    
    public ArrayList<String> obtenerInfoProyecto(int nproyecto){
        Statement pstatement;
        ResultSet resultSet;
        String sql="select t.director,t.nombre_estudiante,p.nombre_programa from trabajo_de_grado t inner join programa p on t.id_programa=p.id_programa where n_proyecto="+nproyecto;
        ArrayList<String> info = new ArrayList<String>();
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            resultSet.next();
            info.add(resultSet.getString("director"));
            info.add(resultSet.getString("nombre_estudiante"));
            info.add(resultSet.getString("nombre_programa"));
        }catch(SQLException ex){
            Logger.getLogger(TrabajoDeGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
    
    public boolean actualizarEvaluacionP(TrabajoDeGradoDTO trabajo){
        Statement pstatement;
        ResultSet resultSet;
        String sql="update trabajo_de_grado set id_resultado_propuesta="+trabajo.getResultado_propuesta()+" where n_proyecto="+trabajo.getN_proyecto();
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            return true;
        }catch(SQLException ex){
            Logger.getLogger(TrabajoDeGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ArrayList<TrabajoDeGradoDTO> EvaluacionesPPendientes(UsuariosDTO usuario){
        ArrayList<TrabajoDeGradoDTO> trabajosP = new ArrayList<TrabajoDeGradoDTO>();
        Statement pstatement;
        ResultSet resultSet;
        String sql="select t.n_proyecto,t.nombre_proyecto from EVALUACION_PROPUESTA e inner join TRABAJO_DE_GRADO t on t.N_PROYECTO=e.N_PROYECTO where ID_PROFESOR="+usuario.getIdentificacion()+" and t.id_resultado_propuesta=1";
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            while(resultSet.next()){
                TrabajoDeGradoDTO trabajoP = new TrabajoDeGradoDTO();
                trabajoP.setN_proyecto(resultSet.getInt("n_proyecto"));
                trabajoP.setNombre_proyecto(resultSet.getString("nombre_proyecto"));
                
                trabajosP.add(trabajoP);
                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(EvaluacionPropuestaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trabajosP;
    }
    
}
