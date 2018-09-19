/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.textProvisioning;

import com.bernardi.graph.Graphable;
import com.bernardi.node.SuperNode;
import java.util.ArrayList;

/**
 *
 * @author rr
 */
public class Prediction {

    private final String word;
    private final Graphable<String,Double> g;
    
    public Prediction(String word, Graphable<String,Double> g){
        this.word=word;
        this.g=g;
    }
    
    public String getPrediction(){
        SuperNode<String> a = g.Search(word);
        if(a!=null){
            ArrayList<SuperNode<String>> adj = g.indToNode(g.nodesOfU(word));
            double max=0;
            String maxS="errore : non ho trovato archi";
            for(SuperNode<String> b : adj ){
                if(g.isPresentEdge(a.getPeso(), b.getPeso())!=-1 && g.isPresentEdge(a.getPeso(), b.getPeso())!=-1 && g.getEdgeByIndex(g.isPresentEdge(a.getPeso(), b.getPeso())).getPeso()>max){
                    maxS=g.getEdgeByIndex(g.isPresentEdge(a.getPeso(), b.getPeso())).getV();
                    max=g.getEdgeByIndex(g.isPresentEdge(a.getPeso(), b.getPeso())).getPeso();
                }else{
                    if(g.isPresentEdge(a.getPeso(), b.getPeso())!=-1 && g.isPresentEdge(a.getPeso(), b.getPeso())!=-1 && g.getEdgeByIndex(g.isPresentEdge(a.getPeso(), b.getPeso())).getPeso()==max && b.getPeso().length()>1 && maxS.compareTo(b.getPeso())!=0){
                        maxS=maxS.concat("/");
                        maxS=maxS.concat(b.getPeso());
                    }
                }
            }
            return maxS;
        }else{
            return "errore : la parola non è stata precedentemente appresa";
        }
    }
    
}
