package com.jetbrains;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vertex> V = new ArrayList<>();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");
        Vertex i = new Vertex("i");

        //a
        a.initAdj(new Edge(b,4),new Edge(h,8)); V.add(a);
        //b
        b.initAdj(new Edge(a,4),new Edge(h,11),new Edge(c,8)); V.add(b);
        //c
        c.initAdj(new Edge(b,8),new Edge(i,2),new Edge(f,4),new Edge(d,7)); V.add(c);
        //d
        d.initAdj(new Edge(c,7),new Edge(e,9),new Edge(f,14)); V.add(d);
        //e
        e.initAdj(new Edge(d,9),new Edge(f,10)); V.add(e);
        //f
        f.initAdj(new Edge(e,10),new Edge(g,2),new Edge(c,4),new Edge(d,14)); V.add(f);
        //g
        g.initAdj(new Edge(i,6),new Edge(h,1),new Edge(f,2)); V.add(g);
        //h
        h.initAdj(new Edge(a,8),new Edge(i,7),new Edge(g,1)); V.add(h);
        //i
        i.initAdj(new Edge(h,7),new Edge(c,2),new Edge(g,6)); V.add(i);

        Graph G = new Graph(V);
        G.Prim(a);
       // G.printMST();
    }
}
