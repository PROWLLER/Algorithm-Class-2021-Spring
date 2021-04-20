package day03;
import day02.Graph.*;
import day02.Graph;
import tools.AlgorithmTools.*;

import java.util.*;

public class AllPairsShortestPath {
    public static Map<Pair<Node, Node>, List<Node>> solve(Graph graph){
        Map<Pair<Node, Node>, List<Node>> paths = new HashMap<>();
        Map<Pair<Node, Node>, Integer> shortest = new HashMap<>();
        Node[] nodes = graph.getNodes();
        Edge[] edges = graph.getEdges();
        for (int i = 0; i < nodes.length; i++) {
            List<Node> path = new ArrayList<>();

            path.add(nodes[i]);
            paths.put(new Pair<>(nodes[i], nodes[i]), path);
            shortest.put(new Pair<>(nodes[i], nodes[i]), 0);
        }
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            shortest.put(new Pair<>(edge.getSource(), edge.getTarget()), edge.getLen());
            List<Node> path = new ArrayList<>();

            path.add(edge.getTarget());
            paths.put(new Pair<>(edge.getSource(), edge.getTarget()), path);
        }

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                //check pair(nodes[i], nodes[j]) when add a point nodes[k]
                for (int k = 0; k < nodes.length; k++) {
                    if(i!=k && j!=k){
                        if(shortest.containsKey(new Pair<>(nodes[i], nodes[k]))
                           &&
                            shortest.containsKey(new Pair<>(nodes[k], nodes[j]))){

                            boolean needToUpdate = false;
                            if(!shortest.containsKey(new Pair<>(nodes[i], nodes[j]))){
                                needToUpdate = true;
                            }
                            else{
                                if (shortest.get(new Pair<>(nodes[i], nodes[j])) >
                                        shortest.get(new Pair<>(nodes[i], nodes[k])) +
                                                shortest.get(new Pair<>(nodes[k], nodes[j]))){
                                    needToUpdate = true;
                                }
                            }

                            if(needToUpdate){
                                List<Node> iToK = paths.get(new Pair<>(nodes[i], nodes[k]));
                                List<Node> kToJ = paths.get(new Pair<>(nodes[k], nodes[j]));
                                Integer shorter =
                                        shortest.get(new Pair<>(nodes[i], nodes[k])) +
                                        shortest.get(new Pair<>(nodes[k], nodes[j]));
                                List<Node> newIToJ = new ArrayList<>();
                                newIToJ.addAll(iToK);
                                newIToJ.addAll(kToJ);

                                shortest.put(new Pair<>(nodes[i], nodes[j]), shorter);
                                paths.put(new Pair<>(nodes[i], nodes[j]), newIToJ);
                            }
                        }
                    }
                }
            }
        }

        return paths;
    }
}
