package chapter1._3;

public class _1_3_21 {

    public static boolean find(Node<String> list, String item){
        Node<String> current = list;
        while (current != null){
            if(current.getItem().equals(item)){
                return true;
            }
            current = current.getNext();
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
