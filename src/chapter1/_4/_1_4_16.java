package chapter1._4;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.Arrays;

public class _1_4_16 {
    public static double[] nearNumber(double[] array){
        assert array.length >= 2;
        Arrays.sort(array); //排序NlgN
        int first = 0;
        int second = first+1;
        double minValue = array[second] - array[first];
        for(int i = second; i < array.length; i++){
            if(array[i] - array[i-1] < minValue){
                first = i-1;
                second = i;
            }
        }
        return new double[]{array[first], array[second]};
    }

    private static double Test(int N){
        double[] array = new double[N];
        for(int i = 0; i < array.length; i++){
            array[i] = StdRandom.uniform(0.0, 10.0);
        }
        Stopwatch stopwatch = new Stopwatch();
        nearNumber(array);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args){
        DrawPoint dw = new DrawPoint();
//        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.01);
        for(int i = 1000; i < 100000000; i*=2){
            double time = Test(i);
            StdOut.printf("%7d\t%5.3f\n", i, time);
            dw.drawPoint(i, time, Color.RED);
        }
    }

}
