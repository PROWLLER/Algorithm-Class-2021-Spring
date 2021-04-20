package day04;

import day03.Knapsack.*;
import tools.AlgorithmTools.*;

import java.util.Map;
import java.util.Set;

public class Demo04 {

    public static void main(String[] args) {
        //BackTrackingKnapsackDemo();
        EightQueensDemo();
    }

    public static void BackTrackingKnapsackDemo(){
        Integer[] value = {20 ,30, 65, 40, 60};
        Integer[] weight = {10, 20, 30, 40, 50};

        Map<Set<Item>, Integer> result = BackTrackingKnapsack.solve(value, weight, 100);
        Set<Set<Item>> keys = result.keySet();
        for(Set<Item> set : keys){
            System.out.print("For item set: {");
            for(Item item : set){
                System.out.print( item.getId() + ", ");
            }
            System.out.println("}, total value is:" + result.get(set));
        }
    }

    public static void EightQueensDemo(){
        Set<Set<Pair<Integer, Integer>>> result = EightQueens.solve(8, 8);
        Integer i = 0;
        for(Set<Pair<Integer, Integer>> re : result){
            i++;
            System.out.println("This is the "+i+" th solution:");
            for(Pair<Integer, Integer> index : re){
                System.out.println("( "+index.i + ", " + index.j + ")");
            }
        }

    }
}
