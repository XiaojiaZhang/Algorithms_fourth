package chapter1._3;

import chapter1._2._1_2_13;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _1_3_16 {
    public static _1_2_13.Date[] readDates(){
        Queue<_1_2_13.Date> queue = new Queue<>();
        while (!StdIn.isEmpty()){
            String date = StdIn.readString();
            queue.enqueue(new _1_2_13.Date(date));
        }
        _1_2_13.Date[] array = new _1_2_13.Date[queue.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = queue.dequeue();
        }
        return array;
    }

    public static void main(String[] args){
        _1_2_13.Date[] array = readDates();
        for(_1_2_13.Date d: array){
            StdOut.println(d);
        }
    }
}
