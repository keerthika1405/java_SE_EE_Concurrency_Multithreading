/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.test;

import com.app.runnable.applicationthread;

/**
 *
 * @author ELCOT
 */
public class testThread {
    
    public static void main(String[]args){    
       applicationthread thread1=new applicationthread(); //instance of the thread is created and state of the thread is new
       applicationthread thread2=new applicationthread();
       applicationthread thread3=new applicationthread();
       
       thread1.start();//when you start the thread the state of the thread become runnable
       thread2.start();
       thread3.start();
       
      /* state of thread  transition through during  its entire lifecycle
       
       *runnable means ready to run(indication given to JVM that yes, this thread is ready to run)
       *when your JVM is going to execute the runnable methods as per the scheduling ,when thats the point where the state of thread
       becoming running
                *in between the state of put to sleep or if the thread waiting fr some resource 
       (then it will go into the blocked state or waiting state)
       
       
       
       *when the job get completed thats, when the state of the thread is terminated as we say:dead
       
       */
      

       
    }
    
}
