package edu.princeton.cs.algs4.ch04;

public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v,int w,double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex) throws Exception {
        if(vertex == v){
            return w;
        } else if(vertex == w){
            return v;
        } else {
            throw new Exception("不存在该点");
        }
    }


    @Override
    public int compareTo(Edge that) {
        if(this.weight() < that.weight()){
            return -1;
        } else if(this.weight() > that.weight()){
            return 1;
        } else {
            return 0;
        }
    }

    public String toString(){
        return String.format("%d-%d %.2f",v,w,weight);
    }

    public static void main(String[] args) {
        Edge edge = new Edge(1,2,0.22);
        System.out.println(edge);
    }
}
