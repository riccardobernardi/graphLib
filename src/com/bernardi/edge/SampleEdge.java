/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.edge;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class SampleEdge<N extends Comparable<N>,E extends Number & Comparable<E>> extends SuperEdge{
    
    public SampleEdge(E peso, N u, N v, int id) {
        super(peso, u, v, id);
    }
}
