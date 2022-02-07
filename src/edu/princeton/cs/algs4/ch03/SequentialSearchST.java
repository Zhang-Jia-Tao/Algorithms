package edu.princeton.cs.algs4.ch03;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class SequentialSearchST<Key,Value> implements Iterable<Key>{
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node node = first;node != null;node = node.next){
            if(key.equals(node.key)){
                return node.value;
            }
        }

        return null;
    }

    public void put(Key key,Value value){
        for(Node node = first;node != null;node = node.next){
            if(key.equals(node.key)){       //命中，更新
                node.value = value;
                return;
            }
        }
         first = new Node(key,value,first);     //未命中，新建结点
    }

    @Override
    public Iterator<Key> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            if(current == null)
                return false;
            return true;
        }

        @Override
        public Key next() {
            Key key = current.key;
            current = current.next;
            return key;
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<String,Integer> st;
        st = new SequentialSearchST<>();
        for(int i=0;!StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String key:st){
            System.out.println(key+" : "+st.get(key));
        }
    }
}
