import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int parent[];

    static int getParent(int city) {
        if (parent[city] == city)
            return city;
        
        parent[city] = getParent(parent[city]);
        return parent[city];
    }

    static void union(int city1, int city2) {
        int parent1 = getParent(city1);
        int parent2 = getParent(city2);

        if (parent1 <= parent2)
            parent[parent2] = parent1;
        else
            parent[parent1] = parent2;
    }

    static boolean isSameParent(int city1, int city2) {
        int parent1 = getParent(city1);
        int parent2 = getParent(city2);

        if (parent1 == parent2)
            return true;
        return false;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (isConnect == 1)
                    union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        for(int i=1; i<m; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (isSameParent(firstCity, nextCity) == false) {
                System.out.println("NO\n");
                return ;
            }
        }
        System.out.println("YES\n");
    }
}
