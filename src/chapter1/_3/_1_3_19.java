package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_19 {
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
        public Node(Item item){
            this.item = item;
        }

    }

    public static class List<Item>{
        private Node<Item> head;
        //在头部插入
        public void insertHead(Item item){
            head = new Node<>(item, head);
        }

        public Item deleteTail(){
            if(head == null){
                throw new IllegalArgumentException();
            }
            Node<Item> prev = head;
            Node<Item> current = head.next;
            if(current == null){
                Item item = prev.item;
                head = null;
                return item;
            }
            else{
                while (current.next != null){
                    prev = current;
                    current = current.next;
                }
                Item item = prev.item;
                prev.next = null;
                return item;
            }
        }

        public void display(){
            Node<Item> current = head;
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

    public static void main(String[] args){
        List<Integer> list = new List<>();
        list.insertHead(5);
        list.insertHead(4);
        list.insertHead(3);
        list.insertHead(2);
        list.insertHead(1);
        list.display();
        list.deleteTail();
        list.display();
    }

}
