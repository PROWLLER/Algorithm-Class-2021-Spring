package day01;

import tools.AlgorithmTools;

public class Demo01 {

    public static void main(String[] args) {
        QuickSortDemo();
        FindKthLargestNumberDemo();
    }

    public static void FindSumOf2ElementEqualToXDemo(){
        System.out.println("*******************");
        System.out.println("FindSumOf2ElementEqualToXDemo");
        Integer[] c = {1, 2, 5, 4, 6, 7};
        System.out.println("对数组：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("查找和为5计算结果为");
        System.out.println(FindSumOf2ElementEqualToX.find(c, 5));
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void PriorityQueueDemo(){
        System.out.println("*******************");
        System.out.println("PriorityQueueDemo");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.push(10);
        queue.push(100);
        queue.push(20);
        queue.push(-1);
        System.out.println(queue.top());
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void QuickSortDemo(){
        System.out.println("*******************");
        System.out.println("QuickSortDemo");
        Integer[] c = {1, 2, 5, 4, 6, 7, 0};

        System.out.println("对数组：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println("排序结果为");
        QuickSort.quickSort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void FindKthLargestNumberDemo(){
        System.out.println("*******************");
        System.out.println("FindKthLargestNumberDemo");
        Integer[] c1={5, 6, -1, 5, 4, -7};
        Integer[] c2={10, 3, 15, 12, 7, 2};
        int k = 3;
        QuickSort.quickSort(c1, true);
        QuickSort.quickSort(c2, true);
        System.out.println("数组1：");
        for (int i = 0; i < c1.length; i++) {
            System.out.print(c1[i] + " ");
        }
        System.out.println();
        System.out.println("数组2：");
        for (int i = 0; i < c2.length; i++) {
            System.out.print(c2[i] + " ");
        }
        System.out.println();
        System.out.println("k=" + k);
        System.out.println("结果为:");
        System.out.println(FindKthLargestNumber.getKthLargestNumber(c1, c2, k));
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }


}
