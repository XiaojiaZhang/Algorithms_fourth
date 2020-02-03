package chapter1._2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_2_3 {
    public static class Interval2D{
        private _1_2_2.Interval1D width;
        private _1_2_2.Interval1D height;
        private _1_2_1.Point2D leftBottom(){
            return new _1_2_1.Point2D(width.getLo(), height.getLo());
        }

        private _1_2_1.Point2D rightBottom(){
            return new _1_2_1.Point2D(width.getHi(), height.getLo());
        }

        private _1_2_1.Point2D leftTop(){
            return new _1_2_1.Point2D(width.getLo(), height.getHi());
        }

        private _1_2_1.Point2D rightTop(){
            return new _1_2_1.Point2D(width.getHi(), height.getHi());
        }

        public Interval2D(_1_2_2.Interval1D x, _1_2_2.Interval1D y){
            width = x;
            height = y;
        }

        public double area(){
            return width.length() * height.length();
        }

        public boolean contains(_1_2_1.Point2D p){
            return width.contains(p.x()) && height.contains(p.y());
        }

        //如果第一个矩形与第二个矩形相交，则至少有一个角点位于第二个矩形内
        public boolean intersect(Interval2D that){
            boolean thisIntersetThat = (that.contains(leftBottom()) ||
                    that.contains(leftTop()) || that.contains(rightBottom()) ||
                    that.contains(rightTop()));
            boolean thatIntersetThis = (this.contains(that.leftBottom()) ||
                    this.contains(that.leftTop()) || this.contains(that.rightBottom()) ||
                    this.contains(that.rightTop()));
            return thisIntersetThat || thatIntersetThis;
        }

        public boolean contains(Interval2D that){
            boolean thatContainsThis = (that.contains(leftBottom()) &&
                    that.contains(leftTop()) && that.contains(rightBottom()) &&
                    that.contains(rightTop()));
            boolean thisContainsThat = (this.contains(that.leftBottom()) &&
                    this.contains(that.leftTop()) && this.contains(that.rightBottom()) &&
                    this.contains(that.rightTop()));
            return  thisContainsThat || thatContainsThis;
        }

        public void draw(){
            StdDraw.rectangle(width.getLo() + width.length()/2,
                    height.getLo()+height.length()/2,
                    width.length()/2, height.length()/2);
        }
    }

    public static void main(String[] args){
        //从命令行接受参数N, min, max, 生成Ｎ个随机的2D间隔，　其宽和高均匀分布在
        //单位正方形中的min, max之间
        //用StdDraw画出他们并打印出仙剑的间隔对的数量, 以及有包含关系的间隔对数量
        if(args.length != 3){
            throw new IllegalArgumentException();
        }
        Interval2D[] intervals = new Interval2D[Integer.parseInt(args[0])];
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        assert min < max;
        for(int i = 0; i <intervals.length; i++){
            _1_2_2.Interval1D width, height;
            double w1 = StdRandom.uniform(min, max);
            double w2 = StdRandom.uniform(min, max);
            while(true){
                if(w1 < w2){
                    width = new _1_2_2.Interval1D(w1, w2);
                    break;
                }
                else if(w2 < w1){
                    width = new _1_2_2.Interval1D(w2, w1);
                    break;
                }
            }
            double h1 = StdRandom.uniform(min, max);
            double h2 = StdRandom.uniform(min, max);
            while(true){
                if(h1 < h2){
                    height = new _1_2_2.Interval1D(h1, h2);
                    break;
                }
                else if(h2 < h1){
                    height = new _1_2_2.Interval1D(h2, h1);
                    break;
                }
            }
            intervals[i] = new _1_2_3.Interval2D(width, height);
            intervals[i].draw();
        }
        int intersect = 0;
        int contains = 0;
        for(int i = 0; i < intervals.length; i++){
            for(int j = i+1; j < intervals.length; j++){
                if(intervals[i].intersect(intervals[j])){
                    intersect += 1;
                }
                if(intervals[i].contains(intervals[j])){
                    contains += 1;
                }
            }
        }
        StdOut.printf("intersect: %d\n", intersect);
        StdOut.printf("contain: %d", contains);
    }
}
