package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Graph {

    ArrayList<Vertex> vertices;
    PriorityQueue<Vertex> Q = new PriorityQueue<>();
    ArrayList<Vertex> MST;
    ArrayList<Vertex> Observed;

    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
        this.MST = new ArrayList<>();
        this.Observed = new ArrayList<>();

    }

    public int weight(Edge e){
        return e.w;
    }

    public void Prim(Vertex r){
        for (Vertex v: vertices){
            if(v == r){
                v.setKey(0);
            }
        }
        Q.addAll(vertices);

        while (!Q.isEmpty()){
            Vertex u = Q.poll();
            vertices.remove(u);
            MST.add(u);
            System.out.println(u.toString());
            for (Edge e: u.adjacency){
                if ((Q.contains(e.v)) && weight(e) < e.v.key ){
                    e.v.setKey(weight(e));
                    Q.clear();
                    Q.addAll(vertices);

                }
            }
        }
    }

    public void printMST(){
        if (MST.size() == 0){
            System.out.println("The tree is empty");
        }
        for (int i=0; i<MST.size();i++){
            System.out.println(MST.get(i) + " ");
        }
    }
}
