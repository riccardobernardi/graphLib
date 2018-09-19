/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsgenerics;

/**
 *
 * @author rr
 */
public class IntegerGenerics implements Generics<Integer>{
    @Override
    public Integer sum(Integer a, Integer b){
        return a+b;
    }

    @Override
    public Integer mult(Integer a, Integer b){
        return a*b;
    }

    @Override
    public Integer id(Integer a){
        return a;
    }

    @Override
    public Integer[][] getMat(int n){
        return new Integer[n][n];
    }

    @Override
    public Integer getZero(){
        return 0;
    }

    @Override
    public Integer ceil(Integer a){
        return a;
    }

    @Override
    public Integer divide(Integer a, Integer b){
        return a/b;
    }

    @Override
    public Integer getThousand(){
        return 1000;
    }

    @Override
    public Integer multi(Integer a, Integer b) {
        return mult(a,b);
    }
}
