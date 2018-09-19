/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphlib;

import com.bernardi.graph.Graph;
import com.bernardi.graphics.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public abstract class Tester<N extends Comparable<N>,E extends Number & Comparable<E>> implements Testable{
    public Graph<N,E> g=null;
    
    @Override
    public void paint() throws NullPointerException{
        
        if(g==null){
            throw new NullPointerException("Errore: stai cercando di disegnare un grafo che non hai istanziato, devi prima obbligatoriamente chiamare la funzione start o almeno farne un override che fa 'super.g=new Graph();'");
        }
        
        JFrame jf=new JFrame();
        jf.setDefaultCloseOperation(3);
        jf.setSize(800, 600);
        Graphics<N,E> m= new Graphics<>(g);
        jf.add(m);
        jf.setVisible(true);
    }
}
