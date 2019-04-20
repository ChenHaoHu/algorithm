package leetcode.uniquePaths;

/**
 * @ClassName Main
 * @Author hcy
 * @Description https://leetcode-cn.com/problems/unique-paths/
 * @Date 2019-04-14 18:42
 * @Version 1.0
 **/
public class Main {

    public static int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0){
                    map[i][j] = 1;
                }else{
                    if (i-1>=0){
                        map[i][j] = map[i-1][j]+ map[i][j];
                    }
                    if (j-1>=0){
                        map[i][j] = map[i][j-1]+map[i][j];
                    }
                }

            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + "   ");
//            }
//            System.out.println();
//        }

        return map[n-1][m-1];


    }


    public static void main(String[] args) {

        int i = uniquePaths(7, 3);
        System.out.println(i);


    }
}
