package chapter1._4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _1_4_17 {
    public static double[] farayayNumber(double[] array){
        assert array.length >= 2;
        double min, max;
        if(array[0] > array[1]){
            min = array[1];
            max = array[0];
        }
        else{
            min = array[0];
            max = array[1];
        }
        for(int i = 2; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        return new double[]{min, max};
    }

    private static double Test(int N){
        double[] array = new double[N];
        for(int i = 0; i < array.length; i++){
            array[i] = StdRandom.uniform(0.0, 10.0);
        }
        Stopwatch stopwatch = new Stopwatch();
        farayayNumber(array);
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
