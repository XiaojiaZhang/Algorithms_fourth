package chapter1._3;

public class _1_3_7 {
    public static class Stack<Item>{
        private Node first;
        private int N;
        private class Node {
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
            Node oldfirst = first;
            first = new Node(item, oldfirst);
            N++;
        }
        public Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public Item peek(){
            return first.item;
        }
    }

}
