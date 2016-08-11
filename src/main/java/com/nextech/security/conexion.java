/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nextech.security;
import java.sql.*;
/**
 *
 * @author Erick
 */
public class conexion {
   static String bd = "nextech";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost:3306/nextech";

   Connection conn = null;

   public conexion(){
       try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
    
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
}

