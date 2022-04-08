public class Main {

	public static int makeNextSelfNumber(int num) {
		int nextSelfNumber = num;

		while(num > 0) {
			int singleDigit = num - num/10*10;
			nextSelfNumber += singleDigit;
			num /= 10;
		}
		
		return nextSelfNumber;
	}
	
	public static void main(String[] args) {
		int maxNumber = 10000;
		boolean []flag = new boolean[maxNumber];
        StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<maxNumber; i++)
		{
			int nextSelfNumber = makeNextSelfNumber(i);
			if (nextSelfNumber < maxNumber)
				flag[nextSelfNumber] = true;
		}
		
		for(int i=1; i<maxNumber; i++)
			if (flag[i] == false)
                sb.append(i).append('\n');
        
        System.out.print(sb.toString());
	}

}