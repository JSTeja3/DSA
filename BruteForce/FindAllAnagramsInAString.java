import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> ans = findAnagrams(s, p);
        for(int v: ans){
            System.out.print(v+" ");
        }
        sc.close();
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] pCount = countArray(p);
        int required = uniqueChar(pCount);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int formed = 0;
            int[] subCount = new int[26];
            for (int j = i; j < s.length(); j++) {
                int x = s.charAt(j) - 'a';
                subCount[x]++;
                if (subCount[x] == pCount[x]) {
                    formed++;
                }
                if (formed == required && j - i + 1 == p.length()) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    public static int[] countArray(String temp) {
        int[] tempCount = new int[26];
        for (int i = 0; i < temp.length(); i++) {
            int x = temp.charAt(i) - 'a';
            tempCount[x]++;
        }
        return tempCount;
    }

    public static int uniqueChar(int[] countArray) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (countArray[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
