package chapter1._3;

import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _1_3_15 {
    public static void printLastKString(int K){
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        while (!StdIn.isEmpty()){
            queue.enqueue(StdIn.readString());
        }
        assert queue.size() >= K;
        for(int i = 0; i < queue.size()-K; i++)
            queue.dequeue();
        StdOut.println(queue.dequeue());
    }
    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        printLastKString(Integer.parseInt(args[0]));
    }
}
