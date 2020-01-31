package chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.security.InvalidParameterException;

public class _1_1_20 {
    public static double recur_log_N_factorial(int N){
        if (N < 1){
            throw new InvalidParameterException();
        }
        if(N == 1){
            return 0;
        }
        else{
            return Math.log(N) + recur_log_N_factorial(N-1);
        }
    }

    public static void main(String[] args){
        int N = 10;
        StdOut.println("ln(10!): " + recur_log_N_factorial(N));
    }
}
