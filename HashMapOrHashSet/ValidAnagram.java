package HashMapOrHashSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram(s, t));
        sc.close();
    }
    // Hash Map
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))==1){
                    map.remove(t.charAt(i));
                }
                else{
                    map.put(t.charAt(i), map.get(t.charAt(i))-1);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    // Freqency Count-Best Optimization
    public static boolean isAnagramF(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] frequency = new int[26];
        for(int i=0; i<s.length(); i++){
            frequency[s.charAt(i)-'a']++;
            frequency[t.charAt(i)-'a']--;
        }
        for(int count : frequency){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

}
