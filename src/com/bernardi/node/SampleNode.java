/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.node;

/**
 *
 * @author rr
 * @param <N>
 */
public class SampleNode<N extends Comparable<N>> extends SuperNode{
    
    public SampleNode(Comparable<N> peso, int id ) {
        super(peso , id);
    }
    
}
