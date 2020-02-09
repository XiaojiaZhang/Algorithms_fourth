package Chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class DrawArray {
    public static double[] getMinMax(double[] a){
        double min = a[0];
        double max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
            if(a[i] < min){
                min = a[i];
            }
        }
        return new double[]{min, max};
    }

    public static void drawArray(double[] array, double min, double max){
        //计算每一条形的宽度
        double width = (0.9-0.1) / array.length;
        double unitHeight = (0.9-0.1) / (max-min);
        //确定０值对应的y值
        double zero = 0.1 + (0 - min) / (max-min) * 0.8;

        for(int i = 0; i < array.length; i++){
            double x = 0.1 + (2*i+1) / 2.0 * width;
            double y = zero + array[i] / 2 * unitHeight;
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.rectangle(x, y, width/2, Math.abs(array[i]/2 * unitHeight));
            StdDraw.setPenColor(Color.GRAY);
            StdDraw.filledRectangle(x, y, width/2, Math.abs(array[i]/2 * unitHeight));
        }
    }
}
