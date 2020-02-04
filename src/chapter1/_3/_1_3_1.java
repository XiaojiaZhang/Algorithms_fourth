package chapter1._3;

public class _1_3_1 {
    public static class FixedCapacityStackOfStrings{
        private String[] a;
        private int N;
        public FixedCapacityStackOfStrings(int cap){
            a = new String[cap];
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N;
        }
        public void push(String item){
            a[N++] = item;
        }
        public String pop(){
            return a[--N];
        }
        public boolean isFull(){
            return N == a.length;
        }
    }
    public static void main(String[] args){
        FixedCapacityStackOfStrings stackString = new FixedCapacityStackOfStrings(10);
        assert stackString.isEmpty();
        for(int i = 0; i < 10; i++){
            stackString.push(i+"");
        }
        assert stackString.isFull();
    }
}
