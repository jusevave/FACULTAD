/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.dao;

import com.datos.BaseDeDatos;
import com.model.dto.UsuariosDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DidierPC
 */
public class UsuariosDAO {
    
    public boolean validarUsuario(UsuariosDTO usuario){
        Statement pstatement=null;
        ResultSet resultSet=null;
        String sql="select * from usuarios where id_usuario='"+usuario.getId_usuario()+"' and contrasena='"+usuario.getContrasena()+"'";
        
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement = conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            return resultSet.next();
        }catch(SQLException ex){
            System.out.println("ERROR AL VALIDAR USUARIO"+ex);
            return false;
        }
    }
    
    public UsuariosDTO ObtenerUsuario(UsuariosDTO usuario){
        Statement pstatement=null;
        ResultSet resultSet=null;
        String sql="select * from usuarios where id_usuario='"+usuario.getId_usuario()+"'";
        UsuariosDTO user = new UsuariosDTO();
        try{
            Connection conne=BaseDeDatos.getConecction();
            pstatement = conne.createStatement();
            resultSet = pstatement.executeQuery(sql);
            resultSet.next();
            user.setIdentificacion(resultSet.getInt("identificacion"));
            user.setNombre(resultSet.getString("nombres"));
            user.setId_tipo(resultSet.getInt("id_tipo"));
            user.setId_usuario(resultSet.getString("id_usuario"));
            user.setContrasena(resultSet.getString("contrasena"));
            return user;
        }catch(SQLException ex){
            System.out.println("ERROR AL VALIDAR USUARIO"+ex);
            return user;
        }
    }
    
}
