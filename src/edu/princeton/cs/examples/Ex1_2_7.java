package edu.princeton.cs.examples;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import edu.princeton.cs.algs4.StdOut;

//原样输出 但在常量池中增加了很多中间过程产生的字符串
public class Ex1_2_7 {
    public static void main(String[] args) {
        StdOut.println(mystery("Hello World"));
    }

    public static String mystery(String s){
        int N = s.length();
        if(N<=1) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);
        return mystery(a) + mystery(b);
    }
}
