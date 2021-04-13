package day01;

import tools.AlgorithmTools;
/**
 * QuickSort class
 * only have a available static interface and can not be constructed.
 *
 *
 * @author PROWLLER
 * @version 1.0
 * */
public class QuickSort {

    public static int quickSort(Comparable[] arr){
        return quickSort(arr, true);
    }
    /**
     * @param low2high if set true, the result will be from low to high
     *
     *
     * */
    public static int quickSort(Comparable[] arr, boolean low2high) {


        int result = quickSort(arr, 0, arr.length - 1);
        Comparable[] arr2 = new Comparable[arr.length];
        if(low2high){
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr2[arr.length - i - 1];
            }
        }
        return result;

    }
    /**
     * recursive call of quickSort.it sort the array from high to low
     * @param low the low pointer that the part to be sorted.
     * @param high the high pointer that the part to be sorted.
     * @param arr the main array
     *
     *
     *
     *
     * */
    private static int quickSort(Comparable[] arr, int low, int high){

        int originHigh = high;
        int originLow = low;

        if(low >= high || high >= arr.length){
            return 0;
        }
        else if(low == high - 1){
            if(AlgorithmTools.less(arr[low], arr[high])){
                AlgorithmTools.exchange(arr, low, high);
            }
            return 1;
        }
        int compareTimes = 0;

        int middle = low;

        low = low + 1;
        while(low < high){
            if((AlgorithmTools.less(arr[low], arr[middle]))){
                AlgorithmTools.exchange(arr, low, high);
                high --;
            }else{
                low ++;
            }
            compareTimes ++;
            if(low == high)break;
            if(AlgorithmTools.less(arr[middle], arr[high])){
                AlgorithmTools.exchange(arr, low, high);
                low ++;
            }else{
                high --;
            }
            compareTimes ++;
        }

        if(AlgorithmTools.less(arr[middle], arr[high])){
            AlgorithmTools.exchange(arr, middle, high);
            middle = high;
        }
        else{
            AlgorithmTools.exchange(arr, middle, high - 1);
            middle = high - 1;
        }

        compareTimes += quickSort(arr, middle + 1, originHigh);
        compareTimes += quickSort(arr, originLow, middle - 1);

        return compareTimes;

    }

    private QuickSort(){}
}
