package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_14 {
    public static class ResizingArrayQueueOfStrings {
        private int capacity;
        private int first, last;
        private String[] array;

        public ResizingArrayQueueOfStrings() {
            capacity = 10;
            array = new String[capacity];
        }

        public ResizingArrayQueueOfStrings(int capacity) {
            assert capacity > 0;
            this.capacity = capacity;
            array = new String[capacity];
        }

        public int size() {
            return last - first;
        }

        public boolean isEmpty() {
            return first == last;
        }

        public boolean isFull() {
            return last == capacity;
        }

        //调整数组大小
        public void resize(int max) {
            String[] newArray = new String[max];
            assert last - first <= max; //调整后的数组足以容纳当前所有元素
            for (int i = 0; i < size(); i++) {
                newArray[i] = array[first+i];
            }
            array = newArray;
            capacity = max;
            //更新first, last
            int N = last - first;
            first = 0;
            last = first + N;
        }

        public void enqueue(String s) {
            if (isFull()) {
                resize(capacity * 2);
            }
            array[last++] = s;
        }

        public String dequeue() {
            String s = array[first++];
            if (last-first < capacity / 4) {
                resize(capacity / 2);
            }
            return s;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(2);
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        queue.enqueue("ccc");
        queue.enqueue("ddd");
        queue.enqueue("eee");
        while (!queue.isEmpty()){
            StdOut.println(queue.dequeue());
        }
    }
}