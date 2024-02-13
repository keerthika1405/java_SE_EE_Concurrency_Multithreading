/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.dao;

import com.app.bean.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class userDao {
    
    public int saveuser(user user){
        int rows=0;
        
        try {
            Connection connection =databaseconnection.getconnection();    
            PreparedStatement statement = connection.prepareStatement("insert into a uset value(?,?,?)");
            
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            rows=statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
}
