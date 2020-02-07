package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class DoubleNodeList <Item>{
    private class Node{
        private Item item;
        private Node prev;
        private Node next;
        public Node(Item item){
            this.item = item;
        }
        public Node(Item item, Node prev, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private int N;

    public void display(){
        Node current = head;
        while (current != null){
            if(current.prev != null){
                StdOut.print("<-");
            }
            StdOut.print(current.item);
            if(current.next != null){
                StdOut.print("->");
            }
            current = current.next;
        }
        StdOut.println();
    }

    public void insertHead(Item item){
        Node newNode = new Node(item, null, head);
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
        N++;
    }

    public Node find(Item item){
        Node current = head;
        while (current != null){
            if(current.item.equals(item)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteNode(Node node){
        if(node.prev == null){//头节点
            this.head = this.head.next;
            if(this.head != null){
                this.head.prev = null;
            }
        }
        else if(node.next == null){//尾节点
            node.prev.next = null;
        }
        else{
            //对于普通节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        N--;
    }
}
