/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.node;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author rr
 * @param <N>
 */
public abstract class SuperNode<N extends Comparable<N>> implements Nodable<N>, Comparable<SuperNode<N>> {
    private N peso;
    private int id;
    private double x;
    private double y;
    private double r;
    
    public SuperNode(N peso, int id){
        this.peso=peso;
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public N getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return ("("+ peso+","+id+")");
    }
    
    public boolean isEqualByWeight(SuperNode<N> b){
        return this.getPeso()==b.getPeso();
    }
    
    public boolean isEqual(SuperNode<N> b){
        return this.getId()==b.getId();
    }

    @Override
    public int compareTo(SuperNode<N> o) {
        return this.getPeso().compareTo(o.getPeso());
    }
    
    @Override
    public void paint(Graphics2D panel, double x, double y, double r){
        this.x=x;
        this.y=y;
        this.r=r;
        panel.draw(new Ellipse2D.Double(x, y, r, r));
        panel.drawString(peso.toString(), (float)(x+r/2),(float)(y+r/2));
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getR() {
        return r;
    }
}
