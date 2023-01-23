import java.util.*;

public class ChangeMinChar {

    public static void main(String[] args) {
        String a = "a";
        String b = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        System.out.println(minCharacters(a, b));
    }

    public static int minCharacters(String a, String b) {
        //Frequency maps for a and b
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for(int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            int value = mapA.getOrDefault(a.charAt(i), 0);
            mapA.put(ch, value + 1);
        }
        for(int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            int value = mapB.getOrDefault(b.charAt(i), 0);
            mapB.put(ch, value + 1);
        }
        int op1 = numOperations(mapA, mapB);
        int op2 = numOperations(mapB, mapA);
        int op3 = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            char ch = (char) (97 + i);
            op3 = Math.min(op3, (a.length() + b.length() - (mapA.getOrDefault(ch, 0) + mapB.getOrDefault(ch, 0))));
        }
        return Math.min(op1, Math.min(op2, op3));
    }

    //First 2 conditions
    public static int numOperations(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        int op1 = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            int op1Int = 0;
            char ch = (char) (97 + i);
            for(Character chA : mapA.keySet()) {
                if(ch < chA || (ch == 'z' && ch == chA)) {
                    op1Int += mapA.get(chA);
                }
            }
            for(Character chB : mapB.keySet()) {
                if(ch >= chB) {
                    op1Int += mapB.get(chB);
                }
            }
            op1 = Math.min(op1, op1Int);
        }
        return op1;
    }
    
}
