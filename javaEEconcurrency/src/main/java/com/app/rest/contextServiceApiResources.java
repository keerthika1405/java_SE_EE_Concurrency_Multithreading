/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.rest;

import com.app.runnable.contextServiceRunnable;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ELCOT
 */
@Path("contextservice")
public class contextServiceApiResources {
    @Resource(lookup="java:comp/DefaultContextService")
    
    
    private ContextService contextservice;
    
    @GET
    public String accesssecurityinfo(){
        
        contextServiceRunnable runnable=new contextServiceRunnable();
        
        //instead
        // Thread thread= new Thread(runnable);
        //        thread.start();
        
        Runnable proxy =contextservice.createContextualProxy(runnable,Runnable.class);
        Thread thread= new Thread(proxy);
        thread.start();
     
    
   return "conrtext capturing information";
    }
   
}

