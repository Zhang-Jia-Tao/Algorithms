package edu.princeton.cs.algs4.util;

public class Stopwatch extends edu.princeton.cs.algs4.Stopwatch {

    private long start;

    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return now - start;
    }
}
