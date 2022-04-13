import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int n, m;
    static Edge edges[];
    static long shortestPath[];
    static int INF = 987654321;

    static boolean bellmanFord() {
        shortestPath[1] = 0;

        for(int i=0; i<=n; i++) {
            for(int j=0; j<m; j++) {
                Edge edge = edges[j];
                if (shortestPath[edge.source] == INF || shortestPath[edge.destination] <= shortestPath[edge.source]+edge.weight)
                    continue ;
                shortestPath[edge.destination] = shortestPath[edge.source]+edge.weight;

                if (i == n)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new Edge[m];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(source, destination, weight);
        }

        shortestPath = new long[n+1];
        Arrays.fill(shortestPath, INF);
        if (bellmanFord() == false) {
            System.out.print(-1);
            return ;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++) {
            if (shortestPath[i] == INF)
                sb.append(-1).append('\n');
            else
                sb.append(shortestPath[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
