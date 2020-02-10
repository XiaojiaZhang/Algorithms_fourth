package Chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortBU extends ArraySort{
    private static Comparable[] aux;
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        System.arraycopy(a, lo, aux, lo, hi-lo);
        int i = lo, j = mid;
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

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[a.length];
        //自底向上归并排序，
        //初始时刻，有序数组长度为１，对相邻有序数据进行归并
        //在对有序数组长度为ｋ的相邻数组完成归并后，有序数组长度为2*k
        //因此下一步对长度为2*k的相邻有序数据进行归并
        //特别注意，最后一组有序数据合并的右边界确定 Math.min(lo+2*sz, N)
        for(int sz=1; sz < N; sz*=2){
            for(int lo = 0; lo < N; lo+=2*sz){
                merge(a, lo, lo+sz, Math.min(lo+sz*2, N));
            }
        }
    }

    public static void main(String[] args){
        Integer[] a = new Integer[10];
        for(int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(0, 100);
        sort(a);
        for(int i:a)
            StdOut.println(i);
    }
}
