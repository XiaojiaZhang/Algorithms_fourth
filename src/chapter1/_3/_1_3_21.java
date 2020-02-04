package chapter1._3;

public class _1_3_21 {
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

    public static boolean find(Node<String> list, String item){
        Node<String> current = list;
        while (current != null){
            if(current.item.equals(item)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args){
        Node<String> a = new Node<>("Hello");
        Node<String> b = new Node<>("world", a);
        Node<String> c = new Node<>("I'm", b);
        Node<String> d = new Node<>("coming", c);
        assert find(d, "world");
        assert !find(d, "country");
    }
}
