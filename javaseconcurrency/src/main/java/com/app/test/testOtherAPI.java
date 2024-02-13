/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.test;

import com.app.runnable.loginProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.util.concurrent.Executors.callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class testOtherAPI {
    public static void main(String[]args){
     ExecutorService service=Executors.newFixedThreadPool(2);
     List<Callable<Boolean>> callable=new ArrayList<>();
        try {      
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            callable.add(new loginProcessor());
            
            List<Future<Boolean>> futures=service.invokeAll(callable);
            
            for(Future<Boolean> future:futures){
                System.out.println("operation result "+future.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(testOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(testOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println(service.invokeAny(callable));
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(testOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(testOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        service.shutdown();
        try {
            System.out.println("is service is shutdown "+service.awaitTermination(30,TimeUnit.SECONDS));
        } catch (InterruptedException ex) {
            service.shutdownNow();
            Logger.getLogger(testOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
