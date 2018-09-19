/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rr
 */
public class File {
    private String[] text=new String[1000];
    private int k=0;
    
    public File(String path) throws FileNotFoundException, IOException{
        FileReader f= new FileReader(path);
        BufferedReader b= new BufferedReader(f);
        String s=b.readLine();
        
        while( s!=null ){
            Trimmer tr=new Trimmer(s);
            int i=0;
            String[] addable=tr.getTrimmed();

            while(i<tr.getIndex()){
                if(addable[i]!=null){
                    text[k+i]=addable[i];
                }
                i++;
            }
            k+=i;
            s=b.readLine();
        }
    }
    
    public String[] getText(){
        return text;
    } 
    
    public int getIndex(){
        return k;
    }
    
}
