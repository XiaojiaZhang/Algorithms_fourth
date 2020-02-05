package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_25 {
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        public Node(Item item){
            this.item = item;
        }
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }

    private static <Item> void display(Node<Item> node){
        Node<Item> current = node;
        while (current != null){
            StdOut.print(current.item);
            if(current.next != null){
                StdOut.print("->");
            }
            current = current.next;
        }
        StdOut.println();
    }

    //将insertNode插入链表list节点insertedBefore之后
    //如果insertedBefore不在链表list中,则不做任何事情
    //如果insertNode为空，则不做任何事情
    public static <Item> void insertAfter(Node<Item> list,
                                          Node<Item> insertedBefore,
                                          Node<Item> insertNode){
        Node<Item> current = list;
        while (current != null && current != insertedBefore){
            current = current.next;
        }
        if(current != null && insertNode != null){
            insertNode.next = current.next;
            current.next = insertNode;
        }
    }

    public static void main(String[] args){
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2, a);
        Node<Integer> c = new Node<>(3, b);
        Node<Integer> d = new Node<>(4, c);
        Node<Integer> e = new Node<>(999);
        Node<Integer> f = new Node<>(-999);
        display(d);
        insertAfter(d, c, e);
        display(d);
    }
}
