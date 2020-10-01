package com.jetbrains;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Generator {
    private int[][] matrix;
    private int vertices;
    Random r = new Random();


    public Generator(int vertices) {
        if (vertices > 17576) throw new IllegalArgumentException("The number of vertices is too big");

        this.vertices = vertices;
        this.matrix = new int[this.vertices][this.vertices];
    }

    public int randomNumber(int max, int min, boolean sparce){
        if (sparce && r.nextBoolean()){
            return 0;
        }
        return r.nextInt(max-min+1)+min;
    }

    public void createGraph(int maxWeight,int minWeight,Boolean sparce){
        for (int i =0; i < vertices; i++){
            for (int j=0; j <= i; j++){
                if (i == j){
                    matrix[i][j] = 0;
                }
                else {
                    int w = randomNumber(maxWeight,minWeight,sparce);
                    matrix[i][j] = w;
                    matrix[j][i] = w;
                }
            }
        }
    }

    public void printMatrix(){
        for( int[] arr: matrix){
            System.out.println(Arrays.toString(arr));
        }
    }

    public void writeToFile(String filename){
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i =0; i<vertices-1; i++){
                for (int j =i+1; j < vertices; j ++){
                    if (matrix[i][j]!=0){
                        writer.write(i + " " + j + " " + matrix[i][j] + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not write to file!");
        }
    }

    public ArrayList<Vertex>CombineAdj(ArrayList<Vertex> V){

        ArrayList<Vertex> newV = (ArrayList<Vertex>) V.stream()
                .collect(Collectors.groupingBy(x -> x.s))
                .values().stream()
                .map(g -> {
                    ArrayList<Edge> list = new ArrayList<>();
                    for (Vertex i : g) {
                        ArrayList<Edge> adjacency = i.adjacency;
                        for (Edge edge : adjacency) {
                            list.add(edge);
                        }
                    }
                    Vertex v = new Vertex(g.get(0).s);
                    v.initAdjList(list);
                    return v;
                }).collect(Collectors.toList());

        return newV;
    }

    public ArrayList<Vertex> readBuffer(String filename){
        ArrayList<Vertex> temp = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String input;
            while((input = br.readLine())!=null){
                String[] line = input.split(" ");
                Vertex v = new Vertex(line[0]);
                Vertex u = new Vertex(line[1]);
                int w    = Integer.parseInt(line[2]);
                v.initAdj(new Edge(u,w));
                u.initAdj(new Edge(v,w));
                temp.add(v);
                temp.add(u);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Vertex> V = CombineAdj(temp);
        return V;
    }
}
