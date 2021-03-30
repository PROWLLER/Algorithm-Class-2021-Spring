package day01;

import tools.AlgorithmTools;

public class FindKthLargestNumber {

    public static Comparable getKthLargestNumber(Comparable[] arr1, Comparable[] arr2, int k){
        return getKthLargestNumber(arr1, 0, arr2, 0, k);
    }

    private static Comparable getKthLargestNumber(Comparable[] arr1, int start1, Comparable[] arr2, int start2, int k){
        boolean arr1IsNull = false;
        boolean arr2IsNull = false;
        if(arr1.length <= start1)arr1IsNull = true;
        if(arr2.length <= start2)arr2IsNull = true;
        if(arr1IsNull && arr2IsNull)return null;


        if(k <= 0)return null;

        else if(k == 1){
            if(arr1IsNull)return arr2[start2];
            else if(arr2IsNull)return arr1[start1];
            else{
                if(AlgorithmTools.less(arr1[start1], arr2[start2])){
                    return arr1[start1];
                }
                else return arr2[start2];
            }
        }
        if(arr1IsNull){
            return arr2[start2 + k - 1];
        }
        else if(arr2IsNull){
            return arr1[start1 + k - 1];
        }

        else {
            int middle = k / 2 - 1;
            int middle1 = middle;
            int middle2 = middle;
            if(start1 + middle >= arr1.length){
                middle1 = arr1.length - start1 - 1;
                middle2 = middle;

            }else if(start2 + middle >= arr2.length){
                middle1 = middle;
                middle2 = arr2.length - start2 - 1;
            }


            if(AlgorithmTools.less(arr1[start1 + middle1], arr2[start2 + middle2])){
                if(k - middle1 - 1 == 0)return arr1[start1+middle1];
                return getKthLargestNumber(arr1, start1+middle1+1, arr2, start2, k - middle1 - 1);
            }
            else{
                if(k - middle2 - 1 == 0)return arr1[start2+middle2];
                return getKthLargestNumber(arr1, start1, arr2, start2+middle2+1, k - middle2 - 1);
            }
        }
    }
}
