/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.edge;

import java.awt.Graphics2D;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public interface Edgeable<N extends Comparable<N>,E extends Number & Comparable<E>> {
    public boolean isEqual(E peso,N u,N v);
    public boolean isEqual(N u,N v);
    public E getPeso();
    public N getU();
    public N getV();
    public void setPositionsIn(double x_in, double y_in);
    public void setPositionsOut(double x_out, double y_out);
    public void paint(Graphics2D panel);
    public void setWeight(E weight);
}
