/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.input;

/**
 *
 * @author rr
 */
public class Trimmer {
    private String[] vect = new String[1000];
    private int index=0;
    
    public Trimmer(String s){
        
        for(int i=0;i<s.length();i++){
            String string="";
            int start=i;
            while(i<s.length() && s.charAt(i)!=' '){
                i++;
            }
            string=s.substring(start, i);
            vect[index]=string;
            index++;
        }
        
    }
    
    public String[] getTrimmed(){
        return vect;
    }
    
    public int getIndex(){
        return index;
    }
}
