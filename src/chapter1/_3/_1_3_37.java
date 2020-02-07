package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_37 {
    public static class Node<Item>{
        private Item item;
        private Node<Item> next;
        public Node(Item item){
            this.item = item;
        }
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }

    public static class circularQueue<Item>{
        private Node<Item> first;
        private Node<Item> last;
        private int N;

        public int size(){
            return N;
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public void enqueue(Item item){
            if(first == null){
                first =  last = new Node<>(item);
                first.next = first;
            }
            else{
                Node<Item> newNode = new Node<>(item, first);
                last.next = newNode;
                last = newNode;
            }
            N++;
        }

        public Item dequeue(){
            Item item = first.item;
            if(first == last){
                first = last = null;
            }
            else{
                first = first.next;
                last.next = first;
            }
            N--;
            return item;
        }

        //调用者确保当前节点不为空
        public void delete(Node node){
            Node current = first;

            Node prev = first;
            while (current != null && current != node){
                prev = current;
                current = current.next;
            }

            if(current == first){
                dequeue();
            }
            else{
                prev.next = current.next;
                N--;
            }
        }
    }

    public static void Josephus(int N, int M){
        circularQueue<Integer> queue = new circularQueue<>();
        for(int i = 0; i < N; i++){
            queue.enqueue(i);
        }
        Node<Integer> current = queue.first;
        while (!queue.isEmpty()){
            for(int i = 0; i < M-1; i++){
                current = current.next;
            }
            StdOut.println(current.item);
            queue.delete(current);
            current = current.next;
        }
    }
    public static void main(String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        Josephus(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
