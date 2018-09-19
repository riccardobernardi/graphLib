/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.BasicTestsLib;

import com.bernardi.graph.Graph;
import com.bernardi.graph.MyIterator;
import com.bernardi.graphlib.Tester;

/**
 *
 * @author rr
 */
public class testBasicGraphFunc extends Tester<Integer,Integer>{

    public testBasicGraphFunc() {
        super.g=new Graph<>();
    }
    
    @Override
    public void start() {
        
        g.addNewNode(1);
        g.addNewNode(2);
        g.addNewNode(3);
        g.addNewNode(4);
        g.addNewNode(5);
        g.addNewNode(6);
        
        g.addNewDoubleEdge(1,2,3);
        g.addNewDoubleEdge(1,3,4);
        g.addNewDoubleEdge(1,4,5);
        g.addNewDoubleEdge(1,5,6);
        g.addNewDoubleEdge(1,6,1);
        
        System.out.println("path 1,2 : "+g.ExistPathAToB(1, 2));
        System.out.println("path 2,3 : "+g.ExistPathAToB(2, 3));
        System.out.println("path 3,1 : "+g.ExistPathAToB(3, 1));
        System.out.println("path 3,89 : "+g.ExistPathAToB(3, 89));
        
        System.out.println(""+g.getEdges().size());
        
        MyIterator i=g.getIterator();
        while(i.hasEdge()){
            System.out.print(""+i.getNextEdge().toString()+" ");
        }
        System.out.println("");
        
        System.out.println(""+g.getEdges().get(0).compareTo(g.getEdges().get(0)));
        
        Graph<Integer,Integer> p=g;
        System.out.println(""+p.equals(g));
        
        Graph<Integer,Integer> m= new Graph<>();
        m.addNewNode(1);
        System.out.println(""+g.equals(m));
        
        System.out.println("struct of G");
        g.printNodes();
        g.printEdges();
        System.out.println("struct of m");
        m.printNodes();
        m.printEdges();
    }
    
}
