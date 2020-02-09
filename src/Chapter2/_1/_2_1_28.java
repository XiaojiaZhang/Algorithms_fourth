package Chapter2._1;

import Chapter2.InsertionSort;
import Chapter2.SelectionSort;
import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _2_1_28 {
    public static double[] Test(int N){
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        for(int i = 0; i < N; i++){
            if(StdRandom.uniform(0.0, 1.0) > 0.5){
                a1[i] = 1;
                a2[i] = 1;
            }
            else{
                a1[i] = 0;
                a2[i] = 0;
            }
        }
        Stopwatch sw = new Stopwatch();
        SelectionSort.sort(a1);
        double t1 = sw.elapsedTime();
        sw = new Stopwatch();
        InsertionSort.sort(a2);
        double t2 = sw.elapsedTime();
        return new double[]{t1, t2};
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int i = 100; i < 10000; i+=100){
            double[] time = Test(i);
            dp.drawPoint(i, time[0], Color.RED);
            dp.drawPoint(i, time[1], Color.GREEN);
        }
    }
}
