/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.edge;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public abstract class SuperEdge<N extends Comparable<N>,E extends Number & Comparable<E>> implements Edgeable<N,E>, Comparable<SuperEdge<N,E>> {
    private E peso;
    private final int id;
    private N u=null;
    private N v=null;
    private double x_in;
    private double y_in;
    private double x_out;
    private double y_out;
    
    public SuperEdge(E peso,N u,N v, int id){
        this.peso=peso;
        this.u=u;
        this.v=v;
        this.id=id;
    }
    
    @Override
    public boolean isEqual(E peso,N u,N v){
        return this.peso==peso && this.u==u && this.v==v;
    }
    
    @Override
    public boolean isEqual(N u,N v){
        return this.u==u && this.v==v;
    }

    @Override
    public E getPeso() {
        return peso;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public N getU() {
        return u;
    }

    @Override
    public N getV() {
        return v;
    }
    
    @Override
    public String toString(){
        return ("("+ peso+","+id+","+u+","+v+")");
    }
    
    @Override
    public int compareTo(SuperEdge<N,E> b) {
        return getPeso().compareTo(b.getPeso());
    }
    
    public E max(SuperEdge<N,E> b){
        return this.compareTo(b)>0?this.getPeso():b.getPeso();
    }
    
    public void setPositions(int x_in, int y_in, int x_out, int y_out){
        this.x_in=x_in;
        this.y_in=y_in;
        this.x_out=x_out;
        this.y_out=y_out;
    }
    
    @Override
    public void setPositionsIn(double x_in, double y_in){
        this.x_in=x_in;
        this.y_in=y_in;
    }
    
    @Override
    public void setPositionsOut(double x_out, double y_out){
        this.x_out=x_out;
        this.y_out=y_out;
    }
    
    @Override
    public void paint(Graphics2D panel){
        int r=5;
        //System.out.println("("+x_in+","+ y_in+"," +x_out+","+ y_out+")");
        panel.draw(new Line2D.Double(x_in, y_in, x_out, y_out));
        panel.draw(new Ellipse2D.Double(x_out, y_out,r,r));
    }
    
    @Override
    public void setWeight(E weight){
        this.peso=weight;
    }
}
