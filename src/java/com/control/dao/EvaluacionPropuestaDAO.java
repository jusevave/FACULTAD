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
import java.sql.PreparedStatement;
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
public class EvaluacionPropuestaDAO {
    
    public EvaluacionPropuestaDTO traerCaracteristicas(int nproyecto){
        EvaluacionPropuestaDTO evaluacion = new EvaluacionPropuestaDTO();
        Statement pstatement;
        ResultSet resultSet;
        String sql="select * from EVALUACION_PROPUESTA where n_proyecto="+nproyecto;
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            resultSet.next();
            evaluacion.setN_proyecto(resultSet.getInt("n_proyecto"));
            evaluacion.setTitulo(resultSet.getInt("titulo"));
            evaluacion.setDescripcion(resultSet.getInt("descripcion"));
            evaluacion.setHipotesis(resultSet.getInt("hipotesis"));
            evaluacion.setObjetivos_generales(resultSet.getInt("objetivos_generales"));
            evaluacion.setObjetivos_especificos(resultSet.getInt("objetivos_especificos"));
            evaluacion.setJustificacion(resultSet.getInt("justificacion"));
            evaluacion.setMarco_referencia(resultSet.getInt("marco_referencia"));
            evaluacion.setMetodologia(resultSet.getInt("metodologia"));
            evaluacion.setResultados_esperados(resultSet.getInt("resultados_esperados"));
            evaluacion.setCronograma(resultSet.getInt("cronograma"));
            evaluacion.setRecursos(resultSet.getInt("recursos"));
            evaluacion.setLiteratura(resultSet.getInt("literatura"));
            evaluacion.setRedaccion_ortografia(resultSet.getInt("redaccion_ortografia"));
            evaluacion.setPertinencia_formacion(resultSet.getInt("pertinencia_formacion"));
            evaluacion.setObservaciones(resultSet.getString("observaciones"));
            evaluacion.setResultado(resultSet.getInt("resultado"));
            evaluacion.setId_profesor(resultSet.getInt("id_profesor"));
        }catch(SQLException ex){
            Logger.getLogger(EvaluacionPropuestaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evaluacion;
        
    }
    public boolean actualizarEvaluacionP(EvaluacionPropuestaDTO evaluacion){
        Statement pstatement;
        ResultSet resultSet;
        String sql="update EVALUACION_PROPUESTA set titulo="+evaluacion.getTitulo()+", descripcion="+evaluacion.getDescripcion()+", hipotesis="+evaluacion.getHipotesis()+", objetivos_generales="+evaluacion.getObjetivos_generales()+", objetivos_especificos="+evaluacion.getObjetivos_especificos()+", justificacion="+evaluacion.getJustificacion()+", marco_referencia="+evaluacion.getMarco_referencia()+", metodologia="+evaluacion.getMetodologia()+", resultados_esperados="+evaluacion.getResultados_esperados()+", cronograma="+evaluacion.getCronograma()+", recursos="+evaluacion.getRecursos()+", literatura="+evaluacion.getLiteratura()+", redaccion_ortografia="+evaluacion.getRedaccion_ortografia()+", pertinencia_formacion="+evaluacion.getPertinencia_formacion()+", observaciones='"+evaluacion.getObservaciones()+"', resultado="+evaluacion.getResultado()+" where n_proyecto="+evaluacion.getN_proyecto();
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(EvaluacionPropuestaDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    /*
    public ArrayList<EvaluacionPropuestaDTO> EvaluacionesPendientes2(UsuariosDTO usuario){
        ArrayList<EvaluacionPropuestaDTO> evaluaciones = new ArrayList<EvaluacionPropuestaDTO>();
        PreparedStatement pstatement;
        ResultSet resultSet;
        String sql="select * from EVALUACION_PROPUESTA where ID_PROFESOR='"+usuario.getId_usuario()+"' and resultado=1;";
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement= conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()){
                EvaluacionPropuestaDTO evaluacion = new EvaluacionPropuestaDTO();
                evaluacion.setN_proyecto(resultSet.getInt("n_proyecto"));
                evaluacion.setTitulo(resultSet.getInt("titulo"));
                evaluacion.setDescripcion(resultSet.getInt("descripcion"));
                evaluacion.setHipotesis(resultSet.getInt("hipotesis"));
                evaluacion.setObjetivos_generales(resultSet.getInt("objetivos_generales"));
                evaluacion.setObjetivos_especificos(resultSet.getInt("objetivos_especificos"));
                evaluacion.setJustificacion(resultSet.getInt("justificacion"));
                evaluacion.setMarco_referencia(resultSet.getInt("marco_referencia"));
                evaluacion.setMetodologia(resultSet.getInt("metodologia"));
                evaluacion.setResultados_esperados(resultSet.getInt("resultados_esperados"));
                evaluacion.setCronograma(resultSet.getInt("cronograma"));
                evaluacion.setRecursos(resultSet.getInt("recursos"));
                evaluacion.setLiteratura(resultSet.getInt("literatura"));
                evaluacion.setRedaccion_ortografia(resultSet.getInt("redaccion_ortografia"));
                evaluacion.setPertinencia_formacion(resultSet.getInt("pertinencia_formacion"));
                evaluacion.setObservaciones(resultSet.getString("observaciones"));
                evaluacion.setResultado(resultSet.getInt("resultado"));
                
                evaluaciones.add(evaluacion);
                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(EvaluacionPropuestaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evaluaciones;
    }
    */
}
