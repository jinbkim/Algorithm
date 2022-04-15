import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    static boolean isSameParent(int e1, int e2) {
        int parent1 = getParent(e1);
        int parent2 = getParent(e2);

        if (parent1 == parent2)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        parent = new int[n+1];
        for(int i=1; i<=n; i++)
            parent[i] = i;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int element1 = Integer.parseInt(st.nextToken());
            int element2 = Integer.parseInt(st.nextToken());

            if (command == 0)
                union(element1, element2);
            else {
                if (isSameParent(element1, element2) == true)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}
