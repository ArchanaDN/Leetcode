import java.util.*;

public class KClosestToOrigin {

    public static void main(String[] args) {
        // int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        // int[] newInterval = {4,8};
        // int[][] intervals = {{1,3},{6,9}};
        // int[] newInterval = {2,5};

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        kClosest(points, k);
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        Map<Double, List<Integer>> map = new HashMap<>();
        int m = points.length;
        for(int i = 0; i < m; i++) {
            double val = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            minHeap.add(val);
            if(map.containsKey(val)) {
                List<Integer> point = map.get(val);
                point.add(i);
                map.put(val, point);
            } else {
                List<Integer> point = new ArrayList<>();
                point.add(i);
                map.put(val, point);
            }      
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(k > 0) {
            double val = minHeap.poll();
            List<Integer> point = map.get(val);
            int pointsSize = point.size() - 1;
            k -= point.size();
            while(pointsSize >= 0) {
                result[i][0] = points[point.get(pointsSize)][0];
                result[i][1] = points[point.get(pointsSize)][1];
                pointsSize--;
                i++;
            }
        }
        return result;
    }
    
}
