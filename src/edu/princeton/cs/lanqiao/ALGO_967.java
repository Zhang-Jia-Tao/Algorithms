package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//bug太多  0分
class line {
    int x0;
    int x1;
    int y0;
    int y1;
    double k;
    double b;
    int count = 2;

    public line(int x0,int y0,int x1,int y1){
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.k = (double) (y1-y0)/(x1-x0);
        this.b = y0-k*x0;
    }

}

public class ALGO_967 {

    private static line[] lines;

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] points = new int[N][2];
        int i=0;
        int w = N;
        while(w>0){
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
            i++;
            w--;
        }
        //此时w为0
        lines = new line[N*(N-1)/2];
        for(int j=0;j<N;j++){
            for(int k=j+1;k<N;k++){
                lines[w] = new line(points[j][0],points[j][1],points[k][0],points[k][1]);
                w++;
            }
        }

        //比较k与b
        for(int j=0;j<N*(N-1)/2;j++){
            for(int k=j+1;k<N*(N-1)/2;k++){
                if(lines[j].k == lines[k].k && lines[j].b == lines[k].b){
                    if(lines[j].x0 == lines[k].x0 || lines[j].x0 == lines[k].x1){
                        if(lines[j].y0 == lines[k].y0 || lines[j].y1 == lines[k].y1){
                            lines[k].count--;
                            continue;
                        }
                    }
                    if(lines[j].x1 == lines[k].x0 || lines[j].x1 == lines[k].x1){
                        if(lines[j].y1 == lines[k].y0 || lines[j].y1 == lines[k].y1){
                            lines[k].count--;
                        }
                    }
                    lines[j].count += lines[k].count;
                }

            }
        }

        int max = 0;
        for(int j=0;j<N*(N-1)/2;j++){
            if(max < lines[j].count){
                max = lines[j].count;
            }
        }

        System.out.println(max);

    }
}

