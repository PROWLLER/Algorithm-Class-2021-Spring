package day02;

import java.util.*;
import tools.AlgorithmTools.Pair;
/**
 * To solve the matrixMinCalTimes
 * @author PROWLLER
 * */
public class MatrixChainProduct {
    public static Integer calMatrixChain(int[] chain){
        Map<IntPair, Integer> memory = new HashMap<IntPair, Integer>();
        return calMatrixChain(chain, 1, chain.length - 1, memory);
    }

    private static Integer calMatrixChain(int[] chain, int low, int high, Map<IntPair, Integer> memory){
        if(low >= high){
            return 0;
        }

        if(memory.containsKey(new IntPair(low, high))){
            return memory.get(new IntPair(low, high));
        }

        if(high == low+1){
            int result = chain[low-1]*chain[high-1]*chain[high];
            memory.put(new IntPair(low, high), result);
            return result;
        }

        int min = Integer.MAX_VALUE;
        for (int k = low; k <= high - 1; k++) {
            int kCost = Integer.MAX_VALUE;

            int leftCost = calMatrixChain(chain, low, k, memory);
            int rightCost = calMatrixChain(chain, k+1, high, memory);

            kCost = leftCost + rightCost + chain[low - 1] * chain[high] * chain[k];
            min = Math.min(kCost, min);
        }

        memory.put(new IntPair(low, high), min);
        return min;
    }

    private static class IntPair{
        public int i;
        public int j;
        public IntPair(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return i  << 15 + j;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof IntPair)){
                return false;
            }

            IntPair pair = (IntPair)obj;

            if(this.i == pair.i && this.j == pair.j)return true;

            return false;
        }
    }
}
