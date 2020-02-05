package chapter1._3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class _1_3_34 {
    public static class RandomBag<Item> implements Iterable<Item>{
        private Item[] array;
        private int N;
        public RandomBag(int cap){
             array = (Item[]) new Object[cap];
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public int size(){
            return N;
        }

        public void add(Item item){
            if(N == array.length){
                throw new IllegalArgumentException();
            }
            array[N++] = item;
        }

        private class iteratorBag implements Iterator<Item>{
            private int current;

            //不能同时有两个同时进行的迭代器
            private void shuffleArray(Object[] array){
                for(int i = 0; i < N; i++){
                    int r = StdRandom.uniform(i, N);
                    Object tmp = array[i];
                    array[i] = array[r];
                    array[r] = tmp;
                }
            }

            public iteratorBag(){
                shuffleArray(array);
            }
            @Override
            public void remove() { }

            @Override
            public boolean hasNext() {
                return current != N;
            }

            @Override
            public Item next() {
                return array[current++];
            }
        }

        @Override
        public Iterator<Item> iterator() {
            return new iteratorBag();
        }
    }

    public static void main(String[] args){
        RandomBag<Integer> bag = new RandomBag<>(10);
        for(int i = 0; i < 10; i++){
            bag.add(i);
        }
        for(int i: bag){
            StdOut.println(i);
        }
        for(int i: bag){
            StdOut.println(i);
        }
    }
}
