package Chapter2._1;

import Chapter2.InsertionSort;
import Chapter2.SelectionSort;
import Chapter2.ShellSort;
import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _2_1_35 {
    public static Double[] getRandomValue(String distribute, int N){
        Double[] array = new Double[N];
        if(distribute.equals("gaussian")){
            for(int i = 0; i < N; i++)
                array[i] = StdRandom.gaussian(0, 10000);
        }
        else if(distribute.equals("poisson")){
            for(int i = 0; i < N; i++)
                array[i] = StdRandom.poisson(100)*1.0;
        }
        else if(distribute.equals("geometric")){
            for(int i=0; i < N; i++)
                array[i] = StdRandom.geometric(0.5) * 1.0;
        }
        else if(distribute.equals("discrete")){
            for(int i = 0; i < N; i++)
                array[i] =  StdRandom.uniform(-1000.0, 1000);
        }
        else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    public static double runSort(String sortName, Double[] a){
        if(sortName.equals("insert")){
            Stopwatch sw = new Stopwatch();
            InsertionSort.sort(a);
            return sw.elapsedTime();
        }
        else if(sortName.equals("select")){
            Stopwatch sw = new Stopwatch();
            SelectionSort.sort(a);
            return sw.elapsedTime();
        }
        else if(sortName.equals("shell")){
            Stopwatch sw = new Stopwatch();
            ShellSort.sort(a);
            return sw.elapsedTime();
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);

        for(int i=100; i < 100000; i*=2){
            dp.drawPoint(i,
                    runSort("shell", getRandomValue("gaussian", i)),
                    Color.RED);
            dp.drawPoint(i,
                    runSort("shell", getRandomValue("poisson", i)),
                    Color.GREEN);
            dp.drawPoint(i,
                    runSort("shell", getRandomValue("geometric", i)),
                    Color.PINK);
            dp.drawPoint(i,
                    runSort("shell", getRandomValue("discrete", i)),
                    Color.BLUE);
        }
    }
}
