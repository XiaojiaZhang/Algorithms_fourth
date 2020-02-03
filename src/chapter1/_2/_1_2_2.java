package chapter1._2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _1_2_2 {
    public static class Interval1D{
        private double lo, hi;
        public Interval1D(double lo, double hi){
            if(lo > hi){
                throw new IllegalArgumentException();
            }

            this.lo = lo;
            this.hi = hi;
        }

        public double length(){
            return hi-lo;
        }

        public boolean contains(double x){
            return (x >= lo && x < hi);
        }

        public boolean intersect(Interval1D that){
            return !(hi <= that.lo || that.hi <= lo);
        }

        public void draw(){
            StdDraw.line(lo, 0, hi, 0);
        }

        public String toString(){
            return lo + "..." + hi;
        }
    }

    public static void printIntersectInterval(int N){
        Interval1D[] intervals = new Interval1D[N];
        for(int i=0; i<N; i++){
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(intervals[i].intersect(intervals[j])){
                    StdOut.print(intervals[i] + "\t" + intervals[j] + "\n");
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
