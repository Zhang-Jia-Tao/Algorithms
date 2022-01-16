package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

//In 中静态方法 readInts 利用队列的静态实现
public class In_readInts {
    public static void main(String[] args) {
        int[] a = readInts(args[0]);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> queue = new Queue<>();
        while(!in.isEmpty()){
            queue.enqueue(in.readInt());
        }
        int N = queue.size();
        int[] result = new int[N];
        /*int j = 0;    //循环遍历
        for(Integer i : queue){
            result[j] = i;
            j++;
        }*/

        /*  for(int j=0;i<queue.size();j++){       //error：这里每次弹出队列都会是size减一，再加上j也每次增1 所以只能输出队列前一半的值
        *           result[j] = queue.dequeue();
        *   }
        * */
        for(int j=0;j<N;j++){
             result[j] = queue.dequeue();
        }

        return result;
    }
}
