package edu.princeton.cs.algs4.ch02;

import java.security.Key;

//基于堆的优先队列
public class MaxPQ <Key extends Comparable<Key>> {
    private Key[] pq;   //基于堆的完全二叉树
    private int N = 0;  //存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN];
    }

    public boolean isEmpty(){
        if(N == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];    //从根节点得到最大元素
        exch(1,N--);     //将其和最后一个节点交换
        pq[N+1] = null;     //防止对象游离
        sink(1);
        return max;
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){   //上浮动
        while(k>=1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){   //下沉
        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)){     //对比两个子结点，找出较大的那一个
                j++;
            }
            if(!less(k,j)){        //k>j
                break;
            }
            exch(k,j);
            k = j;
        }
    }




}
