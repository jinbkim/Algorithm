class Solution {
    public int countRepeat(String str1, String str2, int size) {
        int result = 1;

        for(int i=0; i+size<=str2.length(); i+=size) {
            String str = str2.substring(i, i+size);
            if (str1.equals(str) == false)
                break ;
            result++;
        }

        return result;
    }

    public String compress(String s, int size) {
        int i= 0;
        String compressStr = "";

        while (true) {
            if (i+size > s.length()) {
                compressStr += s.substring(i);
                break ;
            }

            String pattern = s.substring(i, i+size);
            String nextStr = s.substring(i+size);
            int count = countRepeat(pattern, nextStr, size);
            if (count > 1) {
                compressStr += count + pattern;
                i += size*count;
                continue ;
            }

            compressStr += s.substring(i, i+size);
            i += size;
        }

        return compressStr;
    }

    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2; i++)
            answer = Math.min(answer, compress(s, i).length());
        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaccc"));
        System.out.println(solution.solution("ababcdcdababcdcd"));
        System.out.println(solution.solution("abcabcdede"));
        System.out.println(solution.solution("abcabcabcabcdededededede"));
        System.out.println(solution.solution("xababcdcdababcdcd"));
    }
}
