package tools;

import java.util.ArrayList;

public class AlgorithmTools {

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
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
}
