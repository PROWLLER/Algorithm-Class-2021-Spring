package day02;
import day02.Graph.*;

import java.util.ArrayList;
import java.util.*;
/**
 * Support by class {@code Graph}
 * To find min path in a graph
 *
 * @author PROWLLER
 * */
public class ShortestPathInGraph {

    public static Node[] findPathInGraph(Graph graph, Node source, Node target){

        Node[] nodes = graph.getNodes();
        Edge[] edges = graph.getEdges();

        Map<Node, ArrayList<Node>> paths = new HashMap<>();
        Map<Node, Integer> shortest = new HashMap<>();

        ArrayList<Node> initPath = new ArrayList<Node>();
        initPath.add(source);

        paths.put(source, initPath);
        shortest.put(source, 0);

        while(!paths.containsKey(target)){
            Edge availableEdge = null;
            for (int i = 0; i < edges.length; i++) {
                if(paths.containsKey(edges[i].getSource())
                && (!paths.containsKey(edges[i].getTarget()))){
                    if(availableEdge == null ||
                       availableEdge.getLen()+shortest.get(availableEdge.getSource()) > edges[i].getLen()+shortest.get(edges[i].getSource())){
                        availableEdge = edges[i];
                    }
                }
            }

            if(availableEdge == null){
                break;
            }

            ArrayList<Node> path = new ArrayList<>();
            path.addAll(paths.get(availableEdge.getSource()));
            path.add(availableEdge.getTarget());
            paths.put(availableEdge.getTarget(), path);
            shortest.put(availableEdge.getTarget(), shortest.get(availableEdge.getSource())+availableEdge.getLen());

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
