import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge{
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

    static final int INF = 987654321;
    static final int Gee = INF+1;
    static final int gg = INF+2;

    static int n, sourceCity, destinationCity, m;
    static List<Edge> edgeList;
    static int income[];
    static long biggestMoney[];

    static long bellmanFord(int start) {
        biggestMoney[start] = income[start];
        boolean isVisit[] = new boolean[n];
        isVisit[destinationCity] = true;

        for(int i=0; i<=n; i++) {
            for(int j=0; j<edgeList.size(); j++) {
                Edge edge = edgeList.get(j);
                if (isVisit[edge.destination] == true)
                    isVisit[edge.source] = true;

                if (biggestMoney[edge.source] == -INF || biggestMoney[edge.source]+edge.weight+income[edge.destination] <= biggestMoney[edge.destination])
                    continue;
                biggestMoney[edge.destination] = biggestMoney[edge.source]+edge.weight+income[edge.destination];
                
                if (i == n) {
                    if (isVisit[edge.destination] == true)
                        return Gee;
                }
            }
        }

        if (isVisit[start] == false)
            return gg;
        return biggestMoney[destinationCity];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sourceCity = Integer.parseInt(st.nextToken());
        destinationCity = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(source, destination, -weight));
        }

        income = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            income[i] = Integer.parseInt(st.nextToken());
        
        biggestMoney = new long[n];
        Arrays.fill(biggestMoney, -INF);
        long result = bellmanFord(sourceCity);
        if (result == Gee)
            System.out.println("Gee");
        else if (result == gg)
            System.out.println("gg");
        else
            System.out.println(result);
    }
}
