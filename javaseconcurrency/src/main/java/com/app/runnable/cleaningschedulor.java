/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class cleaningschedulor implements Runnable {
    
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(cleaningschedulor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File folder = new  File("D:\\APP\\window\\Music\\OneDrive\\Documents\\NetBeansProjects\\folder");
        File[] files=folder.listFiles();
        for(File file: files){
            if(System.currentTimeMillis()-file.lastModified()>5*60*1000){
            System.out.println("this file will be deleted"+file.getName());
            file.delete();
            }
        }
    }
}
