package Chapter2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ArraySort {
    public static void sort(Comparable[] a){
        throw new NotImplementedException();
    }

    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
}
