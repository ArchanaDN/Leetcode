import java.util.*;

public class IntervalMerge {

    public static void main(String[] args) {
        int[][] input = {{1,4},{1,4}};
        merge(input);
    }

    public static int[][] merge(int[][] intervals) {
        //Sort based on the starting index. If start(i) < end(i) -> merge
        sort(intervals);
        List<List<Integer>> res = new ArrayList<>(); 
        int k = 0;
        List<Integer> r = new ArrayList<>();
        r.add(intervals[0][0]);
        r.add(intervals[0][1]);
        res.add(r);
        for(int i = 1; i< intervals.length; i++) {
            if(intervals[i][0] <= res.get(k).get(1)) {
                List<Integer> prev = res.get(k);
                prev.set(1, intervals[i][1]);
            } else {
                List<Integer> next = new ArrayList<>();
                next.add(intervals[i][0]);
                next.add(intervals[i][1]);
                res.add(next);
                k++;
            }
        }

        int[][] result = new int[res.size()][2];
        int i =0;
        for(List<Integer> lis : res) {
            result[i][0] = lis.get(0);
            result[i][1] = lis.get(1);
            i++;
        }
        return result;

    }

    public static void sort(int[][] intervals) {
        int left = 0;
        int right = intervals.length - 1;
        
        sorting(intervals, left, right);
    }

    public static void sorting(int[][] intervals, int l, int r) {
        if(l < r) {
            int mid = l + (r - l) / 2;
            sorting(intervals, l, mid);
            sorting(intervals, mid + 1, r);
            merge(intervals, l, mid, r);
        }
    }

    public static void merge(int[][] intervals, int l, int mid, int r) {
        int lsize = mid - l + 1;
        int rsize = r - mid;
        int[][] left = new int[lsize][2];
        int[][] right = new int[rsize][2];
        for(int i = l; i <= mid; i++) {
            left[i-l][0] = intervals[i][0];
            left[i-l][1] = intervals[i][1];
        }
        for(int i = mid + 1; i <= r; i++) {
            right[i-mid - 1][0] = intervals[i][0];
            right[i-mid - 1][1] = intervals[i][1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < lsize && j < rsize) {
            if(left[i][0] > right[j][0]) {
                intervals[k][0] = right[j][0];
                intervals[k][1] = right[j][1];
                j++;
                k++;
            } else if(left[i][0] <= right[j][0]) {
                intervals[k][0] = left[i][0];
                intervals[k][1] = left[i][1];
                i++;
                k++;
            }
        }

        for(; i < lsize; i++, k++) {
            intervals[k][0] = left[i][0];
            intervals[k][1] = left[i][1];
        }

        for(; j < rsize; j++, k++) {
            intervals[k][0] = right[j][0];
            intervals[k][1] = right[j][1];
        }

    }
    
}

