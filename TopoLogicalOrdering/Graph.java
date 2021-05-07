import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    List<List<Node>> adj_list = new ArrayList<>();
    Set<Integer> vertices = new HashSet<>();

    public Graph(List<Edge> edges) {
        for (Edge edge : edges){
            adj_list.add(edge.src, new ArrayList<>());
        }

        for (Edge e : edges){
            adj_list.get(e.src).add(new Node(e.dst, e.weight));
            vertices.add(e.src);
            vertices.add(e.dst);
        }
    }
    static class Node{
        int value, weight;
        Node(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    void printGraph(){
        int src_vertex=0;
        int list_size = adj_list.size();

        System.out.println("The contents of the graph:");
        while(src_vertex < list_size){
            for (Node edge: adj_list.get(src_vertex)){
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value + " (" + edge.weight + ")\t");
            }
            System.out.println();
            src_vertex ++;
        }
    }
    void remove_vertex(int vertex){
//        System.out.println("\n\t\tGetting nodes at :" + vertex + "");
        List<Node> nodes = adj_list.get(vertex);
        for (Node node : nodes){
            if (node.value == vertex)
                remove_vertex(node.value);
        }
        for (int index = adj_list.size()-1 ; index >= 0; index--){
            if (index == vertex) {
                adj_list.set(index, new ArrayList<>());
                continue;
            }
            List<Node> curr_node = adj_list.get(index);
            for ( int index_inner_ = curr_node.size()-1; index_inner_ >=0 ; index_inner_--){
                Node node_ = curr_node.get(index_inner_);
                if (node_.value == vertex)
                    adj_list.get(index).remove(index_inner_);
            }
        }
        vertices.remove(vertex);
        System.out.println("\n\tRemoved " + vertex + " from adj_list and vertices;\n");
//        System.out.println("Graph now:");
//        printGraph();
    }
}
