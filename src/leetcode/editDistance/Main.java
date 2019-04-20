package leetcode.editDistance;

/**
 * @ClassName: Main
 * @Author: hcy
 * @Description: https://leetcode-cn.com/problems/edit-distance/
 * @Date: 2019-04-20 18:12
 * @Version: 1.0
 **/
public class Main {



    public static void main(String[] args) {

        String word1 = "cafe";
        String word2 = "coffee";
        int i = minDistance(word1, word2);
        System.out.println(i);


    }

    /**
     * 参考： https://blog.csdn.net/baodream/article/details/80417695
     *
     * dp经典题目
     *
     *
     */
    public static int minDistance(String word1, String word2) {

        int len1 = word1.length()+1;
        int len2 = word2.length()+1;

        int[][] map = new int[len1][len2];



        for (int i = 0; i < len2; i++) {
            map[0][i] = i;
        }

        for (int i = 0; i < len1; i++) {
            map[i][0] = i;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    map[i][j] = map[i-1][j-1];
                }else{
                    int tmp = Math.min(map[i][j-1], map[i-1][j]);
                    map[i][j] = Math.min(map[i-1][j-1], tmp)+1;
                }

            }
        }

        return map[len1-1][len2-1];

    }
}
