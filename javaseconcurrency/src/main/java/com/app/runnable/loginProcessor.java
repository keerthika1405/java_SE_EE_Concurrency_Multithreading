/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELCOT
 */
public class loginProcessor implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
       Logger.getLogger(loginProcessor.class.getName()).log(Level.INFO,"logging something");
       return true;
    }
    
}
