package day01;

import tools.AlgorithmTools;

public class Demo01 {

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 6, 7};
        Integer[] b = {5, 9, 10};
        for(int i=0;i<9;i++)
        System.out.println(FindKthLargestNumber.getKthLargestNumber(a, b, i + 1));



    }


}
