/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.BasicTestsLib;

import com.bernardi.graph.Graph;
import com.bernardi.graphlib.Tester;
import com.bernardi.opsarr.Operations;
import com.bernardi.opsarr.OpsArr;
import com.bernardi.opsgenerics.Generics;
import com.bernardi.opsgenerics.IntegerGenerics;
import com.bernardi.opsgraphable.Measurer;
import com.bernardi.opsgraphable.OpsGraph;

/**
 *
 * @author rr
 */
public class testInteger extends Tester<Integer,Integer>{

    public testInteger() {
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
        
        Generics<Integer> opi = new IntegerGenerics();

        Measurer<Integer,Integer> meas1= new OpsGraph<>();
        Integer adjMat[][]= Operations.getAdjMat(g, meas1, opi);
        
        System.out.println("peso di un grafo sulla base dei pesi degli archi");
        Measurer<Integer,Integer> l= new OpsGraph<>();
        int peso=Operations.weight(g, l, opi);
        System.out.println(""+peso);
        
        System.out.println("matrice di adiacenza");
        Measurer<Integer,Integer> j=new OpsGraph<>();
        Integer[][] var = Operations.getAdjMat(g, j, opi);
        OpsArr.stampaMat(var,g ,g.getNodes().size());
    }
    
}
