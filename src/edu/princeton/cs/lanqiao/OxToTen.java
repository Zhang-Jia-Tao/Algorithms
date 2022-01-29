package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//十六进制转十进制
// 其实最简单的方法是使用十六进制直接转换成十进制
public class OxToTen {
    private static int[] Ers;  //存储二进制数字
    private static int i = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String Ox = scanner.next();
        char[] Oxs = Ox.toCharArray();  //将其转换为数组
        Ers = new int[Oxs.length*4];    //初始化
        for(int j=Oxs.length-1;j>=0;j--){
            OxToEr(Oxs[j]);
        }

        //转换完二进制后，循环转换成十进制
        long res = 0;           //这里 原本是int 但是 但是理解不超过8位十六进制时理解错了，应该使用long
        for(int k=0;k<Ers.length;k++){
            res +=Ers[k]*Math.pow(2.0,k);
        }
        System.out.println(res);
    }

    //十六进制转二进制
    //Ers数组中数据权位由低到高
    private static void OxToEr(char ox){
        if(ox>=65){  //A-F
            int val = ox-55;
            int m = 4;
            while (m>0){
                Ers[i++] = val%2;
                val = val/2;
                m--;
            }
        } else {
            int val = ox-48;
            int m = 4;
            while(m>0){
                Ers[i++] = val%2;
                val = val/2;
                m--;
            }
        }
    }
}
