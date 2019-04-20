package leetcode.climbingStairs;

/**
 * @ClassName: Mian
 * @Author: hcy
 * @Description:
 * @Date: 2019-04-18 22:34
 * @Version: 1.0
 **/
public class Main {

    public  static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int res = 0;
            int i = 1, j = 2;
            int k = 3;
            while (k <= n) {
                res = i + j;
                i = j;
                j = res;
                k++;
            }
            return res;
        }
    }

    public static void main(String[] args) {

        int n = 7;
        int i = climbStairs(n);
        System.out.println(i);
    }
}
