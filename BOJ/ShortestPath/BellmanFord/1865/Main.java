import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class Main {

    static int n, m, w;
    static List<Edge> edges = new ArrayList<>();
    static long[] shortestPath;
    static int INF = 987654321;
    // static boolean visit[];

    static boolean bellmanFord() {
        shortestPath[1] = 0;

        for(int i=0; i<=n; i++) {
            for(int j=0; j<edges.size(); j++) {
                Edge edge = edges.get(j);
                if (shortestPath[edge.destination] <= shortestPath[edge.source]+edge.weight)
                    continue;
                shortestPath[edge.destination] = shortestPath[edge.source]+edge.weight;

                if (i == n)
                    return false;
            }
        }
        
        // for(int i=1; i<=n; i++) {
        //     if (shortestPath[i] == INF)
        //         return false;
        // }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges.clear();
            int source, destination, weight;
            // visit = new boolean[n+1];
            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                source = Integer.parseInt(st.nextToken());
                destination = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(source, destination, weight));
                edges.add(new Edge(destination, source, weight));
                // visit[source] = true;
            }
            
            for(int j=0; j<w; j++) {
                st = new StringTokenizer(br.readLine());
                source = Integer.parseInt(st.nextToken());
                destination = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(source, destination, -weight));
                // visit[source] = true;
            }
            
            // int k=1;
            // for(int j=1; j<=n; j++) {
            //     if (visit[j] == false) {
            //         sb.append("NO").append('\n');
            //         k = n+1;
            //         break ;
            //     }
            // }

            shortestPath = new long[n+1];
            Arrays.fill(shortestPath, INF);
            if (bellmanFord() == false)
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
            // for(; k<=n; k++) {
            //     if (bellmanFord(k) == false) {
            //         sb.append("YES").append('\n');
            //         break ;
            //     }
            // }
            // if (n < k)
            //     sb.append("NO").append('\n');
        }
        System.out.print(sb.toString());
    }
}
