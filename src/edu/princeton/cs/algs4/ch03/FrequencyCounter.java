package edu.princeton.cs.algs4.ch03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
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
        }

        String maxWord = " ";    //用于存储出现频率最高的单词
        st.put(maxWord,0);
        for(String word : st.keys()){
            if(st.get(word) > st.get(maxWord)){
                maxWord = word;
            }
        }

        StdOut.println(maxWord + " " + st.get(maxWord));
    }
}
