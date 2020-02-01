package chapter1._2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _1_2_2 {
    private static boolean isIntersected(double[] a, double[] b){
        assert a[0] <= a[1];
        assert b[0] <= b[1];
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }

    public static void printIntersectInterval(int N){
        double[][] intervals = new double[N][2];
        for(int i=0; i<N; i++){
            intervals[i][0] = StdIn.readDouble();
            intervals[i][1] = StdIn.readDouble();
        }
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(isIntersected(intervals[i], intervals[j])){
                    StdOut.printf("%f...%f\t%f...%f\n",
                            intervals[i][0], intervals[i][1],
                            intervals[j][0], intervals[j][1]);
                }
            }
        }
    }

    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        printIntersectInterval(Integer.parseInt(args[0]));
    }
}
