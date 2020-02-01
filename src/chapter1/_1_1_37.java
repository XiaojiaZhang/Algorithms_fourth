package chapter1;

import edu.princeton.cs.algs4.StdRandom;

public class _1_1_37 {

    public static void shuffle(int [] a){
        int N = a.length;
        for(int i=0; i < N; i++){
            int r = StdRandom.uniform(N);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    public static double[][] shuffleTest(int arrayLength, int N){
        int[] a = new int[arrayLength];
        double[][] res = new double[a.length][a.length];
        for(int i = 0; i < N; i++){
            _1_1_36.initArray(a); //初始化
            shuffle(a); //打乱数组
            //统计结果
            for(int j = 0; j < a.length; j++){
                res[a[j]][j] += 1;
            }
        }
        return res;
    }

    public static void main(String[] args){

        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        double[][] res = shuffleTest(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
        _1_1_36.displayArray(res);
    }
}
