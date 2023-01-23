public class InsertInterval {

    public static void main(String[] args) {
        // int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        // int[] newInterval = {4,8};
        // int[][] intervals = {{1,3},{6,9}};
        // int[] newInterval = {2,5};
        int[][] intervals = {{1,5}};
        int[] newInterval = {6,8};

        insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            if((newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) || 
            (newInterval[0] <= intervals[i][0] &&  newInterval[1] >= intervals[i][1]) || 
            (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1])) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        if (start >= 0 && start <= n) {
            int len = n - (end - start);
            int[] mergedInterval = new int[2];
            mergedInterval[0] = Math.min(intervals[start][0], newInterval[0]);
            mergedInterval[1] = Math.max(intervals[end][1], newInterval[1]);
            int[][] overlapped = new int[len][2];
            for(int i = 0; i < n; i++) {
                if(i < start) {
                    overlapped[i][0] = intervals[i][0];
                    overlapped[i][1] = intervals[i][1];
                } else if(i == start) {
                    overlapped[i][0] = mergedInterval[0];
                    overlapped[i][1] = mergedInterval[1];
                    i = end;
                } else if(i > start) {
                    overlapped[i - (end - start)] = intervals[i];
                }
            }
            return overlapped;
        } else {
            int len = n + 1;
            boolean flag = false;
            int[][] overlapped = new int[len][2];
            

            // for (int i = 0; i < n + 1; i++) {
            //     if(i < n && newInterval[0] < intervals[i][1]) {
            //         overlapped[i] = newInterval;
            //         flag = true;
            //         overlapped[i] = intervals[i];
            //     } else if(flag){
            //         overlapped[i] = intervals[i - 1];
            //     } else if(i < n && newInterval[0] <= intervals[i][1]){
            //         overlapped[i] = newInterval;
            //         flag = true;
            //     }
            // }
            return overlapped;
        }
    }
    
}
