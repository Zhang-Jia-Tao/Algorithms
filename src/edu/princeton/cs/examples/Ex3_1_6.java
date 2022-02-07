package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//统计get、put调用的次数
public class Ex3_1_6 {
    public static void main(String[] args) {

        //
        long put_count = 0;
        long get_count = 0;

        int minlen = Integer.parseInt(args[0]);
        ST<String,Integer> st = new ST<>();
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length() < minlen){     //忽略较短的单词
                continue;
            }
            if(!st.contains(word)){
                st.put(word,1);
            } else {
                st.put(word,st.get(word)+1);
            }
            put_count++;
        }

        String maxWord = " ";    //用于存储出现频率最高的单词
        st.put(maxWord,0);
        put_count++;
        for(String word : st.keys()){
            if(st.get(word) > st.get(maxWord)){
                maxWord = word;
            }
            get_count += 2;
        }

        StdOut.println(maxWord + " " + st.get(maxWord));
        StdOut.println("put() counts : "+put_count+"\n"+"get() counts : "+get_count);
    }
}
