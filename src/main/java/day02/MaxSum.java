package day02;
import tools.AlgorithmTools.Pair;

import java.util.HashMap;
import java.util.Map;
/**
 * To find maximum of sum in a arr
 * for example:
 * arr: 1, 3, 10, -2, 3, -9, 2
 * the maximum will be found between (0, 4) = 1+3+10-2+3
 *
 *
 * @author PROWLLER
 * */
public class MaxSum {
    /**
     *
     * @param pair the number in pair will be changed to the index where the maximum can be found
     * @return return the maximum
     *
     * */
    public static Integer solve(int[] arr, Pair<Integer, Integer> pair){
        Map<Pair<Integer, Integer>, Integer> memory = new HashMap<Pair<Integer, Integer>, Integer>();
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> memory2 =
                new HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>>();

        Pair<Pair<Integer, Integer>, Integer> result = findMaxSum(arr, 0, arr.length-1, memory, memory2);
        pair.i = result.i.i;
        pair.j = result.i.j;
        return result.j;
    }

    public static Integer solve(int[] arr){
        return solve(arr, new Pair<>(0,0));
    }

    private static Pair<Pair<Integer, Integer>, Integer> findMaxSum(int[] arr,
                                                                    int low,
                                                                    int high,
                                                                    Map<Pair<Integer, Integer>, Integer> memory,
                                                                    Map<Pair<Integer, Integer>, Pair<Integer, Integer>> memory2){
        if(memory.containsKey(new Pair<>(low, high))){
            int amount = memory.get(new Pair<>(low, high));
            Pair<Integer, Integer> index = memory2.get(new Pair<>(low, high));
            return new Pair<>(index, amount);
        }

        if(low >= high){
            return new Pair<>(new Pair<>(high, high), arr[high]);
        }

        Pair<Pair<Integer, Integer>, Integer> pair = findMaxSum(arr, low+1, high-1, memory, memory2);
        int left = 0;
        int right = 0;
        int middle = pair.j;
        int total = 0;
        for(int i=low;i<=pair.i.j;i++){
            left += arr[i];
        }
        for (int i = pair.i.i; i <= high; i++) {
            right += arr[i];
        }
        for(int i=low;i<=high;i++){
            total += arr[i];
        }
        if(left >= right && left >= middle && left >=total){
            memory.put(new Pair<>(low, high), left);
            memory2.put(new Pair<>(low, high), new Pair<>(low, pair.i.j));
            return new Pair<>(new Pair<>(low, pair.i.j), left);
        }
        else if(right >= left && right >= middle && right >=total){
            memory.put(new Pair<>(low, high), right);
            memory2.put(new Pair<>(low, high), new Pair<>(pair.i.i, high));
            return new Pair<>(new Pair<>(pair.i.i, high), right);
        }
        else if(total >= left && total >= right && total >= middle){
            memory.put(new Pair<>(low, high), total);
            memory2.put(new Pair<>(low, high), new Pair<>(low, high));
            return new Pair<>(new Pair<>(low, high), total);
        }
        else{
            memory.put(new Pair<>(low, high), middle);
            memory2.put(new Pair<>(low, high), new Pair<>(pair.i.i, pair.i.j));
            return new Pair<>(new Pair<>(pair.i.i, pair.i.j), middle);
        }
    }
}
