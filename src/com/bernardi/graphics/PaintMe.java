/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphics;

import com.bernardi.graph.Graph;
import com.bernardi.graphlib.Tester;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class PaintMe<N extends Comparable<N>,E extends Number & Comparable<E>> extends Tester<N,E>{

    @Override
    public void start() {
        paint();
    }
    
    public void insert(Graph<N,E> g){
        super.g=g;
    }
    
}
