/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;


import java.security.AccessController;
import javax.security.auth.Subject;


/**
 *
 * @author ELCOT
 */
public class contextServiceRunnable implements Runnable{
    
    @Override
    public void run(){
    System.out.println("Thread--->"+Thread.currentThread().getName());
   
    Subject subject = Subject.getSubject(AccessController.getContext());
    
    System.out.println("security information to the normal thread"+subject);
    }
}
