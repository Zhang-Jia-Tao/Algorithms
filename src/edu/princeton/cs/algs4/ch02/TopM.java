package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.*;

//一个优先队列的应用
public class TopM {
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M+1);

        while(StdIn.hasNextLine()){
            //为下一行输入创建一个元素并放入优先队列中
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size() > M){
                pq.delMin();     //如果优先队列中存在M+1个元素则删除其中最小的元素
            }
        }   //最大的M个元素都在优先队列中

        Stack<Transaction> stack = new Stack<>();
        while(!pq.isEmpty()){   //将M个最大的元素压入栈中
            stack.push(pq.delMin());
        }

        for(Transaction t:stack){
            StdOut.println(t);
        }

    }

}
