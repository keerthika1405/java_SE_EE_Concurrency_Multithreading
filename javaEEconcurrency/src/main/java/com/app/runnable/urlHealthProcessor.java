/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */

 //check for health application --->we are taking the url try to access  the url via java.net API
public class urlHealthProcessor implements Runnable{

    
    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName()+"checking  the health of the application");
    
        String statusOfApplication="";
        try {
            URL url=new URL("https://www.google.com");
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                
                int responseCode =connection.getResponseCode();
                
                if(responseCode==200){
                statusOfApplication="yes it is working";
                }
                else{
                statusOfApplication="sorry!, something went wrong";
                }
                
              System.out.println("status of application : "+statusOfApplication);  
              
            
        }
           catch (MalformedURLException ex) {
            Logger.getLogger(urlHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(urlHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
       

    }
    

