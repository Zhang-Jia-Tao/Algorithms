package edu.princeton.cs.algs4.ch03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//P233 测试用例
public class Text {
    public static void main(String[] args) {
        ST<String,Integer> st;
        st = new ST<>();

        for(int i=0;!StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String s : st.keys()){      //st.keys() --> 已经按照key的大小进行了排序
            StdOut.println(s+" "+st.get(s));
        }
    }
}
