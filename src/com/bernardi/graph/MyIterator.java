/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graph;

import com.bernardi.node.Nodable;
import com.bernardi.edge.Edgeable;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public interface MyIterator<N extends Comparable<N>,E extends Number & Comparable<E>> {
    boolean hasNode();
    boolean hasEdge();
    Nodable<N> getNextNode();
    Edgeable<N,E> getNextEdge();
}
