package edu.princeton.cs.algs4.ch01;

//计时器
public class Stopwatch {
    private final long start;

    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    public double elapseTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}
