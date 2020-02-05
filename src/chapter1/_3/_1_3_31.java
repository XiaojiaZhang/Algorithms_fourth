package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_31 {
    public static class doubleNodeList<Item>{
        private class doubleNode{
            private Item item;
            private doubleNode prev;
            private doubleNode next;
            public doubleNode(Item item){
                this.item = item;
            }
            public doubleNode(Item item, doubleNode prev, doubleNode next){
                this.item = item;
                this.prev = prev;
                this.next = next;
            }
        }

        private doubleNode first;
        private doubleNode last;
        private int N;

        public boolean isEmpty(){
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void insertHead(Item item){
            if(first == null){
                first = last = new doubleNode(item);
            }
            else {
                doubleNode newNode = new doubleNode(item, null, first);
                first.prev = newNode;
                first = newNode;
            }
            N++;
        }

        public void insertTail(Item item){
            if(first == null){
                first = last = new doubleNode(item);
            }
            else {
                doubleNode newNode = new doubleNode(item, last, null);
                last.next = newNode;
                last = newNode;
            }
            N++;
        }

        public Item deleteHead(){
            if(isEmpty()){
                throw new IllegalArgumentException("空链表!");
            }

            Item item = first.item;
            if(first == last){
                first = last = null;
            }
            else{
                first = first.next;
                first.prev = null;
            }
            N--;
            return item;
        }

        public Item deleteTail(){
            if(isEmpty()){
                throw new IllegalArgumentException("空链表");
            }
            Item item = last.item;
            if(first == last){
                first = last = null;
            }
            else{
                last = last.prev;
                last.next = null;
            }
            N--;
            return item;
        }

        public void insertBefore(doubleNode node, Item item){
            if(node == null){
                throw new IllegalArgumentException();
            }
            doubleNode newNode = new doubleNode(item, node.prev, node);
            if(newNode.prev == null){
                first = newNode;
            }
            else{
                newNode.prev.next = newNode;
            }
            newNode.next.prev = newNode;
        }

        public void insertAfter(doubleNode node, Item item){
            if(node == null){
                throw new IllegalArgumentException();
            }
            doubleNode newNode = new doubleNode(item, node, node.next);
            if(node.next == null){
                last = newNode;
            }
            else{
                newNode.next.prev = newNode;
            }
            newNode.prev.next = newNode;
        }

        public void deleteNode(doubleNode node){
            if(node == first){
                deleteHead();
            }
            else if(node == last){
                deleteTail();
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        public void display(){
            doubleNode current = first;
            while (current != null){
                if(current.prev != null){
                    StdOut.print("<-");
                }
                StdOut.print(current.item);
                if(current.next != null){
                    StdOut.print("->");
                }
                current = current.next;
            }
            StdOut.println();
        }
    }

    public static void main(String[] args){
        doubleNodeList<Integer> list = new doubleNodeList<>();
        for(int i = 0; i < 10; i++){
            list.insertHead(i);
        }
        list.display();
        list.deleteHead();
        list.display();
        list.deleteTail();
        list.display();
        list.insertBefore(list.first, 999);
        list.display();
        list.insertAfter(list.last, 999);
        list.display();
        list.deleteNode(list.first);
        list.deleteNode(list.last);
        list.display();
        list.deleteNode(list.last.prev);
        list.display();



    }
}
