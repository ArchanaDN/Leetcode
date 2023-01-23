import java.util.*;

public class CombinationsSum3 {

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }

    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        //We need to use recursion for this backtracking problem
        combinations(k, n, new ArrayList<>(), 1);
        return result;
    }

    public static void combinations(int k, int n, List<Integer> res, int startPoint) {
        if(k == 0 && n == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        if(k == 0 || n < 0) {
            return;
        }
        for(int i = startPoint; i <= 9; i++) {
            res.add(i);
            combinations(k - 1, n - i, res, startPoint + 1);
            int resSize = res.size();
            res.remove(resSize - 1);
        }
        
    }
    
}
