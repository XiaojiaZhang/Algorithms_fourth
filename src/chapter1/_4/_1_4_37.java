package chapter1._4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;

public class _1_4_37 {
    public static class FixedCapacityStack<Item>{
        private Item[] array;
        public int N;
        public FixedCapacityStack(int capacity){
            assert capacity > 0;
            array = (Item[]) new Object[capacity];
        }

        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N;
        }
        public void push(Item item){
            array[N++] = item;
        }
        public Item pop(){
            return array[--N];
        }
    }

    public static class FixedCapacityStackOfInts{
        private int[] array;
        public int N;
        public FixedCapacityStackOfInts(int capacity){
            assert capacity > 0;
            array = new int[capacity];
        }

        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N;
        }
        public void push(int item){
            array[N++] = item;
        }
        public int pop(){
            return array[--N];
        }
    }

    //连续进行N次push操作,返回所需时间,
    //time[0]为对泛型数组进行push操作所需时间,涉及装箱拆箱操作
    //time[1]不涉及装箱拆箱操作
    public static double[] TestPush(int N){
        FixedCapacityStack<Integer> stack1 = new FixedCapacityStack<>(N);
        FixedCapacityStackOfInts stack2 = new FixedCapacityStackOfInts(N);
        double[] time = new double[2];
        Stopwatch sw = new Stopwatch();
        for(int i = 0; i < N; i++){
            stack1.push(i);
        }
        time[0] = sw.elapsedTime();
        sw = new Stopwatch();
        for(int i = 0; i < N; i++){
            stack2.push(i);
        }
        time[1] = sw.elapsedTime();
        return time;
    }

    public static void main(String[] args){
        DrawPoint dw = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int N = 100; N < 100000000; N*=2){
            double[] time = TestPush(N);
            StdOut.printf("%7d: 1:%3.3f\t2:%3.3f\n", N, time[0], time[1]);
            dw.drawPoint(N, time[0], Color.RED);
            dw.drawPoint(N, time[1], Color.GREEN);
        }
        StdOut.println("end!");
    }
}
