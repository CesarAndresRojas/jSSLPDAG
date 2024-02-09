import java.util.*;

class Vertex {
    long id;

    Vertex(long id) {
        this.id = id;
    }
}

class Edge {
    Vertex from;
    Vertex to;
    int cost;

    Edge(Vertex from, Vertex to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Graph {
    Edge[] edges;
    Vertex[] vertices;

    Graph(Edge[] edges, Vertex[] vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    //Use Dijkstra's algorithm to find the longest path
    public Map<Vertex, Integer> longestPath(Vertex start) {
        // Multiply all edge costs by -1
        for (Edge edge : edges) {
            edge.cost *= -1;
        }

        // Run Dijkstra's algorithm to find the shortest path
        Map<Vertex, Integer> shortestDistances = dijkstra(start);

        // Multiply all edge costs by -1 again
        for (Edge edge : edges) {
            edge.cost *= -1;
        }

        // Convert shortest distances to longest distances
        for (Map.Entry<Vertex, Integer> entry : shortestDistances.entrySet()) {
            entry.setValue(-entry.getValue());
        }

        return shortestDistances;
    }

    public Map<Vertex, Integer> dijkstra(Vertex start) {
        Map<Vertex, Integer> distance = new HashMap<>();
        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));

        distance.put(start, 0);
        pq.add(new VertexDistancePair(start, 0));

        while (!pq.isEmpty()) {
            Vertex current = pq.poll().vertex;

            for (Edge edge : edges) {
                if (edge.from.equals(current)) {
                    Vertex neighbor = edge.to;
                    int newDistance = distance.get(current) + edge.cost;

                    if (!distance.containsKey(neighbor) || newDistance < distance.get(neighbor)) {
                        distance.put(neighbor, newDistance);
                        pq.add(new VertexDistancePair(neighbor, newDistance));
                    }
                }
            }
        }

        return distance;
    }

    private static class VertexDistancePair {
        Vertex vertex;
        int distance;

        VertexDistancePair(Vertex vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class main {
    public static void main(String[] args) {

        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);

        Edge e1 = new Edge(a, b, 1);
        Edge e2 = new Edge(a, c, 1);
        Edge e3 = new Edge(a, d, 1);
        Edge e4 = new Edge(a, e, 1);
        Edge e5 = new Edge(b, d, 1);
        Edge e6 = new Edge(c, d, 1);
        Edge e7 = new Edge(c, e, 1);
        Edge e8 = new Edge(d, e, 1);

        Edge[] edges = {e1, e2, e3, e4, e5, e6, e7, e8};
        Vertex[] vertices = {a, b, c, d, e};

        Graph graph = new Graph(edges, vertices);

        Vertex startVertex = a;
        Map<Vertex, Integer> longestDistances = graph.longestPath(startVertex);

        System.out.println("Longest distances from vertex " + startVertex.id + ":");
        for (Map.Entry<Vertex, Integer> entry : longestDistances.entrySet()) {
            System.out.println("To vertex " + entry.getKey().id + ": " + entry.getValue());
        }

        Map<Vertex, Integer> shortestDistances = graph.dijkstra(startVertex);

        System.out.println("Shortest distances from vertex " + startVertex.id + ":");
        for (Map.Entry<Vertex, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To vertex " + entry.getKey().id + ": " + entry.getValue());
        }
    }
}
