package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.*;

import java.awt.*;

//
public class Ex1_2_2 {
    public static void main(String[] args) {
        //Receive parameter N from Command Line
        int N = Integer.parseInt(args[0]);

        Interval1D[] intervals = new Interval1D[N];
        double[] datas = new double[2*N];
        //Use StdIn to read
        int i=0;
        while(!StdIn.isEmpty()){
            datas[i] = StdIn.readDouble();
            i++;
            if(i >= 2*N)
                break;
        }


        int k=0;
        for(int j=0;j<N;j++){
            Interval1D interval1D = new Interval1D(datas[k],datas[k+1]);
            intervals[j] = interval1D;
            k += 2;
        }

        for(int l=0;l<N;l++){
            for(int m=l+1;m<N;m++){
               if( intervals[l].intersects(intervals[k]) ){
                   System.out.println(l+": "+intervals[l].toString()+"\t"+m+": "+intervals[m].toString());
               }
            }
        }

    }
}
