package chapter1._4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class _1_4_12 {
    public static int numIntersect(int[] array1, int[] array2){
        int count = 0;
        int j= 0;
        for(int i = 0; i < array1.length; i++){
            for(; j < array2.length; j++){
                if(array1[i] < array2[j]){ //array2[j..]中不存在与array1[i]相等的元素
                    break;
                }
                else if(array1[i] == array2[j]){
                    StdOut.println(array1[i]);
                    count++;
                }
                //如果array1[i] > array2[j], 则检查下一个array2[j+1]
            }
        }
        return count;
    }

    private static double Test(int N){
        int[] array = new int[N];
        int[] array2 = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = StdRandom.uniform(0, 100);
            array[2] = StdRandom.uniform(0, 100);
        }
        Arrays.sort(array);
        Arrays.sort(array2);
        Stopwatch watch = new Stopwatch();
        numIntersect(array, array2);
        return watch.elapsedTime();
    }

    public static void main(String[] args){
        DrawPoint dp = new DrawPoint();
//        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.01);
        for(int N = 100; N < 100000; N+=1000){
            dp.drawPoint(N, Test(N), Color.RED);
        }
        StdOut.println("end!");
    }
}
