/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.dataframe;

import java.util.ArrayList;

/**
 *
 * @author rr
 */
public class Data {
    private String fieldName;
    private Object[] hold= new Object[3];
    private ArrayList<Integer> dataInt=null;
    private ArrayList<String> dataStr=null;
    private ArrayList<Double> dataDou=null;
    private int active=-1;

    public Data(String fieldName) {
        this.fieldName = fieldName;
        hold[0]=dataInt;
        hold[1]=dataStr;
        hold[2]=dataDou;
    }
    
    private int getActive(){
        return active;
    }
    
    public String getName(){
        return fieldName;
    }
    
    public String getType(){
        switch(getActive()){
            case 0:
                return "Integer";
            case 1:
                return "String";
            case 2:
                return "Double";
        }
        
        return "error, type not yet setted";
    }
    
    private void prepField(){
        this.hold[active]=new ArrayList<>();
    }

    public void addType(String type){
        if(this.active==-1){
            switch(type){
                case "Integer":
                    this.active=0;
                    prepField();
                    break;
                case "String":
                    this.active=1;
                    prepField();
                    break;
                case "Double":
                    this.active=2;
                    prepField();
                    break;
                default:
                    System.out.println("error, rewrite correctly the type");
                    break;
            }
        }else{
            System.out.println("error, this field is already taken");
        }
    }
    
    public void addEntry(Object o){
        if( ((ArrayList) hold[getActive()])==null){
            System.out.println("error you have to initialize it before dereferencing it");
        }else{
            switch(getActive()){
                case 0:
                    ((ArrayList<Integer>)hold[0]).add((Integer)o);
                    break;
                case 1:
                    ((ArrayList<String>)hold[1]).add((String)o);
                    break;
                case 2:
                    ((ArrayList<Double>)hold[2]).add((Double)o);
                    break;
            }
        }
    }
    
    private <T> void doSomething(OpData<T> m){
        m.Do((ArrayList<T>)hold[getActive()]);
    }
    
    private void callToDo(){
        switch(getActive()){
                case 0:
                    doSomething(new OpData<Integer>(){});
                    break;
                case 1:
                    doSomething(new OpData<Integer>(){});
                    break;
                case 2:
                    doSomething(new OpData<Integer>(){});
                    break;
            }
    }
}
