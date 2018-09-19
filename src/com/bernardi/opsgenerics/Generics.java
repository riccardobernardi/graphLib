/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsgenerics;

/**
 *
 * @author rr
 * @param <T>
 */
public interface Generics<T extends Number & Comparable<T>> {
    public T sum(T a, T b);
    public T mult(T a, T b);
    public T multi(T a, Integer b);
    public T id(T number);
    public T[][] getMat(int n);
    public T getZero();
    public T ceil(T a);
    public T divide(T a, T b);
    public T getThousand();
}
