package edu.princeton.cs.algs4.ch03;

import java.security.Key;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        if(N == 0){
            return true;
        }
        return false;
    }

    public int rank(Key key,int lo,int hi){
        if(hi < lo){
            return lo;
        }
        int mid = lo + (hi - lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0){
            return rank(key,lo,mid-1);
        } else if(cmp > 0){
            return rank(key,mid+1,hi);
        } else {
            return mid;
        }
    }

    public int rank(Key key){
        int lo = 0;
        int hi = N-1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                hi = mid - 1;
            } else if (cmp > 0){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    //是否包含key
    public boolean contains(Key key){
        return true;
    }

    public Key floor(Key key){      //小于等于key的最大键
        return null;
    }

}
