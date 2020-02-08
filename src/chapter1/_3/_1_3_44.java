package chapter1._3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class _1_3_44 {
    //使用两个栈实现文本缓冲区,
    //支持:
    // 在光标处插入字符,
    //删除并返回光标位置处的字符
    //将光标向左,向右移动k个位置
    //返回缓冲区中的字符数量
    public static class Buffer{
        private Stack<Character> stack1;
        private Stack<Character> stack2;
        public Buffer(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public int size(){
            return stack1.size() + stack2.size();
        }

        public void insert(char c){
            stack1.push(c);
        }

        public char delete(){
            return stack1.pop();
        }

        public void left(int k){
            while (!stack1.isEmpty() && k > 0){
                stack2.push(stack1.pop());
                k--;
            }
        }

        public void right(int k){
            while (!stack2.isEmpty() && k > 0){
                stack1.push(stack2.pop());
                k--;
            }
        }
    }

    public static void main(String[] args){
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.left(2);
        buffer.insert('d');
        buffer.right(3);
        StdOut.println(buffer.delete());
    }
}
