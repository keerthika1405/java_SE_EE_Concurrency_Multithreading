/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class databaseconnection {
    public static Connection getconnection(){
          Connection connection=null;
              try {
                  class.forName("com.mysql.jdbc.Driver");
                  connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Keerthi1405@");
                   return connection;
              }
              catch (ClassNotFoundException ex) {
                  Logger.getLogger(databaseconnection.class.getName()).log(Level.SEVERE, null, ex);
              }
              catch (SQLException ex) {
                  Logger.getLogger(databaseconnection.class.getName()).log(Level.SEVERE, null, ex);
              }
                 return connection;
              
     
    }
   
        
}
