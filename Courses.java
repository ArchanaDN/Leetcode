import java.util.*;

public class Courses {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static Set<Integer> set = new HashSet<>();
    public static Map<Integer, List<Integer>> prereqMap = new HashMap<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //DFS with visited Set
        if(numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            if(prereqMap.containsKey(prerequisites[i][0])) {
                List<Integer> pre = prereqMap.get(course);
                pre.add(prerequisites[i][1]);
                prereqMap.put(course, pre);
            } else {
                List<Integer> pre = new ArrayList<>();
                pre.add(prerequisites[i][1]);
                prereqMap.put(course, pre);
            }
        } 
        return dfs(prerequisites[0][0]);
    }

    public static boolean dfs(int course) {
        if(set.contains(course)) {
            return false;
        }
        set.add(course);
        if(prereqMap.get(course) == null) {
            return true;
        }
        Iterator<Integer> pre = prereqMap.get(course).iterator();
        while(pre.hasNext()) {
            boolean possibleToTake = dfs(pre.next());
            if(possibleToTake) {
                pre.remove();
            } else {
                return false;
            }
        }
        return true;
    }
    
}
