package com.jetbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    String s;
    ArrayList<Edge> adjacency;
    int key = Integer.MAX_VALUE;

    public Vertex(String s) {
        this.s = s;
        adjacency = new ArrayList<>();
    }

    public void initAdj(Edge... p) { this.adjacency.addAll(Arrays.asList(p));}
    public void initAdjList(List<Edge> p ){
        this.adjacency.addAll(p);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex){
             return ((Vertex) obj).key == this.key && ((Vertex) obj).s == this.s;
        } else {
            return false;
        }
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.equals(o)){
            return 0;
        }else if(this.key >= o.key){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return s;
    }

}
