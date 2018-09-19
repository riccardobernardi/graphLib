/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsgraphable;

import com.bernardi.graph.Graphable;
import com.bernardi.opsgenerics.Generics;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public interface Measurer<N extends Comparable<N>,E extends Number & Comparable<E>> {
    public E[][] getAdjMat(Graphable<N,E> g, Generics<E> t);
    public E weightSum(Graphable<N,E> g, Generics<E> t);
    public E[][] getUniqueAdjMat(Graphable<N,E> g, Generics<E> t);
}
