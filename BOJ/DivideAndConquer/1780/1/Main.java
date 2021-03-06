import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int count[] = new int[3];
    static int map[][];

    static void cutPaper(int x, int y, int size) {
        if (size == 1) {
            count[map[y][x]+1]++;
            return ;
        }

        int num = map[y][x];
        for(int i=y; i<y+size; i++) {
            for(int j=x; j<x+size; j++) {
                if (num != map[i][j]) {
                    size/=3;
                    for(int k=y; k<y+3*size; k+=size)
                        for(int l=x; l<x+3*size; l+=size)
                            cutPaper(l, k, size);
                    return ;
                }
            }
        }
        count[num+1]++;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        cutPaper(0, 0, n);
        for(int i=0; i<3; i++)
            System.out.println(count[i]);
    }
}