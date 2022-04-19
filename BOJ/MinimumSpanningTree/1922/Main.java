import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return (this.weight - edge.weight);
    }
}

public class Main {

    static int n, m;
    static int parent[];

    static int getParent(int e) {
        if (e == parent[e])
            return e;
        
        parent[e] = getParent(parent[e]);
        return parent[e];
    }

    static void union(int e1, int e2) {
        int parent1 = getParent(e1);
        int parent2 = getParent(e2);

        if (parent1 <= parent2)
            parent[parent2] = parent1;
        else
            parent[parent1] = parent2;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(source, destination, weight));
        }

        parent = new int[n+1];
        for(int i=1; i<=n; i++)
            parent[i] = i;
        
        int result = 0;
        while (pq.isEmpty() == false) {
            Edge edge = pq.poll();
            int sourceParent = getParent(edge.source);
            int destinationParent = getParent(edge.destination);
            if (sourceParent == destinationParent)
                continue;
            
            union(sourceParent, destinationParent);
            result += edge.weight;
        }
        System.out.println(result);
    }
}
