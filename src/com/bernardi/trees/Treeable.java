/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.trees;

import com.bernardi.graph.Graphable;
import com.bernardi.node.SuperNode;
import java.util.ArrayList;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public interface Treeable<N extends Comparable<N>,E extends Number & Comparable<E>> extends Graphable<N,E> {
    public SuperNode<N> parent(SuperNode<N> n);
    public ArrayList<SuperNode<N>> sons(SuperNode<N> n);
    public int height(SuperNode<N> root);
    public SuperNode<N> getRoot();
    public SuperNode<N> setRoot();
    public SuperNode<N> createRoot();
    public void preView(SuperNode<N> root);
    public void postView(SuperNode<N> root);
    public void inView(SuperNode<N> root);
    public N treeMin(SuperNode<N> root);
    public N treeMax(SuperNode<N> root);
    public int depth(SuperNode<N> n);
}
