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
        return (weight-edge.weight);
    }
}

public class Main {

    static int n, m, source, destination;
    static List<Edge>[] edgeLists;
    static int[] shortestPath;
    static int INF = 987654321;

    static void getShortestPath(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        shortestPath[start] = 0;
        pq.add(new Edge(start, 0));

        while(pq.isEmpty() == false) {
            Edge currentEdge = pq.poll();
            if (shortestPath[currentEdge.destination] < currentEdge.weight)
                continue;
            
            for(int i=0; i<edgeLists[currentEdge.destination].size(); i++) {
                Edge nextEdge = edgeLists[currentEdge.destination].get(i);
                if (shortestPath[nextEdge.destination] <= currentEdge.weight+nextEdge.weight)
                    continue ;

                shortestPath[nextEdge.destination] = currentEdge.weight+nextEdge.weight;
                pq.add(new Edge(nextEdge.destination, shortestPath[nextEdge.destination]));
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edgeLists = new List[n+1];
        for(int i=1; i<=n; i++)
            edgeLists[i] = new ArrayList<>();
        
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeLists[source].add(new Edge(destination, weight));
        }
        
        st = new StringTokenizer(br.readLine());
        source = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        shortestPath = new int[n+1];
        Arrays.fill(shortestPath, INF);
        getShortestPath(source);
        System.out.println(shortestPath[destination]);
    }
}
