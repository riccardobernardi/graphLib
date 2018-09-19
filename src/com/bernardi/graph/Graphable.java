/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graph;

import com.bernardi.node.SuperNode;
import com.bernardi.edge.SuperEdge;
import java.util.ArrayList;

/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public abstract interface Graphable<N extends Comparable<N>,E extends Number & Comparable<E>> extends MyIterable<N,E>, Iterable<N>, Comparable<Graphable<N,E>> {
    public int addNewNode(N id);
    public int isPresentNode(N u);
    public int isPresentEdge(E peso,N u,N v);
    public int isPresentEdge(N u,N v);
    public void addNewEdge(E peso, N u, N v );
    public void addNewDoubleEdge(E peso, N u, N v );
    public ArrayList<Integer> nodesOfU(N u);
    public int ExistPathAToB(N u, N v);
    public void printEdges();
    public void printNodes();
    public ArrayList<SuperEdge<N,E>> getEdges();
    public ArrayList<SuperNode<N>> getNodes();
    public void setEdgeWeight(E weight, int index);
    public SuperEdge<N,E> getEdgeByIndex(int index);
    public SuperNode<N> Search(N a);
    public ArrayList<SuperNode<N>> indToNode(ArrayList<Integer> nodesOfU);
    public boolean DeleteAllEdges();
}
