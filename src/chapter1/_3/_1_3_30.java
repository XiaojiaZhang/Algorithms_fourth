package chapter1._3;

public class _1_3_30 {
    //逆序链表
    public static<Item> void reverseList(List<Item> list){
        //如果链表为空或仅有一个节点，则直接返回
        Node<Item> head = list.getHead();
        if(head == null || head.getNext() == null){
            return;
        }

        Node<Item> current = head.getNext();
        head.setNext(null);
        while (current != null){
            list.insertHead(current.getItem());
            current = current.getNext();
        }
    }

    public static void main(String[] args){
        List<Integer> list = new List<>();
        for(int i = 0; i < 10; i++)
            list.insertHead(i);
        list.display();
        reverseList(list);
        list.display();
    }
}
