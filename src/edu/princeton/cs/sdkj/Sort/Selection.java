package edu.princeton.cs.sdkj.Sort;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Selection {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=9;i>=0;i--){
            a[i] = i;
        }
        sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();


        //选择排序的速度测试
        int[] arrrays = new int[80000];
        for(int i=0;i<arrrays.length;i++){
            arrrays[i] = (int)Math.random()*800000;
        }
        //System.out.println("排序前");
        Date preDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(preDate);
        System.out.println("排序前的时间是"+date);

        sort(arrrays);

        //System.out.println("排序后");
        Date finDate = new Date();
        String findate = format.format(finDate);
        System.out.println("排序后的时间为"+findate);



    }

    public static void sort(int[] arr){
        int temp = 0;
        int min = 999;
        for(int i=0;i<arr.length;i++){
            min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
