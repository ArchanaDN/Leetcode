import java.util.PriorityQueue;

public class MaxEvents {

    public static void main(String[] args) {
        int[][] input = { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } };
        maxEvents(input);
    }

    public static int maxEvents(int[][] events) {
        sort(events);
        // Minimum starting time
        int minD = Integer.MAX_VALUE;
        // maximum ending time
        int maxD = Integer.MIN_VALUE;
        int d = 0;
        for (int i = 0; i < events.length; i++) {
            minD = Math.min(minD, events[i][0]);
            maxD = Math.max(maxD, events[i][1]);
        }
        // Creating priority Queue for min heap for days available
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = minD; i <= maxD; i++) {
            queue.add(i);
        }
        for (int i = 0; i < events.length; i++) {
            if (queue.size() > 0) {
                int minDay = queue.peek();
                if (minDay >= events[i][0] && minDay <= events[i][1]) {
                    queue.poll();
                    d++;
                }
            }
        }
        return d;
    }

    public static void sort(int[][] intervals) {
        int left = 0;
        int right = intervals.length - 1;
        sorting(intervals, left, right);
    }

    public static void sorting(int[][] intervals, int l, int r) {
        if (l < r) {
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
        for (int i = l; i <= mid; i++) {
            left[i - l][0] = intervals[i][0];
            left[i - l][1] = intervals[i][1];
        }
        for (int i = mid + 1; i <= r; i++) {
            right[i - mid - 1][0] = intervals[i][0];
            right[i - mid - 1][1] = intervals[i][1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < lsize && j < rsize) {
            if (left[i][1] > right[j][1]) {
                intervals[k][0] = right[j][0];
                intervals[k][1] = right[j][1];
                j++;
                k++;
            } else if (left[i][1] < right[j][1]) {
                intervals[k][0] = left[i][0];
                intervals[k][1] = left[i][1];
                i++;
                k++;
            } else {
                if (left[i][0] < right[j][0]) {
                    intervals[k][0] = left[i][0];
                    intervals[k][1] = left[i][1];
                    i++;
                    k++;
                } else {
                    intervals[k][0] = right[j][0];
                    intervals[k][1] = right[j][1];
                    j++;
                    k++;
                }
            }
        }

        for (; i < lsize; i++, k++) {
            intervals[k][0] = left[i][0];
            intervals[k][1] = left[i][1];
        }

        for (; j < rsize; j++, k++) {
            intervals[k][0] = right[j][0];
            intervals[k][1] = right[j][1];
        }

    }

}
