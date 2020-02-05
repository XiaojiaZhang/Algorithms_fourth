package chapter1._3;


public class _1_3_25 {
    //将insertNode插入链表list节点insertedBefore之后
    //如果insertedBefore不在链表list中,则不做任何事情
    //如果insertNode为空，则不做任何事情
    public static <Item> void insertAfter(Node<Item> list,
                                          Node<Item> insertedBefore,
                                          Node<Item> insertNode){
        Node<Item> current = list;
        while (current != null && current != insertedBefore){
            current = current.getNext();
        }
        if(current != null && insertNode != null){
            insertNode.setNext(current.getNext());
            current.setNext(insertNode);
        }
    }

    public static void main(String[] args){
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2, a);
        Node<Integer> c = new Node<>(3, b);
        Node<Integer> d = new Node<>(4, c);
        Node<Integer> e = new Node<>(999);
        Node<Integer> f = new Node<>(-999);
        d.display();
        insertAfter(d, c, e);
        d.display();
    }
}
