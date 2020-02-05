package chapter1._3;

public class _1_3_27 {
    public static int max(Node<Integer> head){
        Node<Integer> current = head;
        int max = 0;
        while (current != null){
            if(current.getItem() > max){
                max = current.getItem();
            }
            current = current.getNext();
        }
        return max;
    }

    public static void main(String[] args){
        List<Integer> list = new List<>();
        assert max(list.getHead()) == 0;
        for(int i = 0; i < 10; i++){
            list.insertHead(i);
        }
        assert max(list.getHead()) == 9;
    }
}
