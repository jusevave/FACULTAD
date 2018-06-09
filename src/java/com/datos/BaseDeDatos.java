/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DidierPC
 */
public class BaseDeDatos {
    
    private static Connection connection=null;
    public static Connection getConecction() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("com.datos.Oracle");
        String ip=rb.getString("host");   
        String instancia=rb.getString("db");
        String usuario=rb.getString("user");
        String pass=rb.getString("pass");
        int puerto=Integer.parseInt(rb.getString("port"));   
        String url="jdbc:oracle:thin:@"+ip+":"+puerto+":"+instancia;
        try {
            if (BaseDeDatos.connection==null){
                Class.forName("oracle.jdbc.driver.OracleDriver");
                BaseDeDatos.connection=DriverManager.getConnection(url,usuario,pass);
                //BaseDatos.connection.setAutoCommit(false);
                return BaseDeDatos.connection;
            }else if(BaseDeDatos.connection.isClosed()){
                Class.forName("oracle.jdbc.driver.OracleDriver"); 
                BaseDeDatos.connection=DriverManager.getConnection(url,usuario,pass);
                //BaseDatos.connection.setAutoCommit(false);
                return BaseDeDatos.connection;
            }
        }
        catch (Exception ex){            
            System.out.println("ERROR EN EL DRIVER \n ERROR : "+ex.getMessage());
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            BaseDeDatos.connection.close();
        }
        return BaseDeDatos.connection;
    }
    
}
