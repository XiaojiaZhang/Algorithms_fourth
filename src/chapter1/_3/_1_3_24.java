package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_24 {
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
        Node<Item> cur = node;
        while(cur != null){
            StdOut.print(cur.item);
            if(cur.next != null){
                StdOut.print("->");
            }
            cur = cur.next;
        }
        StdOut.println();

    }

    public static <Item>  void removeAfter(Node<Item> node, Node<Item> removedBefore){
        Node<Item> cur = node;
        while (cur != null && cur != removedBefore){
            cur = cur.next;
        }

        if(cur != null && cur.next != null){
            cur.next = cur.next.next;
        }
    }

    public static void main(String[] args){
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2, a);
        Node<Integer> c = new Node<>(3, b);
        Node<Integer> d = new Node<>(4, c);
        Node<Integer> e = new Node<>(5);
        display(d);
        removeAfter(d, e);
        display(d);
    }
}
