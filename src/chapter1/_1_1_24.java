package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_24 {
    public static int gcd(int M, int N){
        StdOut.printf("%d\t%d\n", M, N);
        if(M%N == 0){
            return N;
        }
        else {
            return gcd(N, M%N);
        }
    }

    public static void main(String[] args){
        if(args.length != 2)
            throw new IllegalArgumentException();
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        StdOut.printf("the gcd of %d, %d is: %d", M, N, gcd(M, N));
    }
}
