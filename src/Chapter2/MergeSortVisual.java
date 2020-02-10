package Chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortVisual {

    private static double[] aux;
    private static double min;
    private static double max;
    //将数组a[lo, mid),a[mid, hi)均有序，将两数组进行合并
    //使得a[lo, hi)有序
    private static void merge(double [] a, int lo, int mid, int hi){
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
            else if(aux[i] < aux[j]){
                a[k] = aux[i++];
            }
            else{
                a[k] = aux[j++];
            }
        }
    }

    private static void sort(double[] a, int lo, int hi){
        //将数组进行分半，递归排序后，对两部分有序数组进行合并
        if(hi - lo <= 1)
            return;
        else{
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid, hi);
            merge(a, lo, mid, hi);
            DrawArray.drawArray(a, min, max);
            StdDraw.pause(100);
            StdDraw.clear();
        }
    }

    public static void sort(double[] a){
        aux = new double[a.length]; //分配一次内存空间
        double[] minmax = DrawArray.getMinMax(a);
        min = minmax[0];
        max = minmax[1];
        sort(a, 0, a.length);
        DrawArray.drawArray(a, min, max);
    }

    public static void main(String[] args){
        int N = 30;
        double[] a = new double[N];
        for(int i=0; i < a.length; i++)
            a[i] = StdRandom.uniform(-100.0, 100.0);
        sort(a);
    }

}
