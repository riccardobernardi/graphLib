/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.inverter;

import com.bernardi.graph.Graph;
import com.bernardi.node.SuperNode;
import com.bernardi.opsgenerics.Generics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class Inverter<N extends Comparable<N>,E extends Number & Comparable<E>> {
    Graph<N,E> g= new Graph<>();
    
    public Inverter(E[][] mat, int dim, ArrayList<SuperNode<N>> nodes, Generics<E> t){
        Iterator<SuperNode<N>> iter = nodes.iterator();
        SuperNode<N> curr;
        
        while(iter.hasNext()){
            curr=iter.next();
            //System.out.println("aggiungo nodo : "+curr.getPeso() );
            g.addNewNode(curr.getPeso());
        }
        
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(mat[i][j].compareTo(t.getZero())!=0){
                    //System.out.println("aggiungo arco : "+nodes.get(i).getPeso()+","+ nodes.get(j).getPeso());
                    g.addNewEdge(mat[i][j], nodes.get(i).getPeso(), nodes.get(j).getPeso());
                }
            }
        }
    }
    
    public Graph<N,E> getGraph(){
        return g;
    }
    
}
