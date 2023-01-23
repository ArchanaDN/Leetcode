public class SortedRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int index = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }
        int res = -1;
        if(index - 1 >= 0 && nums[0] <= target) {
            res = binarySearch(0, index - 1, nums, target); 
        } else {
            res = binarySearch(index, n - 1, nums, target);
        }
        return res;
    }

    public static int binarySearch(int l, int r, int[] nums, int target) {
        while(l <= r) {
            int mid = (l + r)/2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
    
}
