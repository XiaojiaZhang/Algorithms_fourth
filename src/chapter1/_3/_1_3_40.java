package chapter1._3;

import edu.princeton.cs.algs4.StdIn;

public class _1_3_40 {
    public static void moveToFront(DoubleNodeList<Character> list){
        while (!StdIn.isEmpty()){
            char c = StdIn.readChar();
            if(list.find(c) != null){
                list.deleteNode(list.find(c));
            }
            list.insertHead(c);
        }
    }

    public static  void main(String[] args){
        DoubleNodeList<Character> list = new DoubleNodeList<>();
        moveToFront(list);
    }
}
