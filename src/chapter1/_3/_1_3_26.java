package chapter1._3;

public class _1_3_26 {

    public static void remove(List<String> list, String key){
        Node<String> prev = list.getHead();
        Node<String> current = list.getHead();
        while (current != null){
            if(!current.getItem().equals(key)){
                prev = current;
                current = current.getNext();
            }
            else{
                if(current == list.getHead()){
                    list.setHead(current.getNext());
                }
                else{
                    prev.setNext(current.getNext());
                    current = prev.getNext();
                }
            }
        }
    }

    public static void main(String[] args){
        List<String> list = new List<>();
        list.insertHead("hello");
        list.insertHead("world");
        list.insertHead("hello");
        list.insertHead("my");
        list.insertHead("hello");
        list.display();
        remove(list, "hello");
        list.display();
    }
}
