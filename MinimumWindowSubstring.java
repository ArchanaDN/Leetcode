import java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < m; i++) {
            Character ch = t.charAt(i);
            int val = tMap.getOrDefault(ch, 0);
            tMap.put(ch, val + 1);
        }
        int i = 0;
        int j = 0;
        int resi = 0;
        int resj = 0;
        int minl = Integer.MAX_VALUE;
        while(i < n && j < n) {
            Character chj = s.charAt(j);
            if(tMap.containsKey(chj)) {
                int val = tMap.get(chj);
                tMap.put(chj, val - 1);
                if(val - 1 >= 0) {
                    m--;
                }
            }
            if(m == 0) {
                while(i < n && m == 0) {
                    if(minl > j - i + 1) {
                        resi = i;
                        resj = j;
                        minl = Math.min(minl, j - i + 1);
                    }
                    Character chi = s.charAt(i);
                    if(tMap.containsKey(chi)) {
                        int val = tMap.getOrDefault(chi, 0);
                        tMap.put(chi, val + 1);
                        if(val + 1 > 0) {
                            m++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return s.substring(resi, resj + 1);
    }
    
}
