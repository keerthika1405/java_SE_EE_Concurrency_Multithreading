/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.test;

import com.app.custom.customThreadFactory;
import com.app.runnable.loginProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author ELCOT
 */
public class testThreadFactory {
    
    public static void main(String[]args){
    ExecutorService service=Executors.newFixedThreadPool(3, new customThreadFactory());
  
    for(int i=0;i<6;i++){
    service.submit(new loginProcessor());
    
    }
    }
}
