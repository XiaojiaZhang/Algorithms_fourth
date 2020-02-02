package chapter1._2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class _1_2_1 {
    public static class Point2D{
        private double x, y;
        public Point2D(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double x(){ return x; }

        public double y(){ return y; }

        //极径（极坐标)
        public double r(){
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }

        //极角(极坐标)
        public double theta(){
            double acos = Math.acos(x / r());
            if (y > 0){ return acos; }
            else { return 2*Math.PI - acos; }
        }

        double distTo(Point2D that){
            return Math.sqrt(Math.pow(x - that.x, 2) + Math.pow(y - that.y, 2));
        }

        void draw(){
            StdDraw.point(x, y);
        }
    }


    public static double maxDist(int N){
        Point2D[] points = new Point2D[N];
        for(int i = 0; i < N; i++){
            points[i] = new Point2D(StdRandom.uniform(0.0, 1.0),
                    StdRandom.uniform(0.0, 1.0));
        }
        double max_dist = 0.0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                double cur_dist = points[i].distTo(points[j]);
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
