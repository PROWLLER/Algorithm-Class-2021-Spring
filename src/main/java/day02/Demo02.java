package day02;

import tools.AlgorithmTools;
import day02.Graph.*;

import java.util.HashSet;
import java.util.*;

public class Demo02 {
    public static void main(String[] args) {

        //MatrixChainDemo();
        //LCSubsequenceDemo();
        //LCSubstringDemo();
        //MaxSumDemo();
        //GraphDemo();
    }

    public static void MatrixChainDemo(){
        System.out.println("*******************");
        System.out.println("MatrixChainDemo");
        int[] c={10, 3, 15, 12, 7, 2};
        System.out.println("对数组：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("计算结果为");
        System.out.println(MatrixChainProduct.calMatrixChain(c));
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
        System.out.println("最大和" + MaxSum.findMaxSum(c, pair));
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
                        .findLCS(
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
                        .findLCS(
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
        Node[] out = ShortestPathInGraph.findPathInGraph(graph, source, target);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i].getName());
        }
        System.out.println("*******************");
        System.out.println();
        System.out.println();
    }
}
