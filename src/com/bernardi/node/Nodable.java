/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.node;

import java.awt.Graphics2D;

/**
 *
 * @author rr
 * @param <N>
 */
public interface Nodable<N extends Comparable<N>> {
    public int getId();
    public N getPeso();
    public void paint(Graphics2D panel, double x, double y, double r);
    public double getR();
    public double getX();
    public double getY();
}
