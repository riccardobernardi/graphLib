/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graph;

/**
 *
 * @author rr
 */
interface MyIterable<N extends Comparable<N>,E extends Number & Comparable<E>> {
    MyIterator getIterator();
}
