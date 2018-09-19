/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graphlib;

import com.bernardi.MarkovTestsLib.testMarkovDouble;
import com.bernardi.MarkovTestsLib.testParsing;
import com.bernardi.BasicTestsLib.testString;
import com.bernardi.BasicTestsLib.testInteger;
import com.bernardi.BasicTestsLib.testBasicGraphFunc;

/**
 *
 * @author rr
 */
public class ComBernardiGraphLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testBasicGraphFunc m=new testBasicGraphFunc();
        //m.start();
        //m.paint();
        testInteger n= new testInteger();
        //n.start();
        //n.paint();
        testMarkovDouble p= new testMarkovDouble();
        //p.start();
        //p.paint();
        testString b= new testString();
        //b.start();
        //b.paint();
        testParsing tp= new testParsing();
        //tp.start();
        //tp.paint();
        TestPredictionComplete mn= new TestPredictionComplete();
        //mn.start();
        TestInputPrediction tip=new TestInputPrediction();
        tip.start();
    }
}
