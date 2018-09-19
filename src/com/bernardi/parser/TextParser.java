/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.parser;

import com.bernardi.graph.Graph;
import com.bernardi.graph.MyIterator;
import com.bernardi.node.Nodable;
import com.bernardi.node.SuperNode;
import java.util.ArrayList;

/**
 *
 * @author rr
 */
public class TextParser {
    private Graph<String,Double> space= new Graph<>();
    
    public TextParser(String[] text, int dim) {
        update(text,dim);
    }
    
    public TextParser() {
        //
    }
    
    public Graph<String,Double> getGraph(){
        return space;
    }
    
    public void update(String[] text, int dim){
        int j=0;
        
        //space.DeleteAllEdges();
        
        for(int i=0;i<dim;i++){
            if(space.isPresentNode(text[i])==-1 && text[i].compareTo(".")!=0){
                space.addNewNode(text[i]);
                j++;
            }
        }

        for(int i=0;i<dim;i++){
            if(i+1<dim && space.isPresentNode(text[i])!=-1 && space.isPresentNode(text[i+1])!=-1 /*&& space.isPresentEdge(text[i], text[i+1])==-1*/ && text[i].compareTo(".")!=0 /*&& text[i+1].compareTo(".")!=0*/){
                space.addNewEdge(0.0, text[i], text[i+1]);
            }
        }

        MyIterator i=space.getIterator();
        while(i.hasNode()){
            Nodable<String> nodo = i.getNextNode();
            
            //mi dà i odi adiacenti ad ogni nodo
            ArrayList<SuperNode<String>> nodes = space.indToNode(space.nodesOfU(nodo.getPeso()));
            if(nodes.size()>0){
                double prob=1.0/nodes.size();
                //ciclo su ogni nodo per dare la prob alle sue adiacenze
                for(SuperNode<String> node : nodes){
                    space.setEdgeWeight(   space.getEdgeByIndex(space.isPresentEdge(nodo.getPeso(), node.getPeso())).getPeso()+prob, space.isPresentEdge(nodo.getPeso(), node.getPeso())   );
                }
            }
        }
    }
    
}
