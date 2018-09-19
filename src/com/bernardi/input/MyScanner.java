/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.input;

import java.util.Scanner;

/**
 *
 * @author rr
 */
public class MyScanner {
    String[] text=new String[1000];
    int i=0;

    public MyScanner() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Input massimo = 1000 parole sennò modificami");
        System.out.println("-Enter text: ");
        String s="";
        while(reader.hasNext() && !(s = reader.next()).equals("exit")){
            text[i]=s;
            i++;
        }
        System.out.println("stop-");
    }
    
    public String[] getText(){
        return text;
    }
    
    public int getIndex(){
        return i;
    }
    
}
