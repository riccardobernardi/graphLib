/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.trees;

import com.bernardi.node.SampleNode;
import com.bernardi.graph.SuperGraph;
import com.bernardi.node.SuperNode;
import java.util.ArrayList;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public class Tree<N extends Comparable<N>,E extends Number & Comparable<E>> extends SuperGraph implements Treeable {
    SampleNode<N> root=null;
    private Number a=1;
    
    public Tree(N root){
        this.root= new SampleNode<>(root,0);
    }
    
    public int addNewNode(SuperNode<N> padre, N id){
        super.addNewNode(id);
        super.addNewDoubleEdge(a, padre.getId(), id);
        return super.isPresentNode(id);
    }

    @Override
    public SuperNode parent(SuperNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList sons(SuperNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int height(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperNode getRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperNode setRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperNode createRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preView(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postView(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inView(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable treeMin(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable treeMax(SuperNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int depth(SuperNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
