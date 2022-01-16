package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();

        while(!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
            //只有回车才会将从键盘的输入推送到缓冲区吗？？  --> 测试下是这样的 这样就和C语言的缓冲区机制就相同了
            //还有 是不是 对应着计组中的IO那里的
        }

        int N = numbers.size();

        if(N==0){
            System.out.println("N==0");
            return;
        }

        double sum = 0.0;
        for(Double x : numbers){
            sum += x;
        }
        double mean = sum/N;

        sum = 0.0;
        for(double x : numbers){
            sum +=(x-mean)*(x-mean);
        }
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %.2f\n",mean);
        StdOut.printf("Std dev: %.2f\n",std);
    }
}
