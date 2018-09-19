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
public class DoubleGenerics implements Generics<Double>{
    @Override
    public Double sum(Double a, Double b){
        return a+b;
    }

    @Override
    public Double mult(Double a, Double b){
        return a*b;
    }

    @Override
    public Double multi(Double a, Integer b){
        return a*(b.doubleValue());
    }

    @Override
    public Double id(Double a){
        return a;
    }

    @Override
    public Double[][] getMat(int n){
        return new Double[n][n];
    }

    @Override
    public Double getZero(){
        return 0.0;
    }

    @Override
    public Double ceil(Double a){
        return Math.floor(a);
    }

    @Override
    public Double divide(Double a, Double b){
        return a/b;
    }

    @Override
    public Double getThousand(){
        return 1000.0;
    }
    
}
