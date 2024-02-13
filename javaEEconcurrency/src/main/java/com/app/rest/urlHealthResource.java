/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.rest;

import com.app.runnable.urlHealthProcessor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ELCOT
 */
@Path("urlCheck")
public class urlHealthResource {
    
    @Resource(lookup="java:comp/DefaultManagedScheduledExecutorService")
 
    private ManagedScheduledExecutorService service;
    
    @GET
    public String chechHealthOfApplication(){
    String message="";
    service.schedule(new urlHealthProcessor(),3,TimeUnit.SECONDS);

    
    message="health check iniciated";
    return message;
    }
    
}
