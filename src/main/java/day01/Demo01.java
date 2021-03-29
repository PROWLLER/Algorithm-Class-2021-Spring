package day01;

import tools.AlgorithmTools;

public class Demo01 {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 6, 9, 10, 0, -3, 2, 3, 9, 1};

        System.out.println(QuickSort.quickSort(arr));

        for(int i : arr){
            System.out.print(" " + i);
        }



    }


}
