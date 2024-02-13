/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import com.app.bean.user;
import com.app.dao.userDao;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 *
 * @author ELCOT
 */
public  class userprocessor implements Callable<Integer> {
    private String userRecord;
    private userDao dao;

public userprocessor(String userRecord,userDao dao){
    this.userRecord=userRecord;
    this.dao =dao;
}

    @Override
    public Integer call() throws Exception {
      int rows=0;
      System.out.println(Thread.currentThread().getName()+"processing the record for : "+userRecord);
        StringTokenizer tokenizer = new StringTokenizer(userRecord,",");
        user user = null;
        while(tokenizer.hasMoreTokens()){
            user = new user();
            user.setEmail(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));
            rows=dao.saveuser(user);
        }
        return rows;
        
}

}


