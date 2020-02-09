package Chapter2;

import chapter1._3.DoubleNodeList;
import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class InsertionSort extends ArraySort{
    //循环不变式
    //当前索引为j时，a[0, j)已排序
    //起始时，j=1, 仅包含一个数组a[0]，循环不变　式成立
    //循环过程中，循环不变式也保持
    //循环结束后，  i=N, 此时a[0, N)已排序，整个数组有序
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++){ //从第二元素开始，寻找其对应的有序下标,其余元素对应后移动
            //循环过程中
            //a[0, j)有序, a[j, i+1)有序
            //内循环结束时，a[j] > a[j-1]
            //所以a[0, i+1)有序
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }

    public static void sort2(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++){
            int j;
            for(j = i; j > 0 && less(a[i], a[j-1]); j--);
            Comparable tmp = a[i];
            System.arraycopy(a, j, a, j+1, i-j);
            a[j] = tmp;
        }
    }

    private static void sortShow(double[] a){
        int N = a.length;
        double[] minmax = DrawArray.getMinMax(a);
        for(int i = 1; i < N; i++){ //从第二元素开始，寻找其对应的有序下标,其余元素对应后移动
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                double tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
            DrawArray.drawArray(a, minmax[0], minmax[1]);
            StdDraw.pause(100);
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

    private static double[] Test(int N){
        Double[] array1 = new Double[N];
        Double[] array2 = new Double[N];
        for(int i = 0; i < N; i++){
            double random = StdRandom.uniform(-100000.0, 100000.0);
            array1[i] = random;
            array2[i] = random;
        }
        Stopwatch sw = new Stopwatch();
        sort(array1);
        double t1 = sw.elapsedTime();
        sw = new Stopwatch();
        sort2(array2);
        double t2 = sw.elapsedTime();
        return new double[]{t1, t2};
    }

    public static void main(String[] args){
//        String[] array = new String[]{"2", "1", "4", "5", "3", "6"};
//        sort(array);
//        assert isSorted(array);

//        double[] array2 = getRandomArray(100, -100.0, 100.0);
//        Double[] arrayD = new Double[array2.length];
//        for(int i = 0; i < arrayD.length; i++)
//            arrayD[i] = array2[i];
//        sort2(arrayD);
//        assert isSorted(arrayD);
//        sortShow(array2);
        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int i = 100; i < 10000; i+=100){
            double[] time = Test(i);
            dp.drawPoint(i, time[0], Color.RED);
            dp.drawPoint(i, time[1], Color.GREEN);
        }
        StdOut.println("end!");
    }
}
