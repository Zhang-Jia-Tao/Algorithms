package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.TreeMap;

public class Ex1_4_15_ThreeSumFast {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }

    //我认为这个方法可以啊，但是就是跑不出来
/*    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        for(int i=0,j=a.length-1;i<j;){
            if(a[i]+a[j]<0){
                for(int k=j-1;k>i;k--){
                    if(a[i]+a[j]+a[k]<0){
                        break;
                    } else if(a[i]+a[j]+a[k]>0){
                        continue;
                    } else {
                        cnt++;
                        break;
                    }
                }
                i++;
            } else if(a[i]+a[j]>0){
                for(int k=i+1;k<j;k++){
                    if(a[i]+a[j]+a[k] < 0){
                        continue;
                    } else if(a[i]+a[j]+a[k] > 0){
                        break;
                    } else {
                        cnt++;
                        break;
                    }
                }
                j--;
            }
        }
        return cnt;
    }
}
 */

 public static int count(int[] a){
     Arrays.sort(a);
     int cnt = 0;
     for(int i=0;i<a.length-2;i++){
         for(int j=i+1,k=a.length-1;j<k;){
             if(a[i]+a[j]+a[k] > 0){
                 k--;
             } else if (a[i]+a[j]+a[k] < 0){
                 j++;
             } else {
                 k--;
                 j++;
                 cnt++;
             }
         }
     }

     return cnt;

 }

}