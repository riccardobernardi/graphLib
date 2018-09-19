/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bernardi.graph;

import com.bernardi.node.Nodable;
import com.bernardi.node.SampleNode;
import com.bernardi.node.SuperNode;
import com.bernardi.edge.Edgeable;
import com.bernardi.edge.SuperEdge;
import com.bernardi.edge.SampleEdge;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author rr
 * @param <N>
 * @param <E>
 */
public abstract class SuperGraph<N extends Comparable<N>, E extends Number & Comparable<E>> implements Graphable<N,E> {
    
    protected ArrayList<SuperNode<N>> nodes = new ArrayList<>();
    protected ArrayList<SuperEdge<N,E>> edges = new ArrayList<>();
    protected int prog_node_id=0;
    protected int prog_edge_id=0;
    
    public SuperGraph(){
        //
    }
    
    @Override
    public int addNewNode(N peso){
        SuperNode<N> m=new SampleNode(peso,prog_node_id);
        nodes.add(m);
        prog_node_id++;
        return nodes.indexOf(m);
    }
    
    @Override
    public int isPresentNode(N u){
        //System.out.println("inizio controllo");
        for(Nodable<N> e : nodes){
            //System.out.println(""+e.getPeso());
            if(e.getPeso().compareTo(u)==0){
                //System.out.println("fine controllo con return >-1");
                return nodes.indexOf(e);
            }
        }
        //System.out.println("fine controllo con return -1");
        return -1;
    }
    
    @Override
    public int isPresentEdge(E peso,N u,N v){
        for(Edgeable<N,E> e : edges){
            if(e.isEqual(peso, u, v)){
                return edges.indexOf(e);
            }
        }
        return -1;
    }
    
    @Override
    public int isPresentEdge(N u,N v){
        for(Edgeable<N,E> e : edges){
            if(e.getU().compareTo(u)==0 && e.getV().compareTo(v)==0){
                return edges.indexOf(e);
            }
        }
        return -1;
    }
    
    @Override
    public void addNewEdge(E peso, N u, N v ){
        if(isPresentNode(u)>=0 && isPresentNode(v)>=0){
            edges.add(new SampleEdge(peso,nodes.get(isPresentNode(u)).getPeso(),nodes.get(isPresentNode(v)).getPeso(),prog_edge_id));
            prog_edge_id++;
        }
    }
    
    @Override
    public void addNewDoubleEdge(E peso, N u, N v ){
        if(isPresentNode(u)>=0 && isPresentNode(v)>=0){
            edges.add(new SampleEdge(peso,nodes.get(isPresentNode(u)).getPeso(),nodes.get(isPresentNode(v)).getPeso(),prog_edge_id));
            prog_edge_id++;
            edges.add(new SampleEdge(peso,nodes.get(isPresentNode(v)).getPeso(),nodes.get(isPresentNode(u)).getPeso(),prog_edge_id));
            prog_edge_id++;
        }
    }
    
    //given a node this give me its adjiacents nodes
    @Override
    public ArrayList<Integer> nodesOfU(N u){
        ArrayList<Integer> nodesofu=new ArrayList<>();
        
        for(Edgeable<N,E> e : edges){
            if(e.getU().compareTo(u)==0){
                nodesofu.add(isPresentNode(e.getV()));
            }
        }
        
        return nodesofu;
    }
    
    //given an arraylist of indexes of nodes in "nodes", this give me true nodes
    @Override
    public ArrayList<SuperNode<N>> indToNode(ArrayList<Integer> nodesOfU) {
        ArrayList<SuperNode<N>> nodi=new ArrayList<>();
        
        for(int i : nodesOfU){
            nodi.add(nodes.get(i));
        }
        
        return nodi;
    }
    
    //il k allo start è di default ad 1 sempre ed indica se ho un solo arco tra u e v
    public int ExistPathAToBAux(N u, N v, int k){
        ArrayList<SuperNode<N>> nodi=indToNode(nodesOfU(u));
        int l=-1;
        
        for(Nodable<N> n : nodi){
            if(n.getPeso().equals(v)){
                return k;
            }
        }
        
        for(Nodable<N> n : nodi){
            if(k < nodes.size()){
                int prev=l;
                l=ExistPathAToBAux( n.getPeso(),v,k+1);
                if(l==-1){
                    l=prev;
                }else{
                    if(prev<l && prev!=-1){
                        l=prev;
                    }
                }
            }
        }
        
        return l;
    }
    
    @Override
    public int ExistPathAToB(N u, N v){
        return ExistPathAToBAux(u,v,1);
    }

    @Override
    public ArrayList<SuperNode<N>> getNodes() {
        return nodes;
    }

    @Override
    public ArrayList<SuperEdge<N,E>> getEdges() {
        return edges;
    }
    
    @Override
    public MyIterator getIterator(){
        return (new MyIterator(){
            int i=0;
            int j=0;
            
            @Override
            public boolean hasNode() {
                return i<nodes.size();
            }

            @Override
            public boolean hasEdge() {
                return j<edges.size();
            }

            @Override
            public Nodable<N> getNextNode() {
                i+=1;
                return nodes.get(i-1);
            }

            @Override
            public Edgeable<N,E> getNextEdge() {
                j+=1;
                return edges.get(j-1);
            }
            
        });
    }

    @Override
    public Iterator<N> iterator() {
        return (new Iterator(){
            int i=0;
            
            @Override
            public boolean hasNext() {
                return i<nodes.size();
            }

            @Override
            public Nodable<N> next() {
                i+=1;
                return nodes.get(i-1);
            }
        
        });
    }

    /////////PATCHARE
    @Override
    public int compareTo(Graphable<N, E> something) {
        MyIterator<N,E> i=getIterator();
        double sumthis=0;
        
        while(i.hasEdge()){
            sumthis+= i.getNextEdge().getPeso().doubleValue();//////NOT GOOD
        }
        
        MyIterator<N,E> j=something.getIterator();
        int sumthat=0;
        while(j.hasEdge()){
            sumthat+=j.getNextEdge().getPeso().doubleValue();//////NOT GOOD
        }
        
        return sumthis>sumthat?1:sumthis==sumthat?0:-1;
    }
    
    public void setEdges(ArrayList<SuperEdge<N,E>> l){
        this.edges=l;
    }
    
    public boolean equals(SuperGraph<N,E> g){
        MyIterator<N,E> i=this.getIterator();
        MyIterator<N,E> j=this.getIterator();
        
        this.sort();
        g.sort();
        
        if(this.edges.size()!=g.getEdges().size() || this.nodes.size()!=g.getNodes().size()){
            return false;
        }
        
        while(i.hasEdge() && j.hasEdge()){
            if(i.getNextEdge() != j.getNextEdge()){
                return false;
            }
        }
        
        while(i.hasNode() && j.hasNode()){
            if(i.getNextNode()!= j.getNextNode()){
                return false;
            }
        }
        
        return true;
        
    }

    public void sort() {
        int i=0;
        int j=0;
        
        while(j<edges.size()){
            while(i+1<edges.size()){
                if(edges.get(i).compareTo(edges.get(i+1))>0){
                    SuperEdge<N,E> m=edges.get(i);
                    edges.set(i, edges.get(i+1));
                    edges.set(i+1, m);
                }
                i++;
            }
            j++;
        }
        
        j=0;
        i=0;
        
        while(j<nodes.size()){
            while(i+1<nodes.size()){
                if(nodes.get(i).compareTo(nodes.get(i+1))>0){
                    SuperNode<N> m=nodes.get(i);
                    nodes.set(i, nodes.get(i+1));
                    nodes.set(i+1, m);
                }
                i++;
            }
            j++;
        }
    }
    
    @Override
    public void printNodes(){
        System.out.println(""+this.nodes);
    }
    
    @Override
    public void printEdges(){
        System.out.println(""+this.edges);
    }
    
    @Override
    public void setEdgeWeight(E weight, int index){
        this.edges.get(index).setWeight(weight);
    }
    
    @Override
    public SuperEdge<N,E> getEdgeByIndex(int index){
        return this.edges.get(index);
    }
    
    @Override
    public SuperNode<N> Search(N a){
        for (SuperNode<N> b : nodes){
            if(b.getPeso().compareTo(a)==0){
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean DeleteAllEdges(){
        return edges.removeAll(edges);
    }
}

