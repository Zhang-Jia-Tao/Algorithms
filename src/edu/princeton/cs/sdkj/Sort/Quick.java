package edu.princeton.cs.sdkj.Sort;

//快速排序
// 这个代码还不如算法的好理解
public class Quick {

    public static void quick(int[] arr,int left,int right){
        int l = left;   //左索引
        int r = right;  //右索引
        int pivot = arr[(left+right)/2]; //中轴线

        int temp = 0;

        //while循环的目的是让比pivot大的值放到右边，比pivot小的值放到左边
        while(l<r){
            //在pivot的左边一直查找，找到大于等于pivot才退出
            while(arr[l]<pivot){
                l++;
            }
            //在pivot的右边一直查找，找到小于等于pivot的才退出
            while(arr[r]>pivot){
                r--;
            }

            //如果l>=r说明，pivot两边的数据，已经按照左边全部是小于pivot的值，右边是大于pivot的值
            if(l>=r){
                break;
            }

            //交换数据
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot 相等，则r--；
            if(arr[l] == pivot){
                r--;
            }

            //如果交换完后，发现这个arr[r] == pivot 相等，则l++
            if(arr[r] == pivot){
                l++;
            }
        }

        // 如果l == r,必须l++,r--;否则会出现栈溢出
        if(l == r){
            l++;
            r--;
        }

        //向左递归
        if(left < r){
            quick(arr,left,r);
        }

        //向右递归
        if(right>l){
            quick(arr,l,right);
        }

    }

    public static void main(String[] args) {
        int[] arr = {};


    }

}
