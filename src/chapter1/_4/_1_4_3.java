package chapter1._4;

import edu.princeton.cs.algs4.*;

import java.awt.*;

public class _1_4_3 {
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args){
        DrawPoint draw = new DrawPoint();
//        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.005);
        for(int N = 250; N < 100000; N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            draw.drawPoint(N, time, Color.RED);
        }
    }
}
