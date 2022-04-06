package edu.princeton.cs.LeetCode.queue;


//设计环形队列
public class zjt_622 {
    //是否设置一个额外的空间，使尾指针指向它
    private int[] datas;

    //队头
    private int front;

    //队尾
    private int rear;

    public zjt_622(int k) {
        datas = new int[k+1];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        return true;
    }

    public boolean deQueue() {
        return true;
    }

    public int Front() {
        return 1;
    }

    public int Rear() {
        return rear;
    }

    public boolean isEmpty() {
        if(front == -1){
            return true;
        }

        return true;
    }

    public boolean isFull() {
        return true;
    }
}
