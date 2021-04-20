package day03;

import day01.QuickSort;

import java.util.*;

public class Knapsack {

    public static Integer[] solve(Integer[] value, Integer[] weight, Integer totalWeight, boolean fractional){
        Item[] items = new Item[value.length];

        for (int i = 0; i < value.length; i++) {
            items[i] = new Item(value[i], weight[i], i);
        }

        if(fractional)return fractional(items, totalWeight);
        else return zeroOne(items, totalWeight);
    }

    private static Integer[] fractional(Item[] items, Integer totalWeight){
        //greedy
        QuickSort.quickSort(items, false);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<items.length;i++){
            int weight = items[i].getWeight();
            if(totalWeight - weight > 0){
                list.add(items[i].getId());
                totalWeight -= weight;
            }
            else {
                list.add(items[i].getId());
                break;
            }
        }

        Integer[] result = new Integer[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static Integer[] zeroOne(Item[] items, Integer totalWeight){
        Map<Integer, Integer> valueMemory = new HashMap<>();
        Map<Integer, Set<Integer>> pathMemory = new HashMap<>();
        zeroOne(items, totalWeight, valueMemory, pathMemory);

        Set<Integer> path = pathMemory.get(totalWeight);
        Integer[] result = new Integer[path.size()];
        int indexTemp = 0;
        for(Integer obj : path){
            result[indexTemp] = obj;
            indexTemp++;
        }
        return result;
    }

    private static Integer zeroOne(Item[] items,
                                   Integer totalWeight,
                                   Map<Integer, Integer> valueMemory,
                                   Map<Integer, Set<Integer>> pathMemory){
        //dp
        if(valueMemory.containsKey(totalWeight)){
            return valueMemory.get(totalWeight);
        }
        ArrayList<Integer> available = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if(items[i].getWeight() <= totalWeight){
                available.add(i);
            }
        }
        if(available.size() == 0){
            valueMemory.put(totalWeight, 0);
            pathMemory.put(totalWeight, new HashSet<>());
            return 0;
        }

        Integer maxValue = -1;
        Integer maxIndex = -1;
        for(Integer ava : available){


            int value = items[ava].getValue() +
                    zeroOne(items, totalWeight - items[ava].getWeight(), valueMemory, pathMemory);
            //run and find
            Set<Integer> path = pathMemory.get(totalWeight - items[ava].getWeight());
            if(path.contains(ava))continue;

            if(value > maxValue){
                maxValue = value;
                maxIndex = ava;
            }
        }

        valueMemory.put(totalWeight, maxValue);

        Set<Integer> newPath = new HashSet<>(pathMemory.get(totalWeight - items[maxIndex].getWeight()));
        newPath.add(maxIndex);
        pathMemory.put(totalWeight, newPath);
        return maxValue;



    }

    public static class Item implements Comparable{
        private Integer value;
        private Integer weight;
        private Double valuePerWeight;
        private Integer id;
        public Item(Integer value, Integer weight, Integer id){
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double)value / (double)weight;
            this.id = id;

        }

        public Double getValuePerWeight() {
            return valuePerWeight;
        }

        public Integer getValue() {
            return value;
        }

        public Integer getWeight() {
            return weight;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public int compareTo(Object o) {
            Item item = (Item)o;
            Double result = this.valuePerWeight - item.valuePerWeight;
            if(result == 0)return 0;
            else if(result > 0)return 1;
            else return -1;
        }

        @Override
        public int hashCode() {
            return value << 20 + weight*3 << 6 + id;

        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Item)){
                return false;
            }

            Item item = (Item)obj;
            if(this.id == item.getId()
            && this.weight == item.getWeight()
            && this.value == item.getValue())return true;

            return false;
        }
    }
}
