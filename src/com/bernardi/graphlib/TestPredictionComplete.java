/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphlib;

import com.bernardi.graph.Graph;
import com.bernardi.graphics.PaintMe;
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
public class TestPredictionComplete extends Tester<String,Double>{

    @Override
    public void start() {
        //MyScanner my=new MyScanner();
        //my.getText();
        Trimmer tr=new Trimmer(Lorem.getCiao());
        System.out.println("l input per l apprendimento della sintassi è : "+Lorem.getCiao());
        TextParser m = new TextParser(tr.getTrimmed(),tr.getIndex());
        //da textparser ottengo il grafo della frase getCiao() e lui me lo restituisce
        //io ottengo il grafo e lo passo al padre in maniera che lui me lo stampi
        super.g=m.getGraph();
        super.paint();
        
        //apro una classe che gestisce i tipi double ci generics
        DoubleGenerics opd= new DoubleGenerics();
        //apro un measurer che mi da la possibilita di fare i markoviani
        Measurer<String,Double> jj=new OpsGraph<>();

        //questo mi da la matrice di adiacenza della frase getCiao()
        Double[][]mat = Operations.getUniqueAdjMat(g,jj,opd);
        
        //mi chiede una parola
        System.out.println("inserisci una parola che ho già appreso");
        MyScanner mm=new MyScanner();
        //mi crea una previsione basata sulle parole gia apprese cioe getCiao() per la parola appena inserita
        Prediction pr=new Prediction(mm.getText()[0],g);
        //mi printa la previsione della prossima parola che in base all esperienza acquisita può essere successivamente scritta
        System.out.println("predicted : "+pr.getPrediction());
        
        //printo la mat di adj
        System.out.println("----qui printo la matrice di adiacenza del grafo----");
        OpsArr.stampaMat(mat, g, g.getNodes().size());
        
        //printo per prova 10 matr di adj
        System.out.println("----qui printo 10 matrici di markov della matr originaria----");
        int t;
        for(t=2;t<12;t++){
            Double[][]var2steps2 = Operations.Markov(g, jj, t , opd);
            OpsArr.stampaMat(var2steps2, g, g.getNodes().size());
            System.out.println("");
        }
        
        //passi per arrivare alla matrice statica della frase getCiao()
        System.out.println("Numero di passi prima di arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));
        
        //ottengo il markoviano a 2 passi del grafo iniziale
        Double[][]mat2steps = Operations.Markov(g, jj, 2 , opd);
        //passo dalla matrice a 2 passi al grafo a 2 passi per poi printarlo
        Inverter<String,Double> inv=new Inverter(mat2steps,g.getNodes().size(),g.getNodes(),opd);
        //ottengo il grafo a 2 passi
        Graph<String,Double> gg=inv.getGraph();
       
        //preparo una classe di stampa
        PaintMe<String,Double> pm=new PaintMe();
        //inserisco il grafo
        pm.insert(gg);
        //printo il grafo
        pm.paint();
    }
    
}
