import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char map[][];
    static StringBuilder sb = new StringBuilder();

    static void quadTree(int x, int y, int size) {
        if (size == 0)
            return ;

        char c = map[y][x];
        for(int i=y; i<y+size; i++) {
            for(int j=x; j<x+size; j++) {
                if (c != map[i][j]) {
                    size /= 2;
                    sb.append('(');
                    quadTree(x, y, size);
                    quadTree(x+size, y, size);
                    quadTree(x, y+size, size);
                    quadTree(x+size, y+size, size);
                    sb.append(')');
                    return ;
                }
            }
        }
        sb.append(c);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0; i<n; i++)
            map[i] = br.readLine().toCharArray();
                
        quadTree(0,0,n);
        System.out.print(sb.toString());
    }
}
