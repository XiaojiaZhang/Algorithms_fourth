package Chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SelectionSort extends ArraySort{
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i<N; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static void sortShow(double[] a){
        int N = a.length;
        double[] minmax = DrawArray.getMinMax(a);
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            double tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
            DrawArray.drawArray(a, minmax[0], minmax[1]);
            StdDraw.pause(1000);
            StdDraw.clear();
        }
        DrawArray.drawArray(a, minmax[0], minmax[1]);
    }

    private static double[] getRandomArray(int N, double min, double max){
        double[] array = new double[N];
        for(int i = 0; i < N; i++){
            array[i] = StdRandom.uniform(min, max);
        }
        return array;
    }

    public static void main(String[] args){
        String[] array = new String[]{"2", "1", "4", "5", "3", "6"};
        sort(array);
        assert isSorted(array);

        double[] array2 = getRandomArray(10, -100.0, 100.0);
        sortShow(array2);
    }
}
