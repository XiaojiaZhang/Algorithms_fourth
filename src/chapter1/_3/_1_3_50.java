package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class _1_3_50 {
    public static class Stack<Item> implements Iterable<Item>{
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
        private Node first;
        private int pushNum;
        private int popNum;
        private int num;

        public boolean isEmpty(){
            return num == 0;
        }

        public int size(){
            return num;
        }

        public void push(Item item){
            first = new Node(item, first);
            pushNum++;
            num++;
        }

        public Item pop(){
            Item item = first.item;
            first = first.next;
            popNum++;
            num--;
            return item;
        }

        @Override
        public StackIterator iterator() {
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item>{
            private int numPushIterator;
            private int numPopIterator;
            private Node current;

            public StackIterator(){
                numPushIterator = pushNum;
                numPopIterator = popNum;
                current = first;
            }

            @Override
            public boolean hasNext() {
                if(popNum != numPopIterator || pushNum != numPushIterator){
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public Item next() {
                if(popNum != numPopIterator || pushNum != numPushIterator){
                    throw new ConcurrentModificationException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() { }
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for(int i: stack){
            stack.pop();
            StdOut.print(stack.size());
        }
    }
}
