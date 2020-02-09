package Chapter2;

import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.*;

import java.awt.*;

public class SortCompare {
    public static double[] Test(int N){
        Double[] array1 = new Double[N];
        Double[] array2 = new Double[N];
        for(int i = 0; i < N; i++){
            double d = StdRandom.uniform(-1000.0, 1000.0);
            array1[i] = d;
            array2[i] = d;
        }
        Stopwatch sw = new Stopwatch();
        Insertion.sort(array1);
        double t1 = sw.elapsedTime();
        sw = new Stopwatch();
        ShellSort.sort(array2);
        double t2 = sw.elapsedTime();
        return new double[]{t1, t2};
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int i = 100; i < 100000; i*=2){
            double[] time = Test(i);
            dp.drawPoint(i, time[0], Color.RED);
            dp.drawPoint(i, time[1], Color.GREEN);
        }
        StdOut.println("end");
    }
}
