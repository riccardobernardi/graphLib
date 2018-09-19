/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.MarkovTestsLib;

import com.bernardi.graph.Graph;
import com.bernardi.graphics.PaintMe;
import com.bernardi.graphlib.Tester;
import com.bernardi.input.Lorem;
import com.bernardi.input.MyScanner;
import com.bernardi.input.Trimmer;
import com.bernardi.inverter.Inverter;
import com.bernardi.opsarr.Operations;
import com.bernardi.opsarr.OpsArr;
import com.bernardi.opsgenerics.DoubleGenerics;
import com.bernardi.opsgraphable.Measurer;
import com.bernardi.opsgraphable.OpsGraph;
import com.bernardi.parser.TextParser;
import com.bernardi.textProvisioning.Prediction;

/**
 *
 * @author rr
 */
public class testParsing extends Tester<String,Double>{
    
    @Override
    public void start() {
        
        //MyScanner my=new MyScanner();
        //my.getText();
        //Trimmer tr=new Trimmer(Lorem.getLorem());
        
        Trimmer tr=new Trimmer(Lorem.getCiao());
        
        //TextParser m = new TextParser(tr.getTrimmed(),tr.getIndex());
        //TextParser m = new TextParser(my.getText(),my.getIndex());
        TextParser m = new TextParser(tr.getTrimmed(),tr.getIndex());
        super.g=m.getGraph();

        //ciao come stai . ciao come ti chiami . ciao cosa vuoi . ciao ti piace la torta . exit
        
        DoubleGenerics opd= new DoubleGenerics();
        Measurer<String,Double> jj=new OpsGraph<>();
        //System.out.println("Numero di passi prima di arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));

        Double[][]mat = Operations.getUniqueAdjMat(g,jj,opd);
        //OpsArr.stampaMat(mat, g, g.getNodes().size());
        
        //System.out.println(""+g.indToNode(g.nodesOfU("ciao")));
        
        System.out.println("inserisci una parola che ho già appreso");
        MyScanner mm=new MyScanner();
        Prediction pr=new Prediction(mm.getText()[0],g);
        System.out.println("predicted : "+pr.getPrediction());
        
        System.out.println("----qui printo la matrice di adiacenza del grafo----");
        OpsArr.stampaMat(mat, g, g.getNodes().size());
        
        System.out.println("----qui printo 10 matrici di markov della matr originaria----");
        int t;
        for(t=2;t<12;t++){
            Double[][]var2steps2 = Operations.Markov(g, jj, t , opd);
            OpsArr.stampaMat(var2steps2, g, g.getNodes().size());
            System.out.println("");
        }
        
        System.out.println("Numero di passi prima di arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));
        
        Double[][]mat2steps = Operations.Markov(g, jj, 2 , opd);
        Inverter<String,Double> inv=new Inverter(mat2steps,g.getNodes().size(),g.getNodes(),opd);
        Graph<String,Double> gg=inv.getGraph();
        
        //Double[][]mat2 = Operations.getUniqueAdjMat(gg,jj,opd);
        //OpsArr.stampaMat(mat2, gg, gg.getNodes().size());
        PaintMe<String,Double> pm=new PaintMe();
        pm.insert(gg);
        pm.start();
    }
    
}
