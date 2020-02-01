package chapter1._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.NoSuchElementException;

public class _1_1_32 {
    //从标准输入流中读取数据
    //统计落入每一分段的个数
    public static int[] histogram(int N, double l, double r){
        int[] hist = new int[N];
        //初始化
        for(int i = 0; i < N; i++)
            hist[i] = 0;

        double interval = (r-l) / N;
        double current;
        while (true){
            try{
                current = StdIn.readDouble();
                //判断当前值落入哪一区间
                for(int i = 0; i < N; i++){
                    if(current >= l + i*interval &&
                            current < l + (i+1) * interval){
                        hist[i] += 1;
                        break;
                    }
                }
            }
            catch (NoSuchElementException e){
                break;
            }
        }
        return hist;
    }

    //绘制直方图
    public static void drawHistogram(int[] array){
        double width = 1;
        double height = 1;
        StdDraw.setPenColor(Color.RED);
        //计算每一直方的宽度
        double w = width / 1.2 / array.length;
        //计算每一直方的单位高度
        int max_height = 0;
        for(int i=0; i<array.length; i++){
            if(max_height < array[i])
                max_height = array[i];
        }
        double h = height / 1.2 / max_height;

        //绘制直方图
        double leftCornerX = 0.1 * width;
        double leftCornerY = 0.1 * height;

        for(int i = 0; i < array.length; i++){
            //确定当前条形的中心点
            double x = leftCornerX + (i+0.5)*w;
            double y = leftCornerY + array[i]*h/2;
            StdDraw.setPenColor(Color.GRAY);
            StdDraw.filledRectangle(x, y,
                    w/2, array[i]*h/2);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.rectangle(x, y, w/2, array[i]*h/2);
        }
    }

    public static void main(String[] args){
        if(args.length != 3){
            throw new IllegalArgumentException();
        }

        int[] hist = histogram(Integer.parseInt(args[0]),
                Double.parseDouble(args[1]), Double.parseDouble(args[2]));

        drawHistogram(hist);
    }
}
