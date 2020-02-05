package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Objects;

public class _1_3_33 {
    public interface Deque<Item>{
        public boolean isEmpty();
        public int size();
        public void pushLeft(Item item);
        public void pushRight(Item item);
        public Item popLeft();
        public Item popRight();
    }

    public static class DequeList<Item> implements Deque<Item>, Iterable<Item>{
        private class Node{
            private Item item;
            private Node prev;
            private Node next;
            public Node(Item item){
                this.item = item;
            }
            public Node(Item item, Node prev, Node next){
                this.item = item;
                this.prev = prev;
                this.next = next;
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
        public void pushLeft(Item item){
            if(first == null){
                first = last = new Node(item);
            }
            else{
                first.prev = new Node(item, null, first);
                first = first.prev;
            }
            N++;
        }
        public void pushRight(Item item){
            if(last == null){
                first = last = new Node(item);
            }
            else{
                last.next = new Node(item, last, null);
                last = last.next;
            }
            N++;
        }
        public Item popLeft(){
            if(isEmpty()){
                throw new IllegalArgumentException();
            }
            else{
                Item item = first.item;
                first = first.next;
                first.prev = null;
                N--;
                return item;
            }

        }
        public Item popRight(){
            if(isEmpty()){
                throw new IllegalArgumentException();
            }
            else{
                Item item = last.item;
                last = last.prev;
                last.next = null;
                N--;
                return item;
            }
        }

        private class iteratorDeque implements Iterator<Item>{
            private Node current = first;
            public void remove(){}

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        public Iterator<Item> iterator(){
            return new iteratorDeque();
        }
    }

    public static class ResizingArrayDeque<Item> implements Deque<Item>, Iterable<Item>{
        private int first;
        private int last;
        private Item[] array;

        public ResizingArrayDeque(int cap){
            array = (Item[]) new Object[cap];
        }

        public ResizingArrayDeque(){
            array = (Item[]) new Object[10];
        }

        public boolean isEmpty(){
            return first == last;
        }

        public int size(){
            return last - first;
        }

        private boolean isFull(){
            return last - first == array.length;
        }

        //右移一格
        private void moveToRight(){
            System.arraycopy(array, 0, array, 1, size());
            first++;
            last++;
        }

        private void Resize(){
            Item[] newArray = (Item[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            first = 0;
            last = array.length;
            array = newArray;
        }

        public void pushLeft(Item item){
            if(isFull()){
                Resize();
            }
            if(first == 0){
                moveToRight();
            }
            array[--first] = item;
        }

        public void pushRight(Item item){
            if(isFull()){
                Resize();
            }
            array[last++] = item;
        }

        public Item popLeft(){
            return array[first++];
        }

        public Item popRight(){
            return array[--last];
        }

        @Override
        public Iterator<Item> iterator() {
            return new iteratorArrayDeque();
        }

        private class iteratorArrayDeque implements Iterator<Item>{
            private int current_index = first;
            @Override
            public void remove() { }

            @Override
            public boolean hasNext() {
                return current_index != last;
            }

            @Override
            public Item next() {
                Item item = array[current_index];
                current_index++;
                return item;
            }
        }
    }

    public static void main(String[] args){
//        DequeList<Integer> deque = new DequeList<>();
//        for(int i = 0; i < 10; i++){
//            if(i % 2 == 0){
//                deque.pushRight(i);
//            }
//            else{
//                deque.pushLeft(i);
//            }
//        }
//
//        deque.popRight();
//        for(int i: deque){
//            StdOut.println(i);
//        }
//
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>(3);
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
                deque.pushRight(i);
            }
            else{
                deque.pushLeft(i);
            }
        }
        deque.popLeft();
        deque.popRight();
        for(int i: deque){
            StdOut.println(i);
        }
    }
}
