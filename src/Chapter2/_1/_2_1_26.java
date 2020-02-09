package Chapter2._1;

import Chapter2.InsertionSort;
import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _2_1_26 {
    public static void insertionSort(int[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && a[j] < a[j-1]; j--){
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
    }

    public static double[] Test(int N){
        Integer[] a1 = new Integer[N];
        int[] a2 = new int[N];
        for(int i = 0; i < N; i++){
            int random = StdRandom.uniform(-1000, 1000);
            a1[i] = random;
            a2[i] = random;
        }
        Stopwatch sw = new Stopwatch();
        InsertionSort.sort(a1);
        double t1 = sw.elapsedTime();
        sw = new Stopwatch();
        insertionSort(a2);
        double t2 = sw.elapsedTime();
        return new double[]{t1, t2};
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int i = 100; i < 10000; i += 100){
            double[] time = Test(i);
            dp.drawPoint(i, time[0], Color.RED);
            dp.drawPoint(i, time[1], Color.GREEN);
        }
    }
}
