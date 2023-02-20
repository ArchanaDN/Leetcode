import java.util.*;

public class LetterCombination {

    public static void main(String[] args) {
        letterCombinations("23");  
    }

    public static List<String> result;
    public static Map<Integer, String> map;

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length() <= 0) {
            return result;
        }
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        letters(digits, 0, digits.length(), new StringBuilder());
        return result;
    }

    public static void letters(String digits, int k, int len, StringBuilder res) {
        if(res.length() >= len) {
            result.add(res.toString());
            return;
        }
        System.out.println(k);
        for(int i = k; i < len; i++) {
            String mappedLetters = map.get(Character.getNumericValue(digits.charAt(i)));
            int j = 0;
            //System.out.println(map.get(Character.getNumericValue(digits.charAt(i))));
            while(j < mappedLetters.length()) {
                res.append(mappedLetters.substring(j, j+1));
                letters(digits, k+1, len, res);
                res.deleteCharAt(res.length() - 1);
                j++; 
            }
        }
    }
}