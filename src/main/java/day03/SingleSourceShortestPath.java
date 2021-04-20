package day03;
import day02.Graph;
import day02.Graph.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleSourceShortestPath {
    public static Node[] solve(Graph graph, Node source, Node target){
        Node[] nodes = graph.getNodes();
        Edge[] edges = graph.getEdges();

        Map<Node, ArrayList<Node>> paths = new HashMap<>();
        Map<Node, Integer> shortest = new HashMap<>();

        ArrayList<Node> initPath = new ArrayList<Node>();
        initPath.add(source);

        paths.put(source, initPath);
        shortest.put(source, 0);

        for (int i = 0; i < nodes.length; i++) {
            // run slack
            for (int j = 0; j < edges.length; j++) {
                if(shortest.containsKey(edges[j].getSource())){
                    if(shortest.containsKey(edges[j].getTarget())){
                        Integer oldMaxAtTarget = shortest.get(edges[j].getTarget());
                        Integer newLengthAtTarget = shortest.get(edges[j].getSource()) + edges[j].getLen();
                        if(newLengthAtTarget < oldMaxAtTarget){
                            // add new path
                            ArrayList<Node> newPath = new ArrayList<>(paths.get(edges[j].getSource()));
                            newPath.add(edges[j].getTarget());

                            paths.put(edges[j].getTarget(), newPath);
                            shortest.put(edges[j].getTarget(), newLengthAtTarget);
                        }
                    }else{
                        Integer newLengthAtTarget = shortest.get(edges[j].getSource()) + edges[j].getLen();
                        ArrayList<Node> newPath = new ArrayList<>(paths.get(edges[j].getSource()));
                        newPath.add(edges[j].getTarget());

                        paths.put(edges[j].getTarget(), newPath);
                        shortest.put(edges[j].getTarget(), newLengthAtTarget);
                    }
                }
            }


        }

        //check negative loop
        for (int j = 0; j < edges.length; j++) {
            if(shortest.containsKey(edges[j].getSource())){
                if(shortest.containsKey(edges[j].getTarget())){
                    Integer oldMaxAtTarget = shortest.get(edges[j].getTarget());
                    Integer newLengthAtTarget = shortest.get(edges[j].getSource()) + edges[j].getLen();
                    if(newLengthAtTarget < oldMaxAtTarget){
                        return null;
                        //have negative loop
                    }
                }
            }
        }

        if(paths.containsKey(target)){
            ArrayList<Node> path = paths.get(target);
            Node[] result = new Node[path.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = path.get(i);
            }
            return result;
        }
        return null;

    }
}
