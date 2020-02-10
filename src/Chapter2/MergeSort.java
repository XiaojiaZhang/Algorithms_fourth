package Chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSort extends ArraySort{
    private static Comparable[] aux;
    //将数组a[lo, mid),a[mid, hi)均有序，将两数组进行合并
    //使得a[lo, hi)有序
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        //aux复制了ａ的部分元素
        System.arraycopy(a, lo, aux, lo, hi-lo);

        int i = lo;
        int j = mid;
        //a的其余部分未变，只调整a[lo, hi)部分
        for(int k = lo; k < hi; k++){
            if(i >= mid){
                a[k] = aux[j++];
            }
            else if(j >= hi){
                a[k] = aux[i++];
            }
            else if(less(aux[i], aux[j])){
                a[k] = aux[i++];
            }
            else{
                a[k] = aux[j++];
            }
        }
    }

    private static void sort(Comparable[] a, int lo, int hi){
        //将数组进行分半，递归排序后，对两部分有序数组进行合并
        if(hi - lo <= 1)
            return;
        else{
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid, hi);
            merge(a, lo, mid, hi);
        }
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length]; //分配一次内存空间
        sort(a, 0, a.length);
    }

    public static void main(String[] args){
        Integer[] a = new Integer[10];
        for(int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(0, 100);
        sort(a);
        for(int i: a)
            StdOut.println(i);
    }
}
