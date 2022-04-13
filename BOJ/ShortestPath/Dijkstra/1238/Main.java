import java.io.BufferedInputStream;
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

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return (this.weight-edge.weight);
    }
}

public class Main {

    static int n, m, x;
    static List<Edge>[] edgeLists;
    static int[][] shortestPath;
    static int INF = 987654321;

    static void getShortestPath(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        shortestPath[start][start] = 0;
        pq.add(new Edge(start, 0));

        while (pq.isEmpty() == false) {
            Edge currentEdge = pq.poll();
            if (shortestPath[start][currentEdge.destination] < currentEdge.weight)
                continue;
            
            for(int i=0; i<edgeLists[currentEdge.destination].size(); i++) {
                Edge nextEdge = edgeLists[currentEdge.destination].get(i);
                if (shortestPath[start][nextEdge.destination] <= currentEdge.weight+nextEdge.weight)
                    continue;
                    
                shortestPath[start][nextEdge.destination] = currentEdge.weight+nextEdge.weight;
                pq.add(new Edge(nextEdge.destination, shortestPath[start][nextEdge.destination]));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        edgeLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            edgeLists[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeLists[source].add(new Edge(destination, weight));
        }

        shortestPath = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            Arrays.fill(shortestPath[i], INF);
        for(int i=1; i<=n; i++)
            getShortestPath(i);
        
        int sum[] = new int [n+1];
        for(int i=1; i<=n; i++)
            sum[i] = shortestPath[x][i]+shortestPath[i][x];
        Arrays.sort(sum, 1, n+1);
        System.out.print(sum[n]);
    }
}
