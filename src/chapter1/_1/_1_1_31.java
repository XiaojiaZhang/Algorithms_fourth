package chapter1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class _1_1_31 {
    public static void drawCircle(int N, double p){
        double center_x = 0.5;
        double center_y = 0.5;
        double radius = 0.3;
        double interval = 2*Math.PI/ N;
        StdDraw.circle(center_x, center_y, radius);
        //绘制小圆
        double[][] loc = new double[N][2];

        for(int i = 0; i < N; i++){
            double x_next = center_x + Math.sin(interval*i)*radius;
            double y_next = center_y + Math.cos(interval*i)*radius;
            loc[i][0] = x_next;
            loc[i][1] = y_next;
            StdDraw.circle(x_next, y_next, 0.05);
        }

        StdDraw.setPenColor(Color.GRAY);
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(StdRandom.uniform(0.0, 1.0) < p){
                    StdDraw.line(loc[i][0], loc[i][1],
                            loc[j][0], loc[j][1]);
                }
            }
        }
    }

    public static void main(String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        drawCircle(Integer.parseInt(args[0]), Double.parseDouble(args[1]));
    }
}
