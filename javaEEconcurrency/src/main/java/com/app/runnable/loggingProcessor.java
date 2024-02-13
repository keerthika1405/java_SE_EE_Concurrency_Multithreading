/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class loggingProcessor implements Runnable {

    @Override
    public void run() {
        System.out.println("thread "+Thread.currentThread().getName());
        Logger.getLogger(loggingProcessor.class.getName()).log(Level.INFO,"logging data for logging resources");
    }
    
}
