/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextech.security;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class BeanLogin implements Serializable{
    
    private String usuario;
    private String pass;
    private String apellido;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

 
    
    public String login() throws SQLException{
        if(loginAccion()){
            //crear sesion 
            return "correcto";
        }else{
            FacesContext.getCurrentInstance().addMessage("form1",new FacesMessage("Credenciales Incorrectas"));
            return "incorrecto";
        }  
    }
    
    private boolean loginAccion() throws SQLException{
        conexion cone = new  conexion();
        Statement Sentencias = null;
        ResultSet tabla = null;
        Sentencias = cone.getConnection().createStatement();
        tabla = Sentencias.executeQuery("select * from usuarios where login='"+usuario+"'and password='"+pass+"'");
        while(tabla.next()){
             apellido = tabla.getString("apellido");
             nombre = tabla.getString("nombre");
             return true;
        }
        return false;
    }
    
    public String cerrarSesion(){
      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
      session.removeAttribute("LoginBean");
      return "cerrar";
    }
}
