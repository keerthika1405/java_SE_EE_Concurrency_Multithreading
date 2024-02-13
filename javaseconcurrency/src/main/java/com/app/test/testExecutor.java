/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.test;

import com.app.dao.userDao;
import com.app.runnable.applicationthread;
import com.app.runnable.userprocessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class testExecutor {
    public static void main(String[]args){
        ExecutorService service=Executors.newFixedThreadPool(3);
        List<String> users= getuserfromfile("D:\\APP\\window\\Music\\OneDrive\\Documents\\NetBeansProjects\\sample.txt");
        
        
        userDao dao= new userDao();
        for(String user:users){
//         Future<Integer> future = 
            service.submit(new userprocessor(user,dao));
            
//            try {
//                System.out.println("result of operation"+future.get());


//            } catch (InterruptedException ex) {
//                Logger.getLogger(testExecutor.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ExecutionException ex) {
//                Logger.getLogger(testExecutor.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }
        service.shutdown();
        System.out.println("main execution over");
    }
    public static List<String> getuserfromfile(String fileName){
        List<String> users= new ArrayList<>();
        
         try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
       
        String line= null;
        while((line=reader.readLine())!= null){
          users.add(line);
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testExecutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(testExecutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return users;
         
    }
}
