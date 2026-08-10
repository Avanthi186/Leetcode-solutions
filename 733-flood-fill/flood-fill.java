class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int oc = image[sr][sc];
       if(oc == color){
        return image;
       }
       dfs(image, sr, sc, oc, color);
       return image;
    }

    public void dfs(int[][] image, int r, int c, int oc, int color){
        image[r][c] = color;
    
    if(r - 1 >= 0 && image[r - 1][c] == oc){
        dfs(image, r - 1, c, oc, color);
    } 
    if( r + 1 < image.length && image[r + 1][c] == oc){
        dfs(image, r + 1, c, oc, color);
    }
    if(c - 1 >= 0 && image[r][ c - 1] == oc){
        dfs(image,r, c - 1, oc, color);
    }
    if(c + 1 < image[0].length && image[r][ c + 1] == oc){
        dfs(image, r, c+1, oc, color);;
    }

    }
}