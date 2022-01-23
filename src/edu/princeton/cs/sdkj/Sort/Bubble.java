package edu.princeton.cs.sdkj.Sort;

//冒泡排序
public class Bubble {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0;i<a.length;i++){
            a[i] = 9-i;
        }

        sort(a);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();

        int[] a1 = {13,1,-2,-9,10,-4};
        sort(a1);
        for (int i=0;i<a1.length;i++){
            System.out.print(a1[i]+"\t");
        }
        System.out.println();
    }

    public static void sort(int[] a){
        boolean flag = false;
        for(int i=1;i<a.length;i++){    //外循环
            int frontptr = 0;
            int behindptr = 1;
            for(int j=0+i;j<a.length;j++){
                if(a[frontptr] > a[behindptr]){
                    int temp = a[behindptr];
                    a[behindptr] = a[frontptr];
                    a[frontptr] = temp;
                    flag = true;
                }
                frontptr++;
                behindptr++;
            }
            if(!flag){   //在其中的某一趟排序中 顺序已经符合设定了，因此可以退出循环，排序完成
                break;
            } else {
                flag = false;

            }

        }

    }
}
