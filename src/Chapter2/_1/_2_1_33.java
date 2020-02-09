package Chapter2._1;

import Chapter2.InsertionSort;
import Chapter2.SelectionSort;
import Chapter2.ShellSort;
import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _2_1_33 {
    public static double runSort(String sortName, int N){
        assert N > 0;
        Integer[] array = new Integer[N];
        for(int i = 0; i < array.length; i++)
            array[i] = StdRandom.uniform(-10000, 10000);
        if(sortName.equals("insert")){
            Stopwatch sw = new Stopwatch();
            InsertionSort.sort(array);
            return sw.elapsedTime();
        }
        else if(sortName.equals("select")){
            Stopwatch sw = new Stopwatch();
            SelectionSort.sort(array);
            return sw.elapsedTime();
        }
        else if(sortName.equals("shell")){
            Stopwatch sw = new Stopwatch();
            ShellSort.sort(array);
            return sw.elapsedTime();
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        if(args.length != 2)
            throw new IllegalArgumentException();
        int i = 0;
        double timeSum = 0;
        while (true){
            double time = runSort(args[0], Integer.parseInt(args[1]));
            timeSum += time;
            dp.drawPoint(i++, time, Color.GRAY);
            dp.drawPoint(i, timeSum/i, Color.PINK);
        }
    }
}
