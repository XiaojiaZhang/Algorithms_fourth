package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class _1_3_12 {
    public static class Stack<Item> implements Iterable<Item>{
        private Node first;
        private int N;
        private class Node{
            Item item;
            Node next;
            public Node(Item item, Node next){
                this.item = item;
                this.next = next;
            }
            public Node(Item item){
                this.item = item;
            }
        }

        public boolean isEmpty(){
            return first == null;
        }

        public int size(){
            return N;
        }

        public void push(Item item){
            if(isEmpty()){
                first = new Node(item);
            }
            else{
                first = new Node(item, first);
            }
            N++;
        }

        public Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item>{
            private Node current = first;
            public boolean hasNext(){
                return current != null;
            }

            public void remove(){}
            public Item next(){
                Item item = current.item;
                current = current.next;
                return item;
            }

        }
    }

    //注意，如果Item是可变引用类型，则此复制方法仅复制类Item的引用，属于浅复制方法
    public static Stack<String> copy(Stack<String> stackSrc){
        Stack<String> stackDest = new Stack<>();
        for(String str: stackSrc){
            stackDest.push(str);
        }
        return stackDest;
    }

    public static void main(String[] args){
        Stack<String> stackSrc = new Stack<>();
        stackSrc.push("hello");
        stackSrc.push("world");
        Stack<String> stackDest = copy(stackSrc);
        while(!stackDest.isEmpty()){
            StdOut.println(stackDest.pop());
        }
        assert !stackSrc.isEmpty();
    }
}
