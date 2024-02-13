/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnable;

import com.app.bean.bankAccount;
import com.app.bean.bankAccountTransaction;
import com.app.dao.bankAccountDao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author ELCOT
 */
public class reportProcessor  implements Callable<Boolean> {
    
    private bankAccount account;
    private bankAccountDao dao;
    
    public reportProcessor(bankAccount account,bankAccountDao dao){
        this.account=account;
        this.dao=dao;
    }
    
    @Override
    public Boolean call() throws Exception{
        
         System.out.println(Thread.currentThread().getName()+"Report Generated");
        
      boolean reportGenerated =false;
        List<bankAccountTransaction> transactions=dao.getallbankaccountTransaction(account);
        File file=new File("D:\\APP\\window\\Music\\OneDrive\\Documents\\NetBeansProjects\\report"+account.getAccNumber()+"trans_report.txt");
         
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
        for(bankAccountTransaction transaction:transactions){
            
                      writer.write("account_Number"+transaction.getAccNumber());
            writer.write("trans_Type"+transaction.getTransType());
            writer.write("trans_Id"+transaction.getTransId());
            writer.write("Ammount"+transaction.getAmount());
            writer.write("trans_Date"+transaction.getTransDate());
            writer.newLine();
                      
            }
        writer.flush();     
    }
        reportGenerated=true;   
        return reportGenerated;
    }
}
