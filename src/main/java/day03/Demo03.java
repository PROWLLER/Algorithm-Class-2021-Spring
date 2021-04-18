package day03;

public class Demo03 {

    public static void main(String[] args) {
        KnapsackDemo();
    }

    public static void KnapsackDemo(){
        Integer[] value = {20, 30, 65, 40, 60, 80};
        Integer[] weight = {30, 20, 30, 40, 50, 10};
        Integer[] a1 = Knapsack.solve(value, weight, 100, true);
        Integer[] a2 = Knapsack.solve(value, weight, 100, false);
        System.out.println();
    }
}
