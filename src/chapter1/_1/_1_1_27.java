package chapter1._1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_27 {
    public static class Counter{
        private long num = 0;
        public void count(){
            num++;
        }
        public long getCount(){
            return num;
        }
    }

    public static double binomial(int N, int k, double p, Counter count){
        count.count();
        if(N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;
        return (1.0-p) * binomial(N-1, k, p, count) +
                p * binomial(N-1, k-1, p, count);
    }

    private static void displayArray(double[][] res){
        StdOut.println("----------------------------");
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                StdOut.printf("%.5f ", res[i][j]);
            }
            StdOut.println();
        }
        StdOut.println("----------------------------");
    }

    public static double binomialDynamiclPlanning(int N, int k, double p,
                                                  double[][] res){
        if(N == 0 && k == 0){
            res[N][k] = 1.0;
            return res[N][k];
        }
        else if(N < 0 || k < 0){
            return 0.0;
        }
        else {
            if(res[N][k] == -1){
                res[N][k] = (1.0-p) * binomialDynamiclPlanning(N-1, k, p, res) +
                        p*binomialDynamiclPlanning(N-1, k-1, p, res);
            }
            return res[N][k];
        }
    }

    public static void main(String[] args){
//        Counter count = new Counter();
//        binomial(30, 15, 0.25, count);
//        StdOut.printf("binomial(100, 50, 0.25): %d\n", count.getCount());
        int N = 5;
        int k = 1;
        double p = 0.85;
        double[][] res = new double[N+1][k+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < k+1; j++){
                res[i][j] = -1;
            }
        }
        double prob = binomialDynamiclPlanning(N, k, p, res);
        StdOut.printf("binomial(%d, %d, %f): is %f\n", N, k, p, prob);

    }
}
