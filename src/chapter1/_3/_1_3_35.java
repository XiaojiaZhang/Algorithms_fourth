package chapter1._3;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.print.PrinterGraphics;
import java.util.Iterator;

public class _1_3_35 {
    public static class RandomQueue<Item> implements Iterable<Item>{
        private int first;
        private int last;
        private Item[] array;
        public RandomQueue(int capacity){
            array = (Item[]) new Object[capacity];
        }
        public RandomQueue(){
            array = (Item[]) new Object[5];
        }

        public int capacity(){
            return array.length;
        }

        public int size(){
            return last - first;
        }

        public boolean isEmtpy(){
            return first == last;
        }

        public boolean isFull(){
            return last-first == array.length;
        }

        public void resize(int new_length){
            assert new_length >= last-first;
            Item[] newArray = (Item[]) new Object[new_length];
            System.arraycopy(array, first, newArray, 0, last-first);
            array = newArray;
            last -= first;
            first = 0;
        }

        public void enqueue(Item item){
            if(isFull()){
                resize(array.length * 2);
            }
            array[last++] = item;
        }

        public Item dequeue(){
            int randomIndex = StdRandom.uniform(first, last);

            Item tmp = array[last-1];
            array[last-1] = array[randomIndex];
            array[randomIndex] = tmp;

            last--;
            Item item = array[last];

            if(size() < array.length / 4){
                resize(array.length / 2);
            }
            return item;
        }

        public Item sample(){
            return array[StdRandom.uniform(first, last)];
        }

        @Override
        public Iterator<Item> iterator() {
            return new RandomQueueIterator();
        }

        private class RandomQueueIterator implements Iterator<Item>{
            private int currentIndex;
            private Item[] arrayCopy;

            private void shuffle(){
                for(int i = 0; i < arrayCopy.length; i++){
                    int index = StdRandom.uniform(i, arrayCopy.length);
                    Item tmp = arrayCopy[i];
                    arrayCopy[i] = arrayCopy[index];
                    arrayCopy[index] = tmp;
                }
            }

            public RandomQueueIterator(){
                arrayCopy = (Item[]) new Object[size()];
                System.arraycopy(array, first, arrayCopy, 0, size());
                shuffle();
            }

            @Override
            public Item next() {
                return arrayCopy[currentIndex++];
            }

            @Override
            public boolean hasNext() {
                return currentIndex < arrayCopy.length;
            }

            @Override
            public void remove() { }
        }
    }

    private static class Card{
        public static enum Shape {heart, circle, square, flower};
        private int num;
        private Shape shape;
        public Card(int num, Shape shape){
            this.num = num;
            this.shape = shape;
        }
    }

    public static void main(String[] args){
//        RandomQueue<Card> queue = new RandomQueue<>();
//        for(int i = 1;  i < 14; i++){
//            for(Card.Shape s:Card.Shape.values()){
//                queue.enqueue(new Card(i, s));
//            }
//        }
//        while (!queue.isEmtpy()){
//            Card card = queue.dequeue();
//            StdOut.println(card.num);
//            StdOut.println(card.shape);
//        }
        RandomQueue<Integer> queue = new RandomQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
        }

        for(int i:queue){
            StdOut.println(i);
        }
    }
}
