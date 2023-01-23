import java.util.*;
public class MaxAbsDiff {

    public static void main(String[] args) {
        int[] input = {4,2,1,3};
        minimumAbsDifference(input);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if(diff == min) {
                List<Integer> diffList = new ArrayList<>();
                diffList.add(arr[i - 1]);
                diffList.add(arr[i]);
                list.add(diffList);
            } else if(min > diff) {
                list = new ArrayList<>();
                List<Integer> diffList = new ArrayList<>();
                diffList.add(arr[i - 1]);
                diffList.add(arr[i]);
                list.add(diffList);
            }
        }
        return list;
    }
    
}
