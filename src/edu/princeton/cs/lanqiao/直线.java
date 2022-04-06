package edu.princeton.cs.lanqiao;

import java.util.HashMap;

public class 直线 {
    private static point[] points;
    private static class point {
        int x;
        int y;
        public point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        HashMap<Double,Double> map = new HashMap<>();
        points = new point[420];
        int index = 0;
        int count = 20;
        for(int i=0;i<=19;i++){
            for(int j=0;j<=20;j++){
                points[index++] = new point(i,j);
            }
        }
        for(int i=0;i<380;i++){
            for(int j=i+1;j<380;j++){
                if(points[i].x - points[j].x == 0){
                    continue;
                }
                double k = (double) (points[i].y - points[j].y)/(points[i].x - points[j].x);
                double b = points[i].y - k*points[i].x;
                if(map.containsValue(k) && map.containsValue(b)){
                    continue;
                } else {
                    map.put(k,b);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
