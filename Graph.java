package com.jetbrains;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

    ArrayList<Vertex> vertices;
    PriorityQueue<Vertex> Q = new PriorityQueue<>();
    ArrayList<Vertex> MST;

    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
        this.MST = new ArrayList<>();
    }

    public int weight(Edge e){
        return e.w;
    }
    public int findByName(ArrayList<Vertex>V, Vertex s){
        for(Vertex u: V){
            if (u.s == s.s){
                return V.indexOf(u);
            }
        }return 0;
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
            for (Edge e: u.adjacency){
                int i = findByName(vertices,e.v);
                if ((Q.contains(e.v)) && weight(e) < vertices.get(i).key){
                    vertices.get(i).setKey(weight(e));
                    e.v.setKey(weight(e));
                    Q.clear();
                    Q.addAll(vertices);
                }
            }
        }
    }


    public Vertex findByWeight(ArrayList<Edge> es, int w){
        for (Edge e: es){
            if (e.w == w){
                return e.v;
            }
        }
        return new Vertex("0");
    }
    public void printMST(){
        int total = 0;
        if (MST.size() == 0){
            System.out.println("The tree is empty");
        }
        System.out.println("Edge" + " " + "\t" + "Weigth");
        for (int i=1; i<MST.size();i++){
            int key = MST.get(i).key;
            System.out.println(MST.get(i) + "--" + findByWeight(MST.get(i).adjacency,key) + "\t" + key );
            total += MST.get(i).key;
        }
        System.out.println("\nThe total weight on the edges of the tree: "+total);
    }
}
