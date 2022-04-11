import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int map[][];
    static int count[] = new int[2];

    static void cutPaper(int x, int y, int size) {
        if(size == 0)
            return ;
        
        int paper = map[y][x];
        for(int i=y; i<y+size; i++) {
            for(int j=x; j<x+size; j++) {
                if(paper != map[i][j]) {
                    size /= 2;
                    cutPaper(x, y, size);
                    cutPaper(x+size, y, size);
                    cutPaper(x, y+size, size);
                    cutPaper(x+size, y+size, size);
                    return ;
                }
            }
        }

        count[paper]++;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, n);
        System.out.println(count[0]);
        System.out.println(count[1]);

    }
}
