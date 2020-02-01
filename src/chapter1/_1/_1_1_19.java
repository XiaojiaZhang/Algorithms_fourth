package chapter1._1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_19 {
    public static long fibnacci(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            long[] array = new long[N + 1];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < N + 1; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array[N];
        }
    }

    public static void main(String[] args){
        int i = 10;
        StdOut.println("Fibonacci 10: " + fibnacci(10));
    }
}
