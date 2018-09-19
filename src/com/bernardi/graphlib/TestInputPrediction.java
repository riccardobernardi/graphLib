/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphlib;

import com.bernardi.graph.Graph;
import com.bernardi.graphics.PaintMe;
import com.bernardi.input.File;
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rr
 */
public class TestInputPrediction extends Tester<String,Double>{

    @Override
    public void start() {
        
        System.out.println("ATTENTO:");
        System.out.println("metti un file in desktop chiamato input.txt");
        System.out.println("dovrà contenere frasi di addestramento separate da punto e spazio e punto(se sulla stessa riga) oppure spazio e punto e invio se vuoi metterle su righe diverse");
        System.out.println("non mettendo quel file otterrai un segfault");
        System.out.println("questo file lo puoi trovare gia preparato in /unive/corsi archiviati/PO anno 2018");
        
        /*
        potrebbe essere interessante trovare la clique massima e massimale
        
        cancellare gli archi precedenti quando faccio l update
        
        creare funz per cancellare tutti gli archi di un grafo
        
        inserimento nuove frasi con form per l utente
        */
        
        File ff=null;
        try {
            ff = new File("/Users/rr/Desktop/input.txt");
        } catch (IOException ex) {
            Logger.getLogger(TestInputPrediction.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextParser m;
        if(ff.getText()!=null){
            m= new TextParser(ff.getText(),ff.getIndex());
        }else{
            throw new NullPointerException("you have null in your file");
        }
        
        /*ora decido d aggiungere oltre che da file anche "online" cioè al volo*/
        /*potrebbe essere il caso di apprendimento dopo l inserimento di una frase
        inviata via smartphone, cioè l aggiornamento avviene sempre non solo da file inizialmente*/
        //Trimmer tr=new Trimmer(Lorem.getLorem());
        //m.update(tr.getTrimmed(),tr.getIndex());
        /*per aggiiungere online bisogna fare un metodo che aggiunge ad un 
        string[] un altro string[] e inoltre bisogna rimuovere tutti gli
        archi precedenti prima di aggiungere quelli nuovi*/
             
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
        System.out.println("Numero di passi per arrivare ad una matrice statica di markov : "+Operations.howManyStepsToPI(g, jj, opd));
        
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
        
        Operations.getCentrality(g);
    }
    
}