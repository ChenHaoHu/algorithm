package leetcode.minimumPathSum;

/**
 * @ClassName: Main
 * @Author: hcy
 * @Description: https://leetcode-cn.com/problems/minimum-path-sum/
 * @Date: 2019-04-18 22:17
 * @Version: 1.0
 **/
public class Main {


    public static int minPathSum(int[][] grid) {
        int res = 0;

        int len1 = grid.length;
        int len2 = grid[0].length;

        for (int i = 1; i < len2; i++) {
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }
        for (int i = 1; i < len1; i++) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }


        return grid[len1-1][len2-1];

    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        int i = minPathSum(grid);
        System.out.println(i);
    }
}
