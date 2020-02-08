package chapter1._4;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.FastInfosetReader;
import edu.princeton.cs.algs4.StdOut;

public class _1_4_10 {
    public static <Item extends Comparable<Item>>  int BinarySearchMin(Item[] array, int low,
                                             int high, Item key){
        if(low >= high){
            return -1;
        }
        else {
            int mid = low + (high - low) / 2;
            if(array[mid].equals(key)){
                int left_find = BinarySearchMin(array, low, mid, key);
                if(left_find != -1){
                    return left_find;
                }
                else{
                    return mid;
                }
            }
            else if(array[mid].compareTo(key) < 0){
                return BinarySearchMin(array, mid+1, high, key);
            }
            else {
                return BinarySearchMin(array, low, mid, key);
            }
        }
    }

    public static void main(String[] args){
        String[] array = new String[]{"a", "b", "b", "c", "d"};
        StdOut.println(BinarySearchMin(array, 0, array.length, "b"));
    }
}
