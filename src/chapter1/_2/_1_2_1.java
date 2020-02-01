package chapter1._2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_2_1 {
    private static double distPoints(double[] a, double[] b){
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static double maxDist(int N){
        double[][] points = new double[N][2];
        for(int i = 0; i < N; i++){
            points[i][0] = StdRandom.uniform(0.0, 1.0);
            points[i][1] = StdRandom.uniform(0.0, 1.0);
        }
        double max_dist = 0.0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                double cur_dist = distPoints(points[i], points[j]);
                if(cur_dist > max_dist){
                    max_dist = cur_dist;
                }
            }
        }
        return max_dist;
    }

    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        int num = Integer.parseInt(args[0]);
        StdOut.printf("the max distance of two points is %.3f", maxDist(num));
    }
}
