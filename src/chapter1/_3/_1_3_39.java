package chapter1._3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_3_39 {
    public static class RingBuffer<Item>{
        private int first;
        private int last;
        private Item[] buffer;

        //为了区分环形缓冲区满与空两种状态
        //环形缓冲区存在一个无法被有效利用的内存单元，因此实际分配内存大于制定空间一个单位
        public RingBuffer(int capacity){
            buffer = (Item[]) new Object[capacity+1];
        }

        public boolean isEmpty(){
            return first == last;
        }

        public boolean isFull(){
            return size() == buffer.length-1;
        }

        public int size(){
            if(last < first){
                return last - first + buffer.length;
            }
            else{
                return last - first;
            }
        }

        public void enqueue(Item item){
            StdOut.printf("enqueue at %d\n", last);
            buffer[last] = item;
            last = (last+1) % buffer.length;
        }

        public Item dequeue(){
            StdOut.printf("dequeue at %d\n", first);
            Item item = buffer[first];
            first = (first+1) % buffer.length;
            return item;
        }
    }

    public static void main(String[] args){
        RingBuffer<Integer> buffer = new RingBuffer<>(3);
        while (true){
            if(StdRandom.uniform(0, 1.0) > 0.5){
                if(buffer.isFull()){
                    StdOut.println("enqueue failed");
                    break;
                }
                else {
                    int random = StdRandom.uniform(0, 100);
                    StdOut.printf("enqueue:%d\n", random);
                    buffer.enqueue(random);
                }
            }
            else{
                if(buffer.isEmpty()){
                    StdOut.println("dequeue failed");
                    break;
                }
                else{ StdOut.printf("dequeue:%d\n", buffer.dequeue()); }
            }
        }

    }
}
