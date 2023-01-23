public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] input = {{1,2},{2,3},{3,4},{1,3}};
        eraseOverlapIntervals(input);
    }


    public  static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) {
            return 0;
        }
        int res = 0;
        //Sort in increasing order of end time
        sort(intervals, 0, n - 1);
        int i = 0;
        int j = i + 1;
        while(i < n && j < n) {
            if(intervals[i][1] > intervals[j][0]) {
                res++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return res;
    }

    public static void sort(int[][] intervals, int l, int r) {
        if(l < r){
            int mid = l + (r - l) / 2;
            sort(intervals, l, mid);
            sort(intervals, mid + 1, r);
            merge(intervals, l, mid, r);
        }
    }
    public static void merge(int[][] intervals, int l, int mid, int r) {
        int lsize = mid - l + 1;
        int rsize = r - mid;
        int[][] left = new int[lsize][2];
        int[][] right = new int[rsize][2];
        for(int i = l; i <= mid; i++) {
            left[i - l][0] = intervals[i][0];
            left[i - l][1] = intervals[i][1]; 
        }

        for(int i = mid + 1; i <= r; i++) {
            right[i - mid - 1][0] = intervals[i][0];
            right[i - mid - 1][1] = intervals[i][1];
        }

        int j = 0;
        int k = 0;
        int f = l;

        while(j < lsize && k < rsize) {
            if(left[j][1] < right[k][1]) {
                intervals[f][0] = left[j][0];
                intervals[f][1] = left[j][1];
                j++;
                f++;
            } else {
                intervals[f][0] = right[k][0];
                intervals[f][1] = right[k][1];
                k++;
                f++;
            }
        }

        for(; j < lsize; j++, f++) {
            intervals[f][0] = left[j][0];
            intervals[f][1] = left[j][1];
        }

        for(; k < rsize; k++, f++) {
            intervals[f][0] = right[k][0];
            intervals[f][1] = right[k][1];
        }
    }
    
}
