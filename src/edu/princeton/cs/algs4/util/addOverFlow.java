package edu.princeton.cs.algs4.util;

import edu.princeton.cs.algs4.StdOut;

//判断整数加法是否溢出
public class addOverFlow {

    //JDK8 的新特性  官方源码  判断是否溢出
    public static int addExact(int x, int y) {
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static int addExact(int x,int y,Flag flag) {
        int r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            StdOut.println("溢出");
            flag.setFlag(true);
        }
        return r;
    }

}
