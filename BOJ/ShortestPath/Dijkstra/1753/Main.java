import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge Edge) {
        return (this.weight-Edge.weight);
    }
}

public class Main {

    static int v, e, k;
    static List<Edge>[] pathLists;
    static int shortestPath[];
    static final int INF = 987654321;

    static void getShortestPath(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        shortestPath[start] = 0;

        pq.add(new Edge(start, 0));
        while (pq.isEmpty() == false) {
            Edge currentEdge = pq.poll();
            if (shortestPath[currentEdge.end] < currentEdge.weight)
                continue;
            
            for(int i=0; i<pathLists[currentEdge.end].size(); i++) {
                Edge nextEdge = pathLists[currentEdge.end].get(i);

                if (currentEdge.weight+nextEdge.weight < shortestPath[nextEdge.end]) {
                    shortestPath[nextEdge.end] = currentEdge.weight+nextEdge.weight;
                    pq.add(new Edge(nextEdge.end, shortestPath[nextEdge.end]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        pathLists = new ArrayList[v+1];
        for(int i=1; i<=v; i++)
            pathLists[i] = new ArrayList<Edge>();
        
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int startEdge = Integer.parseInt(st.nextToken());
            int endEdge = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pathLists[startEdge].add(new Edge(endEdge, weight));
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