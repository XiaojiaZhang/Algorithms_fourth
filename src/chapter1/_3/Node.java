package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node(Item item){
        this.item = item;
    }
    public Node(Item item, Node<Item> next){
        this.item = item;
        this.next = next;
    }

    public Node<Item> getNext(){
        return next;
    }

    public void setNext(Node<Item> next){
        this.next = next;
    }

    public Item getItem(){
        return item;
    }

    public void display(){
        Node<Item> current = this;
        while (current != null){
            StdOut.print(current.item);
            if(current.next != null){
                StdOut.print("->");
            }
            current = current.next;
        }
        StdOut.println();
    }
}
