package com.jetbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Vertex implements Comparable<Vertex> {
    String s;
    ArrayList<Edge> adjacency;
    int key = Integer.MAX_VALUE;

    public Vertex(String s) {
        this.s = s;
        adjacency = new ArrayList<>();
    }

    public void initAdj(Edge... p) {
        this.adjacency.addAll(Arrays.asList(p));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex){
             return ((Vertex) obj).getKey() == this.getKey();
        } else {
            return false;
        }
    }

    /*Comparator<Vertex> ,
    @Override
    public int compare(Vertex o1, Vertex o2) {
        if (o1.key < o2.key){
            return o1.key;
        }else {
            return o2.key;
        }
    }*/

    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.equals(o)){
            return 0;
        }else if(this.getKey() >= o.getKey()){
            return 1;
        }else {
            return -1;
        }
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Vertex " + s;
    }
}
