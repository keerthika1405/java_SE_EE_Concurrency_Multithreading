/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.rest;
import java.lang.Thread;
import com.app.runnable.loggingProcessor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ELCOT
 */
@Path("logging")
public class loggingResource {
   
    @Resource(lookup ="java:comp/DefaultManagedThreadFactory")
    
    private ManagedThreadFactory threadfactory;
    
    @GET
    public String logData(){
      Thread thread = threadfactory.newThread(new loggingProcessor());
      thread.setName("logging-thread");
      thread.start();
      
      ExecutorService service =getApplicationpool();
      
      for(int i=0;i<7;i++){
      service.submit(new loggingProcessor());
      }
      
       return "logging thread doing job, check console!";
    }
   public  ExecutorService getApplicationpool(){
       
       ExecutorService service= new ThreadPoolExecutor(3,10,5,TimeUnit.SECONDS,new ArrayBlockingQueue(2),threadfactory);
       return service;
   }    
}
