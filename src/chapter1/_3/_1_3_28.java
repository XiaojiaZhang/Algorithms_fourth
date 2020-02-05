package chapter1._3;

public class _1_3_28 {
    private static int max(Node<Integer> node, int max_value){
        if(node == null){
            return max_value;
        }
        else{
            if(node.getItem() > max_value){
                return max(node.getNext(), node.getItem());
            }
            else{
                return max(node.getNext(), max_value);
            }
        }
    }

    public static int max(Node<Integer> node){
        return max(node, 0);
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
