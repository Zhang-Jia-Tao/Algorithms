package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

//1.2.1 编写一个Point2D的用例，从命令行接受一个整数N。在单位正方形中生成N个随机点，然后计算两点之间的最近距离
public class Ex1_2_1 {
    public static void main(String[] args) {
        double min = 1/0.00000000001;   //无穷大
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];

        //设置x，y的范围
        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);

        StdDraw.setPenRadius(0.008);
        StdDraw.setPenColor(Color.RED);

        //图形化出N个点
        for(int i=0;i<N;i++){
            double x = StdRandom.random();
            double y = StdRandom.random();
            Point2D point2D = new Point2D(x,y);
            point2D.draw();
            points[i] = point2D;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j)  //排除相同的点
                    continue;
                double dis = points[i].distanceTo(points[j]);
                if(dis<min){
                    min = dis;
                }
            }
        }

        System.out.println(min);
    }
}
