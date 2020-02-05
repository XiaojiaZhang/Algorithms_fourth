package chapter1._3;


public class _1_3_24 {

    public static <Item>  void removeAfter(Node<Item> node, Node<Item> removedBefore){
        Node<Item> cur = node;
        while (cur != null && cur != removedBefore){
            cur = cur.getNext();
        }

        if(cur != null && cur.getNext()!= null){
            cur.setNext(cur.getNext().getNext());
        }
    }

    public static void main(String[] args){
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2, a);
        Node<Integer> c = new Node<>(3, b);
        Node<Integer> d = new Node<>(4, c);
        Node<Integer> e = new Node<>(5);
        d.display();
        removeAfter(d, b);
        d.display();
    }
}
