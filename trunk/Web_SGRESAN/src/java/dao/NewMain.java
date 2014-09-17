/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Joel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Date start;  
       Date end; 
       Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  
        Date now = new Date();  
  
        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);  
        start = cal.getTime();  
  
        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 40000);  
        end = cal.getTime(); 
        System.out.println(start+"__"+end);
    }
    
}
