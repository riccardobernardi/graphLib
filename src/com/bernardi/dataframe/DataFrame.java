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
public class DataFrame {
    
    ArrayList<Data> dataframe=null;

    public DataFrame() {
        dataframe=new ArrayList<>();
    }
    
    public void addNewField(String name, String type){
        Data m=new Data(name);
        m.addType(type);
        dataframe.add(m);
    }
    
}
