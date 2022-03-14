package edu.princeton.cs.sdkj.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(list);
        list.remove("hello");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.add(0,"hello");
        System.out.println(list);
        list.removeAll(list);
        System.out.println(list);
    }
}
