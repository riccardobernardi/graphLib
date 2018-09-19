/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsgraphable;

import com.bernardi.opsgenerics.Generics;
import com.bernardi.edge.SuperEdge;
import com.bernardi.graph.Graphable;
import com.bernardi.opsarr.OpsArr;
import com.bernardi.opsarr.Set;
import java.util.ArrayList;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class OpsGraph<N extends Comparable<N>,E extends Number & Comparable<E>> implements Measurer<N,E>{

    @Override
    public E[][] getAdjMat(Graphable<N,E> g, Generics<E> t) {
        int n=g.getNodes().size();
        E[][] mat = t.getMat(n);
        
        int j=0;
        int i=0;
        while(i < n){
            while(j < n){
                mat[i][j]=t.getZero();
                j++;
            }
            j=0;
            i++;
        }

        ArrayList<SuperEdge<N,E>> edges=g.getEdges();
        for(SuperEdge<N,E> a : edges){
            
            if( g.isPresentEdge(a.getU(), a.getV())!=-1 ){
                mat[g.isPresentNode(a.getU())][g.isPresentNode(a.getV())]=a.getPeso();
            }
            
            if( g.isPresentEdge(a.getV() , a.getU())!=-1 ){
                mat[g.isPresentNode(a.getV())][g.isPresentNode(a.getU())]=a.getPeso();
            }
        }
        
        return mat;
    }
    
    @Override
    public E weightSum(Graphable<N,E> g, Generics<E> t){
        return OpsArr.cumsum(g.getEdges(),t);
    }

    @Override
    public E[][] getUniqueAdjMat(Graphable<N, E> g, Generics<E> t) {
        
        Set<N> extracted=new Set();
        int n=g.getNodes().size();
        E[][] mat = t.getMat(n);
        
        int j=0;
        int i=0;
        while(i < n){
            while(j < n){
                mat[i][j]=t.getZero();
                j++;
            }
            j=0;
            i++;
        }
        
        ArrayList<SuperEdge<N,E>> edges=g.getEdges();
        for(SuperEdge<N,E> a : edges){
            if(mat[g.isPresentNode(a.getU())][g.isPresentNode(a.getV())].compareTo(a.getPeso())<0)
                mat[g.isPresentNode(a.getU())][g.isPresentNode(a.getV())]=a.getPeso();
        }
        
        return mat;
    }
    
}
