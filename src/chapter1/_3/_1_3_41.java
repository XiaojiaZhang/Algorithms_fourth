package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_41 {
    public static class QueueList<Item>{
        private class Node{
            private Item item;
            private Node next;
            public Node(Item item){
                this.item = item;
            }
            public Node(Item item, Node next){
                this.item = item;
                this.next = next;
            }
        }
        private int N;
        private Node first;
        private Node last;

        private Node copyList(Node node){
            if(node == null){
                return null;
            }
            else{
                return new Node(node.item, node.next);
            }
        }

        public QueueList(){}

        public QueueList(QueueList<Item> queue){
            this.N = queue.N;
            this.first = copyList(queue.first);
            if(this.first == null){
                this.last = null;
            }
            else{
                Node current = this.first;
                while (current.next != null){
                    current = current.next;
                }
                this.last = current;
            }
        }

        public int size(){
            return N;
        }
        public boolean isEmtpy(){
            return N == 0;
        }

        public void enqueue(Item item){
            if(first == null){
                first =  last = new Node(item);
            }
            else{
                Node newNode = new Node(item);
                last.next = newNode;
                last = newNode;
            }
            N++;
        }

        //调用者调用时应当保证队列不为空
        public Item dequeue(){
            Item item = first.item;
            first = first.next;
            if(first == null) //如果出队后队列为空，则last也被置为null
                last = null;
            N--;
            return item;
        }
    }

    public static void main(String[] args){
        QueueList<Integer> queue = new QueueList<>();
        for(int i = 0; i < 10; i++)
            queue.enqueue(i);
        QueueList<Integer> queue2 = new QueueList<>(queue);

        while (!queue.isEmtpy())
            queue.dequeue();

        for(int i = 9; i >= 0; i-- )
            queue2.enqueue(i);

        while (!queue2.isEmtpy()){
            StdOut.printf("%d\t", queue2.dequeue());
        }
        StdOut.println();
    }
}
