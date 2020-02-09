package Chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShellSort extends ArraySort{
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3*h;
        while (h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    private static void sortShow(double[] a){
        int N = a.length;
        double[] minmax = DrawArray.getMinMax(a);
        int h = 1;
        while (h < N / 3) h = 3*h;
        while (h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j-=h){
                    double tmp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = tmp;
                }
            }
            h /= 3;
            DrawArray.drawArray(a, minmax[0], minmax[1]);
            StdDraw.pause(100);
            StdDraw.clear();
        }
        DrawArray.drawArray(a, minmax[0], minmax[1]);
    }

    public static void main(String[] args){
        int N = 100;
        double[] array = new double[N];
        for(int i=0; i < N; i++)
            array[i] = StdRandom.uniform(-100.0, 100.0);
        sortShow(array);
//        for(double d: array)
//            StdOut.println(d);
//        assert isSorted(array);
    }
}
