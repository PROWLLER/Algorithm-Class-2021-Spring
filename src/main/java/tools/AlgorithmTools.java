package tools;

import day02.MatrixChainProduct;

import java.util.ArrayList;

public class AlgorithmTools {

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static boolean equal(Comparable a, Comparable b){
        return a.compareTo(b) == 0;
    }

    public static boolean larger(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    public static void exchange(Comparable[] arr, int a, int b) throws IndexOutOfBoundsException{
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void exchange(ArrayList arrayList, int a, int b) throws IndexOutOfBoundsException{
        Object temp = arrayList.get(a);
        arrayList.set(a, arrayList.get(b));
        arrayList.set(b, temp);
    }

    public static class Pair<K1, K2>{
        public K1 i;
        public K2 j;
        public Pair(){

        }

        public Pair(K1 i, K2 j){
            this.i = i;
            this.j = j;

        }

        @Override
        public int hashCode() {
            return i.hashCode() << 15 + j.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Pair)){
                return false;
            }

            Pair pair = (Pair)obj;

            if(this.i.equals(pair.i) && this.j.equals(pair.j))return true;

            return false;
        }
    }
}
