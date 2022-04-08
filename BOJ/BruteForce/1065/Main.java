import java.util.Scanner;;

public class Main {

    public static boolean isHansu(String num) {
        if (num.length() <= 2)
            return true;
        
        int diff = num.charAt(1)-num.charAt(0);
        for(int i=2; i<num.length(); i++)
            if (num.charAt(i)-num.charAt(i-1) != diff)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int sumOfHansu = 0;

        for(int i=1; i<=Integer.parseInt(input); i++)
            if (isHansu(Integer.toString(i)) == true)
                sumOfHansu++;
                
        System.out.println(sumOfHansu);
    }
}
