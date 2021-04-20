package day03;
import day02.Graph.*;
import day02.Graph;
import tools.AlgorithmTools.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo03 {

    public static void main(String[] args) {
        //KnapsackDemo();
        //SchedulingDemo();
        SingleSourceShortestPathDemo();
        //AllPairsShortestPathDemo();
    }

    public static void KnapsackDemo(){
        Integer[] value = {20, 30, 65, 40, 60, 80};
        Integer[] weight = {30, 20, 30, 40, 50, 10};
        System.out.println("*******************");
        System.out.println("KnapsackDemo");
        Integer[] a1 = Knapsack.solve(value, weight, 100, true);
        Integer[] a2 = Knapsack.solve(value, weight, 100, false);
        System.out.println("value:");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println();
        System.out.println("weight:");
        for (int i = 0; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
        System.out.println();
        System.out.println("fractional:");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        System.out.println("0-1:");
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println();
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void SchedulingDemo(){
        Integer[] a = {15, 8, 3, 10};
        Integer[] re = SchedulingProblem.solve(a);
        System.out.println("*******************");
        System.out.println("SchedulingDemo");
        System.out.println("a:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("result:");
        for (int i = 0; i < re.length; i++) {
            System.out.print(re[i] + " ");
        }
        System.out.println();
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void SingleSourceShortestPathDemo(){
        System.out.println("*******************");
        System.out.println("SingleSourceShortestPathDemo");
        Node[] nodes = new Node[5];
        nodes[0] = new Node("A");
        nodes[1] = new Node("B");
        nodes[2] = new Node("C");
        nodes[3] = new Node("D");
        nodes[4] = new Node("E");
        Edge[] edges = new Edge[8];
        edges[0] = new Edge(nodes[0], nodes[1], -1);
        edges[1] = new Edge(nodes[0], nodes[2], 3);
        edges[2] = new Edge(nodes[1], nodes[2], 3);
        edges[3] = new Edge(nodes[1], nodes[3], 2);
        edges[4] = new Edge(nodes[1], nodes[4], 2);
        edges[5] = new Edge(nodes[3], nodes[1], 1);
        edges[6] = new Edge(nodes[3], nodes[2], 5);
        edges[7] = new Edge(nodes[4], nodes[3], -3);

        Graph graph = new Graph(nodes, edges);
        Node source = nodes[0];
        Node target = nodes[3];
        Node[] path = SingleSourceShortestPath.solve(graph, source, target);
        System.out.println("Path for " + source +"->"+target+" :");
        for (int i = 0; i < path.length; i++) {
            System.out.print("->" + path[i]);
        }
        System.out.println();
        System.out.println("*******************");
        System.out.println();
        System.out.println();

    }

    public static void AllPairsShortestPathDemo(){
        System.out.println("*******************");
        System.out.println("AllPairsShortestPathDemo");
        Node[] nodes = new Node[5];
        nodes[0] = new Node("A");
        nodes[1] = new Node("B");
        nodes[2] = new Node("C");
        nodes[3] = new Node("D");
        nodes[4] = new Node("E");
        Edge[] edges = new Edge[8];
        edges[0] = new Edge(nodes[0], nodes[1], -1);
        edges[1] = new Edge(nodes[0], nodes[2], 3);
        edges[2] = new Edge(nodes[1], nodes[2], 3);
        edges[3] = new Edge(nodes[1], nodes[3], 2);
        edges[4] = new Edge(nodes[1], nodes[4], 2);
        edges[5] = new Edge(nodes[3], nodes[1], 1);
        edges[6] = new Edge(nodes[3], nodes[2], 5);
        edges[7] = new Edge(nodes[4], nodes[3], -3);

        Graph graph = new Graph(nodes, edges);

        Map<Pair<Node, Node>, List<Node>> paths = AllPairsShortestPath.solve(graph);
        Set<Pair<Node, Node>> keys = paths.keySet();
        for(Pair<Node, Node> pair : keys){
            System.out.println("Path for {" + pair.i + "->" + pair.j + "}:");
            List<Node> path = paths.get(pair);
            for(Node node : path){
                System.out.print("->" + node);
            }
            System.out.println();
        }

        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }
}
