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
import com.bernardi.opsgenerics.DoubleGenerics;
import com.bernardi.opsgraphable.Measurer;
import com.bernardi.opsgraphable.OpsGraph;

/**
 *
 * @author rr
 */
public class testString extends Tester<String,Double>{
    
    public testString() {
        super.g=new Graph<>();
    }

    @Override
    public void start() {
        DoubleGenerics opd= new DoubleGenerics();
        
        Measurer<String,Double> jj=new OpsGraph<>();
        
        g.addNewNode("ciao");
        g.addNewNode("cane");
        
        g.addNewDoubleEdge(0.2,"ciao","cane");
        g.addNewEdge(0.5, "ciao", "ciao");
        g.addNewEdge(0.1, "cane", "cane");
        
        System.out.println("");
        System.out.println("matrici ad n-steps(>=2) di markov");
        int t;
        for(t=2;t<12;t++){
            Double[][]var2steps2 = Operations.Markov(g, jj, t , opd);
            OpsArr.stampaMat(var2steps2,g, g.getNodes().size());
            System.out.println("");
        }
        
        System.out.println("Numero di passi prima di arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));
        
    }
    
}
