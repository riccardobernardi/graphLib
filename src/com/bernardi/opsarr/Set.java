/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsarr;

import java.util.ArrayList;

/**
 *
 * @author rr
 * @param <T>
 */
public class Set<T extends Comparable<T>> {
    
    ArrayList<T> set=new ArrayList<>();
    
    public void add(T a){
        set.add(a);
    }
    
    public int isPresent(T a){
        for(T b : set){
            if(b.compareTo(a)==0){
                return set.indexOf(b);
            }
        }
        return -1;
    }
    
    public T getT(int index){
        return set.get(index);
    }
}
