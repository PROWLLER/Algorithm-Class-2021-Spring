package day02;

import tools.AlgorithmTools;
import tools.AlgorithmTools.*;
import day02.Graph.*;

public class Demo02 {
    public static void main(String[] args) throws Exception{

        MatrixChainDemo();
        //LCSubsequenceDemo();
        //LCSubstringDemo();
        //MaxSumDemo();
       // GraphDemo();
    }

    public static void MatrixChainDemo() throws Exception{
        System.out.println("*******************");
        System.out.println("MatrixChainDemo");
        int[] c={10, 3, 15, 12, 7, 2};
        System.out.println("对数组：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("计算结果为");
        //MatrixChainProduct.solve(c);

                // Using proxy
        Pair<Long, Object> result =
                AlgorithmTools.timeLoggerProxy(MatrixChainProduct.class, "solve",
                new Object[]{c},
                new Class[]{Integer.class}        );
        System.out.println(result.j);
        System.out.println("Time used: " + result.i);;
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void MaxSumDemo(){
        System.out.println("*******************");
        System.out.println("MaxSumDemo");
        int[] c={5, 6, -1, 5, 4, -7};
        System.out.println("对数组：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("计算结果为");
        AlgorithmTools.Pair<Integer, Integer> pair = new AlgorithmTools.Pair<>(0, 0);
        System.out.println("最大和" + MaxSum.solve(c, pair));
        System.out.println("数组起始结束下标" + pair.i + " " + pair.j);
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void LCSubsequenceDemo(){
        System.out.println("*******************");
        System.out.println("LCSubSUBSEQUENCEDemo");
        System.out.println("结果为：");
        System.out.println(
                LongestCommonSubsequence
                        .solve(
                                "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD"
                                , "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG"));
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void LCSubstringDemo(){
        System.out.println("*******************");
        System.out.println("LCSubSTRINGDemo");
        System.out.println("结果为：");
        System.out.println(
                LongestCommonSubstring
                        .solve(
                               "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD"
                               , "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG"));
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }

    public static void GraphDemo(){
        System.out.println("*******************");
        System.out.println("Graph Demo");
        System.out.println("Path:");
        Graph graph = new Graph();
        Node source = graph.getNodes()[0];
        Node target = graph.getNodes()[15];
        Node[] out = ShortestPathInGraph.solve(graph, source, target);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i].getName());
        }
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }
}
