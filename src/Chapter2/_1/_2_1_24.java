package Chapter2._1;

import Chapter2.ArraySort;
import Chapter2.InsertionSort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _2_1_24 {
    public static class InsertionSort2 extends ArraySort{
        private static void minFirst(Comparable[] a){
            int min_index = 0;
            for(int i = 1; i < a.length; i++){
                if(less(a[i], a[min_index]))
                    min_index = i;
            }
            exch(a, 0, min_index);
        }

        public static void sort(Comparable[] a){
            minFirst(a);
            for(int i = 1; i < a.length; i++){
                for(int j = i; less(a[j], a[j-1]); j--){
                    exch(a, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args){
        Double[] array = new Double[10];
        for(int i = 0; i < 10; i++)
            array[i] = StdRandom.uniform(0.0, 10.0);
        InsertionSort2.sort(array);
        assert InsertionSort2.isSorted(array);
    }
}
