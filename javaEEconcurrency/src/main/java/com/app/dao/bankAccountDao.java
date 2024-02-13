/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.dao;

import com.app.bean.bankAccount;
import com.app.bean.bankAccountTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author ELCOT
 */
public class bankAccountDao {
    
    private DataSource datasource;

    public bankAccountDao(DataSource datasource){
    this.datasource  = datasource;
        
    }
    
    
    public List<bankAccount> getallbankaccounts() {
        
           List<bankAccount> accounts=new ArrayList<>();
        try {
            Connection connection= datasource.getConnection();
         
            bankAccount account=null;
            
            Statement statement=connection.createStatement();
            ResultSet set =statement.executeQuery("select * from the bank account");
            
            while(set.next()){
                account=new bankAccount();
                account.setAccNumber(set.getInt("acc Number"));
                account.setName(set.getString("acc holder Name"));
                account.setEmail(set.getString("acc email"));
                account.setAccType(set.getString("acc type"));
                accounts.add(account);
                        }
           
        } catch (SQLException ex) {
            Logger.getLogger(bankAccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return accounts;
    
    }
    
     public List<bankAccountTransaction> getallbankaccountTransaction(bankAccount account) {
             
         
         List<bankAccountTransaction> transactions=new ArrayList<>();
        try {
            Connection connection =datasource.getConnection();
            bankAccountTransaction transaction=null;
            
            PreparedStatement statement =connection.prepareStatement("select * from bank account where acc number=?");
            statement.setInt(1,account.getAccNumber());
            ResultSet set= statement.executeQuery();
            
            while(set.next()){
                transaction= new bankAccountTransaction();
                transaction.setAccNumber(set.getInt("acc_Number"));
                transaction.setAmount(set.getDouble("amount"));
                transaction.setTransDate(new Date(set.getDate("transaction_date").getTime()));
                transaction.setTransId(set.getInt("trans_id"));
                transaction.setTransType(set.getString("trans_type"));
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(bankAccountDao.class.getName()).log(Level.SEVERE, null, ex);
        
        } 
        return transactions;
    }
            
   
}
