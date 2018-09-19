/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsarr;

import com.bernardi.edge.SuperEdge;
import com.bernardi.graph.Graphable;
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
public class OpsArr<N extends Comparable<N>,E extends Number & Comparable<E>> {
    
    public static <N extends Comparable<N>,E extends Number & Comparable<E>> E cumsum(ArrayList<SuperEdge<N,E>> m, Generics<E> t){
        E sum = t.getZero();
        
        Iterator<SuperEdge<N,E>> i= m.iterator();
        
        while(i.hasNext()){
            sum = t.sum(sum , i.next().getPeso());
        }
        
        return sum;
    }

    public static <N extends Comparable<N>,E extends Number & Comparable<E>> void stampaMat(E[][] var, Graphable<N,E>g, int dim) {
        int j=0;
        int i=0;
        ArrayList<SuperNode<N>> nodes=g.getNodes();
        String[] args=new String[1000];
        
        for(SuperNode<N> a : nodes){
            System.out.print(" "+a.getPeso());
            args[i]=a.getPeso().toString();
            i++;
        }
        System.out.println("");
        i=0;
        
        while(i < dim){
            while(j < dim){
                System.out.print(" |"+var[i][j]);
                j++;
            }
            j=0;
            i++;
            System.out.println(" "+args[i-1]);
        }
    }

    public static <N extends Comparable<N>,E extends Number & Comparable<E>> E[][] mult(E[][] mat1, E[][] mat2, int dim, Generics<E> t) {
        int i=0;
        int j=0;
        int k=0;
        E[][] res= t.getMat(dim);
        
        while(i<dim){
            while(j<dim){
                res[i][j]=t.getZero();
                while(k<dim){
                    res[i][j]=t.sum(res[i][j], t.mult(mat1[i][k],mat2[k][j]));
                    res[i][j]=t.divide(t.ceil(t.multi(t.id(res[i][j]),1000)),t.getThousand());
                    k++;
                }
                k=0;
                j++;
            }
            j=0;
            i++;
        }
        
        return res;
    }

    public static <N extends Comparable<N>,E extends Number & Comparable<E>> boolean equalMat(E[][] Markov1, E[][] Markov2, int dim, Generics<E> t) {
        int i=0;
        int j=0;
        
        while(i<dim){
            while(j<dim){
                if(Markov1[i][j].doubleValue()!=Markov2[i][j].doubleValue()){
                    return false;
                }
                j++;
            }
            j=0;
            i++;
        }
        
        return true;
    }
    
}
