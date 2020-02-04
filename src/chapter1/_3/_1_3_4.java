package chapter1._3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _1_3_4 {
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
    }

    public static boolean isParentheses(){
        Stack<Character> stack = new Stack<>();
        while(!StdIn.isEmpty()){
            char c = StdIn.readChar();
            if(c == '[' || c == '{' || c == '('){ //左括号入栈
                stack.push(c);
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
            else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            else {
                //读入不支持的字符
                throw new IllegalArgumentException();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        boolean isparent = isParentheses();
        StdOut.println(isparent);
    }
}
