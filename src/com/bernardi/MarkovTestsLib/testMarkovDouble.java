/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.MarkovTestsLib;

import com.bernardi.graph.Graph;
import com.bernardi.graphlib.Tester;
import com.bernardi.opsarr.Operations;
import com.bernardi.opsarr.OpsArr;
import com.bernardi.opsgenerics.DoubleGenerics;
import com.bernardi.opsgraphable.Measurer;
import com.bernardi.opsgraphable.OpsGraph;

/**
 *
 * @author rr
 */
public class testMarkovDouble extends Tester<Integer,Double>{

    public testMarkovDouble() {
        super.g=new Graph<>();
    }

    @Override
    public void start() {
        DoubleGenerics opd= new DoubleGenerics();
        
        Measurer<Integer,Double> jj=new OpsGraph<>();
        
        g.addNewNode(1);
        g.addNewNode(2);
        
        g.addNewDoubleEdge(0.2,1,2);
        g.addNewEdge(0.5, 1, 1);
        g.addNewEdge(0.1, 2, 2);
        
        System.out.println("");
        System.out.println("matrici ad n-steps(>=2) di markov");
        int t;
        for(t=2;t<12;t++){
            Double[][]var2steps2 = Operations.Markov(g, jj, t , opd);
            OpsArr.stampaMat(var2steps2, g, g.getNodes().size());
            System.out.println("");
        }
        
        System.out.println("Numero di passi prima di arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));
        
    }
    
}
