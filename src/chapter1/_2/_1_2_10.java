package chapter1._2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class _1_2_10 {
    public static class VisualCounter{
        private int N, max;
        private int num = 0;
        private int count = 0;

        public int getN(){ return N; }

        public int getNum() {return num;}


        public  VisualCounter(int N, int max){
            this.N = N;
            this.max = max;
        }

        //执行加法操作
        public void add(){
            num += 1;
            count += 1;
        }

        //执行减法操作
        public void substract(){
            num -= 1;
            count += 1;
        }

        //判断能否执行加法操作
        public boolean canAdd(){
            return (this.num + 1 <= max && this.count + 1 <= N);
        }

        //判断能否执行减法操作
        public boolean canSubstract(){
            return (this.num - 1 >= -max && this.count + 1 <= N);
        }

        //  初始化绘图板
        private void showInit(){
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(-max, max);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(Color.RED);
        }

        //绘制当前值
        public void showValue(int Num){
            //展示当前总共count个数值
            StdDraw.point(count, Num);
            StdDraw.pause(100); //停留0.1秒
        }
    }

    public static void main(String[] args){
        VisualCounter vs = new VisualCounter(1000, 50);
        vs.showInit();
        //连续循环更新当前值
        while (true){
            double randomValue = StdRandom.uniform(0.0, 1.0);
            //以等概率随机进行加法或减法操作
            if(randomValue > 0.5 && vs.canAdd()){
                vs.add();
                //visualize;
                vs.showValue(vs.getNum());
            }
            else if(randomValue <= 0.5 && vs.canSubstract()){
                vs.substract();
                vs.showValue(vs.getNum());
            }
            else{ //既不可加也不可减, 则终止
                break;
            }
        }
    }
}
