package day04;
import day03.Knapsack.Item;

import java.util.*;

public class BackTrackingKnapsack {
    public static Map<Set<Item>, Integer> solve(Integer[] value, Integer[] weight, Integer totalWeight){
        Set<Item> items = new HashSet<>();
        for (int i = 0; i < value.length; i++) {
            items.add(new Item(value[i], weight[i], i));
        }

        Map<Set<Item>, Integer> memory = new HashMap<>();
        backTrack(items, totalWeight, new HashSet<>(), memory);
        return memory;
    }

    private static void backTrack(Set<Item> itemsLeft,
                                  Integer weightLeft,
                                  Set<Item> itemsGot,
                                  Map<Set<Item>, Integer> memory){
        if(memory.containsKey(itemsGot)){
            return;
        }

        boolean minimized = true;
        for(Item item : itemsLeft){
            if(weightLeft >= item.getWeight()){
                minimized = false;// Not minimized.

                Set<Item> left = new HashSet<>();
                Set<Item> got = new HashSet<>();
                Integer weight = weightLeft - item.getWeight();

                left.addAll(itemsLeft);
                left.remove(item);
                got.addAll(itemsGot);
                got.add(item);

                backTrack(left, weight, got, memory);
            }
        }

        if(minimized){
            Integer totalValue = 0;
            for(Item item : itemsGot){
                totalValue += item.getValue();
            }
            memory.put(itemsGot, totalValue);
        }
    }
}
