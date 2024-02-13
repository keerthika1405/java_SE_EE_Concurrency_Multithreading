/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.custom;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author ELCOT
 */
public class customThreadFactory implements ThreadFactory{

private static int counter=0;
    @Override
    public Thread newThread(Runnable r) {
       Thread thread =new Thread(r);
       thread.setName("custome thread"+(++counter));
       return thread;
    }

    
}
