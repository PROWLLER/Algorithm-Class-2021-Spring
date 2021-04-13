package day01;

public class FindSumOf2ElementEqualToX {

    public static boolean find(Integer[] arr, Integer target){
        QuickSort.quickSort(arr);

        int low = 0;
        int high = arr.length - 1;
        if(arr.length < 2)return false;

        while(low < high){
            if(arr[low] + arr[high] < target){
                high--;
            }
            else if(arr[low] + arr[high] > target){
                low ++;
            }
            else if(arr[low] + arr[high] == target){
                return true;
            }
        }
        return false;


    }
}
