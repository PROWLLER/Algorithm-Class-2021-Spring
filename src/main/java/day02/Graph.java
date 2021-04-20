package day02;

import tools.AlgorithmTools;
import tools.AlgorithmTools.*;


import java.util.Map;

public class Graph {

    public static class Edge{
        private Node source;
        private Node target;
        private Integer len;

        public Node getSource() {
            return source;
        }

        public Node getTarget() {
            return target;
        }

        public Integer getLen() {
            return len;
        }
        public Edge(Node source, Node target, int len){
            this.len = len;
            this.source = source;
            this.target = target;
        }

        @Override
        public String toString() {
            return "Edge{" + source.toString() + "->" + target.toString() + ", len:" + len + "}";
        }
    }

    public static class Node{
        private String name;

        public String getName() {
            return name;
        }

        public Node(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Node)){
                return false;
            }

            Node node = (Node)obj;
            if(node.getName().equals(this.name))return true;
            return false;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            return "Node(" + name + ")";
        }
    }


    private Node[] nodes;
    private Edge[] edges;

    public Graph(Node[] nodes, Edge[] edges){
        this.nodes = nodes;
        this.edges = edges;
    }



    public Graph(){
        getDefaultGraph();
    }

    private void getDefaultGraph(){
        Node[] nodes = new Node[16];
        for (int i = 0; i < 16; i++) {
            nodes[i] = new Node("Node" + i);
        }
        Edge[] edges =
                {
                        new Edge(nodes[0], nodes[1], 5),
                        new Edge(nodes[0], nodes[2], 3),
                        new Edge(nodes[1], nodes[3], 1),
                        new Edge(nodes[1], nodes[4], 3),
                        new Edge(nodes[1], nodes[5], 6),
                        new Edge(nodes[2], nodes[4], 8),
                        new Edge(nodes[2], nodes[5], 7),
                        new Edge(nodes[2], nodes[6], 6),
                        new Edge(nodes[3], nodes[7], 6),
                        new Edge(nodes[3], nodes[8], 8),
                        new Edge(nodes[4], nodes[7], 3),
                        new Edge(nodes[4], nodes[8], 5),
                        new Edge(nodes[5], nodes[8], 3),
                        new Edge(nodes[5], nodes[9], 3),
                        new Edge(nodes[6], nodes[8], 8),
                        new Edge(nodes[6], nodes[9], 4),
                        new Edge(nodes[7], nodes[10], 2),
                        new Edge(nodes[7], nodes[11], 2),
                        new Edge(nodes[8], nodes[11], 1),
                        new Edge(nodes[8], nodes[12], 2),
                        new Edge(nodes[9], nodes[11], 3),
                        new Edge(nodes[9], nodes[12], 3),
                        new Edge(nodes[10], nodes[13], 3),
                        new Edge(nodes[10], nodes[14], 5),
                        new Edge(nodes[11], nodes[13], 5),
                        new Edge(nodes[11], nodes[14], 2),
                        new Edge(nodes[12], nodes[13], 6),
                        new Edge(nodes[12], nodes[14], 6),
                        new Edge(nodes[13], nodes[15], 4),
                        new Edge(nodes[14], nodes[15], 3),



                };

        this.edges = edges;
        this.nodes = nodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public Node[] getNodes() {
        return nodes;
    }
}
