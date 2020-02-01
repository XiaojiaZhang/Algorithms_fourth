package chapter1._1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_7 {
    //有循环终止条件可以判断, 此处t应当为t = 9.0/t 的解, 由于t起始值为正,因此t应当为正值,
    //3.0 <= t < 3.001
    public static void _a(){
        double t = 9.0;
        while(Math.abs(t - 9.0/t) > 0.001){
            t = (9.0/t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
    }

    public static void _b(){
        //sum = 1 + 2 + 3 + 999
        //sum = (1+999)*999/2 = 499500
        int sum = 0;
        for(int i=1; i < 1000; i++){
            for(int j=0; j<i; j++){
                sum++;
            }
        }
        StdOut.println(sum);
    }
    public static void _c(){
        int sum =0;
        for(int i=1; i<1000; i*=2){
            for(int j = 0; j < 1000; j++){
                sum++;
            }
        }
        StdOut.println(sum);
    }
    public static void main(String[] args){
        _a();
        _b();
        _c();
    }
}
