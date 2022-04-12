import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return (this.weight-edge.weight);
    }
}

public class Main {

    static int v, e, k;
    static List<Edge>[] edgeLists;
    static int INF = 987654321;
    static int shortestPath[];

    static void getShortestPath(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        shortestPath[start] = 0;

        pq.add(new Edge(start, 0));
        while (pq.isEmpty() == false) {
            Edge currentNode = pq.poll();
            if (shortestPath[currentNode.destination] < currentNode.weight)
                continue ;

            for(int i=0; i<edgeLists[currentNode.destination].size(); i++) {
                Edge nextNode = edgeLists[currentNode.destination].get(i);
                
                if (currentNode.weight+nextNode.weight < shortestPath[nextNode.destination]) {
                    shortestPath[nextNode.destination] = currentNode.weight+nextNode.weight;
                    pq.add(new Edge(nextNode.destination, shortestPath[nextNode.destination]));
                }
            }
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
    
        edgeLists = new ArrayList[v+1];
        for(int i=1; i<=v; i++)
            edgeLists[i] = new ArrayList<>();
        
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeLists[source].add(new Edge(destination, weight));
        }

        shortestPath = new int[v+1];
        Arrays.fill(shortestPath, INF);
        getShortestPath(k);

        for(int i=1; i<=v; i++) {
            if (shortestPath[i] == INF)
                System.out.println("INF");
            else
                System.out.println(shortestPath[i]);
        }
    }
}
