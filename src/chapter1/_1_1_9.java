package chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.security.InvalidParameterException;

public class _1_1_9 {
    public static void main(String[] args){
        if(args.length != 1){
            throw new InvalidParameterException();
        }
        StringBuilder s = new StringBuilder();
        int N = Integer.parseInt(args[0]);
        for(int n = N; n > 0; n /= 2){
            s.append(n % 2);
        }
        StdOut.println(s);
    }
}
