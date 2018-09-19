/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphics;

import com.bernardi.edge.Edgeable;
import com.bernardi.graph.MyIterator;
import com.bernardi.graph.SuperGraph;
import com.bernardi.node.Nodable;
import com.bernardi.node.SuperNode;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class Graphics<N extends Comparable<N>,E extends Number & Comparable<E>> extends JComponent{
    private final SuperGraph<N,E> graph;
    private final int n;

    public Graphics(SuperGraph<N, E> g) {
        this.graph = g;
        this.n=g.getEdges().size();
    }
    
    @Override
    public void paintComponent(java.awt.Graphics gr){
        Graphics2D panel = (Graphics2D)gr;
        double width=this.getWidth();
        double height= this.getHeight();
        double r= 20;
        double x;
        double y;
        
        MyIterator<N,E> i=graph.getIterator();
        while(i.hasNode()){
            while(i.hasNode()){
                Nodable<N> node= i.getNextNode();
                x=Math.random()*width;
                y=Math.random()*height;
                
                while(y>=height-40){y--;}
                while(x>=width-40){x--;}
                
                while(y<50){y++;}
                while(x<50){x++;}
                
                node.paint(panel,x,y,r);

                MyIterator<N,E> ed=graph.getIterator();
                N a=node.getPeso();
                while(ed.hasEdge()){
                    Edgeable<N,E> e=ed.getNextEdge();
                    if( a== e.getU()){
                        e.setPositionsIn(x, y);
                    }
                }
                
                ed=graph.getIterator();
                while(ed.hasEdge()){
                    Edgeable<N,E> e=ed.getNextEdge();
                    if( a== e.getV()){
                        e.setPositionsOut(x, y);
                    }
                }
            }
        }
        
        while(i.hasEdge()){
            i.getNextEdge().paint(panel);
        }
    }
    
}
