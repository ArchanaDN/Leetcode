public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 0;
        int sc = 0;
        int color = 0;
        floodFill(image, sr, sc, color);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Let's use depth first search
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;  
    }

    public static void floodFill(int[][] image, int sr, int sc, int color, int rootColor) {
        if((sr < 0 || sr > image.length && sc < 0 || sr > image[0].length) || image[sr][sc] != rootColor) {
            return;
        }
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        if(sr - 1 >= 0 && sr - 1 < m && image[sr - 1][sc] == rootColor && image[sr - 1][sc] != color) {
            floodFill(image, sr - 1, sc, color, rootColor);
        }
        if(sr + 1 >= 0 && sr + 1 < m && image[sr + 1][sc] == rootColor&& image[sr + 1][sc] != color) {
            floodFill(image, sr + 1, sc, color, rootColor);
        }
        if(sc - 1 >= 0 && sc - 1 < n && image[sr][sc - 1] == rootColor && image[sr][sc - 1] != color) {
            floodFill(image, sr, sc - 1, color, rootColor);
        }
        if(sc + 1 >= 0 && sc + 1 < n && image[sr][sc + 1] == rootColor && image[sr][sc + 1] != color) {
            floodFill(image, sr, sc + 1, color, rootColor);
        }
    }


}