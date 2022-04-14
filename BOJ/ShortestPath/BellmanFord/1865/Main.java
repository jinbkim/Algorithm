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
    static int[] shortestPath;
    static int INF = 987654321;
    static List<Edge> list = new ArrayList<>();

    static boolean isCycle() {
        shortestPath[1] = 0;

        for(int i=0; i<=n; i++) {
            for(int j=0; j<list.size(); j++) {
                Edge edge = list.get(j);
                if (shortestPath[edge.destination] <= shortestPath[edge.source]+edge.weight)
                    continue;
                shortestPath[edge.destination] = shortestPath[edge.source]+edge.weight;
                
                if (i == n)
                    return true; 
            }
        }

        return false;
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

            int source, destination, weight;
            list.clear();
            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                source = Integer.parseInt(st.nextToken());
                destination = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                list.add(new Edge(source, destination, weight));
                list.add(new Edge(destination, source, weight));
            }

            for(int j=0; j<w; j++) {
                st = new StringTokenizer(br.readLine());
                source = Integer.parseInt(st.nextToken());
                destination = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                list.add(new Edge(source, destination, -weight));
            }

            shortestPath = new int[n+1];
            Arrays.fill(shortestPath, INF);
            if (isCycle() == true)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
