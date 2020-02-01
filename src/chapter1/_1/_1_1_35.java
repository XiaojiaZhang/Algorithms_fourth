package chapter1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_1_35 {
    //模拟一次掷骰子获得的点数
    private static int getRandom(){
            return StdRandom.uniform(1, 7);
    }

    //模拟一次掷两个骰子点数之和
    public static int getRandomSum(){
        return getRandom() + getRandom();
    }

    private static void displayProbArray(double[] simu, double[] theo){
        StdOut.printf("Simulation:\tTheoretical:\n");
        for(int i =0; i <simu.length; i++){
            StdOut.printf("%d: %.4f\t%.4f\n", i, simu[i], theo[i]);
        }
    }

    //连续掷N次，计算两个骰子点数之和, 计算各点数之和出现概率
    public static double[] theoretical(){
        double[] dist = new double[13];
        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 7; j++){
                dist[i+j] += 1.0 / 36;
            }
        }
        return dist;
    }

    public static double[] simulate(int N){
        double[] dist = new double[13];
        for(int i=0; i < 13; i++)
            dist[i] = 0;

        for(int i=0; i < N; i++){
            dist[getRandomSum()] += 1.0/N;
        }
        return dist;
    }



    public static void main(String[] args){
        displayProbArray(simulate(8000000), theoretical());
    }
}
