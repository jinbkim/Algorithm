import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isVPS(String str) {
        int stack = 0;

        for(char c : str.toCharArray()) {
            if (c == '(')
                stack++;
            else
                stack--;
            if (stack < 0)
                return false;
        }
        if (stack != 0)
            return false;
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            String str = br.readLine();
            if (isVPS(str))
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}