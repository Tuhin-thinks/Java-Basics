import java.util.*;

public class TopoLogicalOrdering {
    static Scanner sc = new Scanner(System.in);
    void print_vertices(Set<Integer> vertices){
        System.out.println("\t " + Arrays.toString(vertices.toArray()) + "");
    }

    int findInDegree(Graph graph, int search_vertex){
        int inDegree_count = 0;
        List<Graph.Node> nodes = null;
        for (int vertex=0; vertex < graph.adj_list.size(); vertex++) {
            nodes = graph.adj_list.get(vertex);
            assert nodes != null;
            for (Graph.Node node : nodes) {
                if (node.value == search_vertex)
                    inDegree_count++;
            }
        }
        return inDegree_count;
        }

    public static void main(String[] args) {
        TopoLogicalOrdering obj = new TopoLogicalOrdering();
        List<Edge> edges = Arrays.asList(
                new Edge(0,1,0),
                new Edge(0,2,0),
                new Edge(1,2,0),
                new Edge(3,2,0),
                new Edge(4,5,0),
                new Edge(5,3,0));
    /*
    // code to take vertices as input and store them as adjacency list

    List<Edge> edges = new ArrayList<>();
         System.out.print("Enter number of rows in adjacency list:");
         int range = sc.nextInt();

         for (int i=0; i<range; i++)
         {
             System.out.println("Enter src destination:");
             int src = sc.nextInt();
             int dst = sc.nextInt();
             edges.add(new Edge(src, dst, 0));
         }
    */
        Graph graph = new Graph(edges);
        System.out.println("entered graph:");
        graph.printGraph();
        System.out.println();
        System.out.println("Vertices:");
        obj.print_vertices(graph.vertices);
        System.out.println();

        int[] order = new int[graph.vertices.size()];
        int pointer = 0;
        while (graph.vertices.size() > 0){
            for (int vertex : graph.vertices){
                int in_degree = obj.findInDegree(graph, vertex);
                if (in_degree == 0) {
                    System.out.println("Removing vertex: " + vertex + ";");
                    graph.remove_vertex(vertex);
                    order[pointer] = vertex;
                    pointer ++;
                    break;
                }
                else
                    System.out.println("In-degree count for " + vertex + " = " + in_degree + "");
            }  // close for
        }  // close while

        System.out.println("Topological Order: " + Arrays.toString(order) + "");  // print the topological order
    }
}
