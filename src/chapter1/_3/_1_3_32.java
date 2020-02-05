package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_32 {
    //SteQue API设计
    public interface SteQue<Item>{
        public boolean isEmpty();
        public int size();
        public void push(Item item);
        public Item pop();
        public void enqueue(Item item);
    }

    public static class StequeList<Item> implements SteQue<Item>{
        Node<Item> first, last;
        int N;
        public boolean isEmpty(){ return N == 0;}

        public int size(){ return N; }

        //链表头部插入
        public void push(Item item){
            if(first == null){
                first = last = new Node<>(item);
            }
            else{
                first = new Node<>(item, first);
            }
            N++;
        }

        //链表尾部插入
        public void enqueue(Item item){
            if(last == null){
                first = last = new Node<>(item);
            }
            else{
                last.setNext(new Node<>(item));
                last = last.getNext();
            }
            N++;
        }

        //链表头部删除
        public Item pop(){
            if(isEmpty()){
                throw new IllegalArgumentException();
            }
            Item item = first.getItem();
            first = first.getNext();
            N--;
            return item;
        }
    }
    public static void main(String[] args){
        SteQue<Integer> steque = new StequeList<>();
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
                steque.push(i);
            }
            else{
                steque.enqueue(i);
            }
        }
        while (!steque.isEmpty()){
            StdOut.println(steque.pop());
        }
    }
}
