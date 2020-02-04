package chapter1._3;

import edu.princeton.cs.algs4.StdOut;

public class _1_3_20 {
    public static class List<Item>{
        private Node head;
        private class Node{
            Item item;
            Node next;
            public Node(Item item){
                this.item = item;
            }
            public Node(Item item, Node next){
                this.item = item;
                this.next = next;
            }
        }

        public void insertHead(Item item){
            head = new Node(item, head);
        }

        public Item deleteKth(int k){
            Node cur = head;
            Node prev = cur; //初始化值无意义
            for(int i = 0; i < k-1; i++){
                if(cur.next == null){ //长度不足Ｋ
                    throw new IllegalArgumentException();
                }
                prev = cur;
                cur = cur.next;
            }

            if(cur == null){
                throw new IllegalArgumentException();
            }

            Item item = cur.item;
            if(cur == head){ //移除第一个元素
                head = head.next;
            }
            else{
                prev.next = cur.next;
            }
            return item;
        }

        private  void display(){
            Node current = head;
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
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertHead(4);
        list.display();
        list.deleteKth(1);
        list.display();
    }


}
