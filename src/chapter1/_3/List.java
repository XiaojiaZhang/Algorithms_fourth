package chapter1._3;


public class List<Item> {
    private Node<Item> head;
    public List(){}
    public List(Node<Item> first){
        head = first;
    }

    public Node<Item> getHead(){
        return head;
    }

    public void setHead(Node<Item> head){
        this.head = head;
    }

    //头部插入节点
    public void insertHead(Item item){
        head = new Node<>(item, head);
    }

    public void display(){
        head.display();
    }
}
