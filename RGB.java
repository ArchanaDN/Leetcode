public class RGB {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter size of array :");
        // int n = sc.nextInt();
        int n = 6;
        String[] arr = {"R", "B", "R", "G", "G", "G"};
        sortRGB(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void sortRGB(String[] arr) {
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if(arr[mid] == "R") {
                //Swap mid and low
                String temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            } else if(arr[mid] == "G") {
                mid++;
            } else {
                //swap mid and high
                String temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
