import java.util.*;
public class Permuations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }

    public static List<List<Integer>> result;
    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int k = nums.length;
        permutation(nums, 0, k, new ArrayList<>()); 
        return result;
    }

    public static void permutation(int[] nums, int startpoint, int k, List<Integer> res) {
        if(k == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        for(int i = startpoint; i < nums.length; i++) {
            res.add(nums[i]);
            swap(nums, i , startpoint, nums.length);
            permutation(nums, startpoint + 1, k - 1, res);
            swap(nums, i , startpoint, nums.length);
            int resSize = res.size();
            res.remove(resSize - 1);
        }

    }

    public static void swap(int[] nums, int i, int j, int n) {
        // i = i % n;
        // j = j % n;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
