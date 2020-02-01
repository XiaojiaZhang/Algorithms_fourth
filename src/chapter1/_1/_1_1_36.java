package chapter1._1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_1_36 {
    public static void shuffle(int [] a){
        int N = a.length;
        for(int i=0; i < N; i++){
            int r = i + StdRandom.uniform(N-i);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    public static void initArray(int[] array){
        for(int i = 0; i < array.length; i++)
            array[i] = i;
    }

    public static double[][] shuffleTest(int arrayLength, int N){
        int[] a = new int[arrayLength];
        double[][] res = new double[a.length][a.length];
        for(int i = 0; i < N; i++){
            initArray(a); //初始化
            shuffle(a); //打乱数组
            //统计结果
            for(int j = 0; j < a.length; j++){
                res[a[j]][j] += 1;
            }
        }
        return res;
    }

    public static void displayArray(double[][] res){
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                StdOut.printf("%.3f\t", res[i][j]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        double[][] res = shuffleTest(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        displayArray(res);
    }
}
