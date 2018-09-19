/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.opsarr;

import com.bernardi.graph.Graphable;
import com.bernardi.graph.MyIterator;
import com.bernardi.node.Nodable;
import com.bernardi.node.SuperNode;
import com.bernardi.opsgraphable.Measurer;
import com.bernardi.opsgenerics.Generics;
import java.util.ArrayList;
/**
 *
 * @author rr
 */
public class Operations{

    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E[][] getAdjMat(Graphable<N,E> g, Measurer<N,E> m, Generics<E> t) {
        return m.getAdjMat(g,t);
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E[][] searchCycles(Graphable<N,E> g, Measurer<N,E> m) {
        return null;
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E[][] hamiltonCycle(Graphable<N,E> g, Measurer<N,E> m) {
        return null;
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E[][] Markov(Graphable<N,E> g, Measurer<N,E> m, int k, Generics<E> t) {
        E[][] mat= getUniqueAdjMat(g,m,t);
        E[][] res = getUniqueAdjMat(g,m,t);
        
        k--;
        while(k>0){
            res=OpsArr.mult(res,mat,g.getNodes().size(),t);
            k--;
        }
        
        return res;
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E weight(Graphable<N,E> g, Measurer<N,E> m, Generics<E> t) {
        return m.weightSum(g,t);
    }
    
    //per aumentare le prestazioni si potrebbero salvare le matrici precedentemente calcolate e aggiungere i thread
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> int howManyStepsToPI(Graphable<N,E> g, Measurer<N,E> m, Generics<E> t) {
        int i=2;
        
        while(!OpsArr.equalMat(Markov(g,m,i,t),Markov(g,m,i+1,t),g.getNodes().size(),t)){
            i++;
            if(i>10){
                System.out.println("La matrice è grande, sono all iterazione : "+i);
            }
        }
        
        return i;
    }

    public static <N extends Comparable<N>, E extends Number & Comparable<E>> E[][] getUniqueAdjMat(Graphable<N,E> g, Measurer<N,E> m, Generics<E> t) {
        return m.getUniqueAdjMat(g,t);
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> N getCentrality(Graphable<N,E> g){
        MyIterator i=g.getIterator();
        int max=0;
        N maxPeso=null;
        while(i.hasNode()){
            Nodable<N> n = i.getNextNode();
            int cardinality = g.nodesOfU(n.getPeso()).size();
            if(cardinality>max){
                max=cardinality;
                maxPeso=n.getPeso();
            }
        }
        
        System.out.println("Centrality : '"+maxPeso+"' with : '"+max+"' followers");
        
        return maxPeso;
    }
    
    public static <N extends Comparable<N>, E extends Number & Comparable<E>> ArrayList<N> maxclique(Graphable<N,E> g, Measurer<N,E> m, Generics<E> t){
        //ottengo la matr di adiacenza
        //faccio una lista dei nodi con deg() maggiore
        //calcolo il determinante delle sottomatrici per ogni elemento della lista intorno alla diag principale , la sottomatrice si estende fino al primo zero nell intorno della diag princ
        //e il det maggiore è la maxclique
        
        //oppure estraggo il maggiore e guardo il grado massimo delle connessioni tra gli elementi a lui connessi e poi faccio lo stesso con gli altri nodi
        return null;
    }
}
