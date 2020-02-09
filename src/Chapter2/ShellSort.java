package Chapter2;

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

    public static void main(String[] args){
        int N = 10;
        Double[] array = new Double[N];
        for(int i=0; i < N; i++)
            array[i] = StdRandom.uniform(-100.0, 100.0);
        sort(array);
        for(double d: array)
            StdOut.println(d);
        assert isSorted(array);
    }
}
