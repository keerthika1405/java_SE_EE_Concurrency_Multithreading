/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bean;

import com.app.runnable.applicationthread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class testrunnable {
    public static void main(String[]args){
        Runnable runnable=()->{
              try(BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\APP\\window\\Music\\OneDrive\\Documents\\NetBeansProjects\\sample.txt")))){
       
        String line= null;
        while((line=reader.readLine())!= null){
           System.out.println(Thread.currentThread().getName()+"reading the line"+line);
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(applicationthread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(applicationthread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    };
        
        //overloaded thread constructor with runnable argument
//       Thread thread=new Thread(runnable);
//       thread.start();

//Executor

    Executor executor=Executors.newSingleThreadExecutor();
    executor.execute(runnable);
}
}
