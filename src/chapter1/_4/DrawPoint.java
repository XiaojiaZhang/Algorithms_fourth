package chapter1._4;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.LinkedList;

public class DrawPoint {
    private class Point{
        private double x, y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private double minX, maxX, minY, maxY; //当前所有点中最小X, 最大X, 最小Y, 最大Y
    private LinkedList<Point> points;
    private boolean scaleChange; //用于纪录添加纪录点后,是否需要调整比例

    public DrawPoint(){
        points = new LinkedList<>();
        scaleChange = false;
    }

    private Point scalePoint(Point p){
        double p_x, p_y;
        if(maxX == minX){
            p_x = 0;
        }
        else{
            p_x = (p.x - minX) / (maxX - minX) * 0.8 + 0.1;
        }
        if(maxY == minY){
            p_y = 0;
        }
        else{
            p_y = (p.y - minY) / (maxY - minY) * 0.8 + 0.1;
        }
        return new Point(p_x, p_y);
    }

    private void drawAllPoints(){
        Point scale_point;
        for(Point p:points){
            scale_point = scalePoint(p);
            StdDraw.point(scale_point.x, scale_point.y);
        }
    }

    public void drawPoint(double x, double y){
        points.add(new Point(x, y)); //添加位置点
        if(x > maxX) {
            maxX = x;
            scaleChange = true;
        }
        if(x < minX){
            minX = x;
            scaleChange = true;
        }
        if(y > maxY){
            maxY = y;
            scaleChange = true;
        }
        if(y < minY){
            minY = y;
            scaleChange = true;
        }

        if(!scaleChange){ //直接绘制当前点
            Point scale_point = scalePoint(new Point(x, y));
            StdDraw.point(scale_point.x, scale_point.y);
        }
        else{//由于比例调整,重新绘制所有点
            StdDraw.clear();
            drawAllPoints();
        }
    }

    public static void main(String[] args){
        DrawPoint p = new DrawPoint();
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.005);
        for(int x = 0; x < 100; x++){
            StdDraw.pause(500);
            p.drawPoint(x, x*x);
        }
    }
}
