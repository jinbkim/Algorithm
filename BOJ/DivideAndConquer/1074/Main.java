import java.util.Scanner;

public class Main {

    static int r, c;

    static void find(int x, int y, int size, int num) {
        if (size == 1) {
            System.out.println(num);
            return ;
        }

        size /= 2;
        if (c<x+size && r<y+size)
            find(x, y, size, num);
        else if (x+size<=c && r<y+size)
            find(x+size, y, size, num+size*size);
        else if (c<x+size && y+size<=r)
            find(x, y+size, size, num+size*size*2);
        else if (x+size<=c  && y+size<=r)
            find(x+size, y+size, size, num+size*size*3);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        find(0, 0, (int)Math.pow(2, n), 0);
    }
}
