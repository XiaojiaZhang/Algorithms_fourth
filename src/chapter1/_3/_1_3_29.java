package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Deque;

public class _1_3_29 {
    public static class QueueCircularList<Item>{
        private class Node{
            private Item item;
            private Node next;
            public Node(Item item, Node next){
                this.item = item;
                this.next = next;
            }
            public Node(Item item){
                this.item = item;
            }
        }

        private Node first;
        private Node last;
        private int N;

        public boolean isEmpty(){
            return N == 0;
        }

        public int size(){
            return N;
        }

        public void enqueue(Item item){
            if(first == null){
                first = last = new Node(item);
                last.next = first;
            }
            else {
                Node newNode = new Node(item, first);
                last.next = newNode;
                last = newNode;
            }
            N++;
        }

        public Item dequeue(){
            Item item = first.item;
            if(first == last){ //如果当前仅有一个节点
                first = last = null;
            }
            else{
                last.next = first.next;
                item = first.item;
                first = last.next;
            }
            N--;
            return item;
        }
    }

    public static void main(String[] args){
        QueueCircularList<Integer> queue =  new QueueCircularList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assert queue.size() == 4;
        while (!queue.isEmpty()){
            StdOut.println(queue.dequeue());
        }
        assert queue.size() == 0;
    }
}
