/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.test;

import com.app.runnable.cleaningschedulor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ELCOT
 */
public class testSchedulor {

    public static void main(String[]args){
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//    service.schedule(new cleaningschedulor(), 5, TimeUnit.SECONDS);
//    service.scheduleAtFixedRate(new cleaningschedulor(), 5, 4, TimeUnit.SECONDS);
     service.scheduleWithFixedDelay(new cleaningschedulor(), 5, 4, TimeUnit.SECONDS);
    }
    
    }
