import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        cutPaper(0, 0, n);
        for(int i=0; i<3; i++)
            System.out.println(count[i]);
    }
}