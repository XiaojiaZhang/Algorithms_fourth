package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_42 {
    public static class StackList<Item>{
        private class _Node{
            private Item item;
            private _Node next;
            public _Node(Item item){
                this.item = item;
            }
            public _Node(Item item, _Node next){
                this.item = item;
                this.next = next;
            }
        }
        private int N;
        private _Node first;

        //复制链表
        private _Node copyList(_Node node){
            if(node == null){
                return null;
            }
            else{
                return new _Node(node.item, copyList(node.next));
            }
        }

        public StackList(){}

        public StackList(StackList<Item> s){
            this.first = copyList(s.first);
            this.N = s.N;
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public int size(){
            return N;
        }

        public void push(Item item){
            first = new _Node(item, first);
            N++;
        }

        public Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }

    public static void main(String[] args){
        StackList<Integer> stack = new StackList<>();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        StackList<Integer> stack2 = new StackList<>(stack);
        while (!stack.isEmpty()){
            stack.pop();
            stack2.pop();
        }
    }
}
