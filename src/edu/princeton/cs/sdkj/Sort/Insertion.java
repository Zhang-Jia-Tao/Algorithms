package edu.princeton.cs.sdkj.Sort;

//插入排序
public class Insertion {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0;i<10;i++){
            a[i] = 9-i;
        }

        sort(a);

        for(int i=0;i<10;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

    public static void sort(int[] a) {
        int temp = 0;
        int insert = 0;
        for(int i=1;i<a.length;i++){
            temp = a[i];
            insert = i-1;
            while(insert>=0 && a[insert]>temp){
                a[insert+1] = a[insert];
                insert--;
            }
            a[insert+1] = temp;
        }
    }

}
