/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.rest;

import com.app.bean.bankAccount;
import com.app.dao.bankAccountDao;
import com.app.runnable.reportProcessor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.ws.rs.Path;

/**
 *
 * @author ELCOT
 */
@Path("report")
public class reportResources {
    
private bankAccountDao dao;
    
//RestFul bean
    @Resource(lookup="java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService service;
    
    //connection pooling
    public reportResources(){
        
     try{
    ComboPooledDataSource datasource= new ComboPooledDataSource();
    datasource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
    datasource.setDriverClass("com.mysql.jdbc.Driver");
    datasource.setUser("root");
    datasource.setPassword("Keerthi1405@");
    
    dao=new bankAccountDao(datasource);
    }
    catch(PropertyVetoException ex){
        Logger.getLogger(reportResources.class.getName()).log(Level.SEVERE,null,ex);
    }
    }

    
    
    //REST method
    
    @GET
    public String generateReport(){
        
     System.out.println("service object from JNDI lookup : "+service);
        
    List<bankAccount> accounts=dao.getallbankaccounts();
    
    for(bankAccount account:accounts){
    Future<Boolean> future=service.submit(new reportProcessor(account,dao));
        try {
            System.out.println("report generated"+future.get());
        } catch (InterruptedException ex) {
            Logger.getLogger(reportResources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(reportResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    //no need to use shutdown API because managedExecutorService , executorService are all of these object are managed 
    //by the container on its own
      
    }
        return "report generated task submitted";
}  
}


//    public reportResources(){
        //JNDI    
//        try {
//            InitialContext context = new InitialContext();
//            ManagedExecutorService executorService =(ManagedExecutorService)context.lookup("");
//        } catch (NamingException ex) {
//            Logger.getLogger(reportResources.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
