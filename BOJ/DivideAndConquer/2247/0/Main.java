import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char map[][];

    static void fillStars(int x, int y, int size, boolean isBlank) {
        if (size == 0)
            return ;

        if (isBlank == true)
        {
            for(int i=x; i<x+size; i++)
                for(int j=y; j<y+size; j++)
                    map[i][j] = ' ';
            return ;
        }

        size /= 3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (i == 1 && j == 1)
                    fillStars(x+i*size, y+j*size, size, true);
                else
                    fillStars(x+i*size, y+j*size, size, false);
            }
        }
    }

    static void printStars(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                sb.append(map[i][j]);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new char[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(map[i], '*');

        fillStars(0, 0, n, false);
        printStars(n);
    }
}
