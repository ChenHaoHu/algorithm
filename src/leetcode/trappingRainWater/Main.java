package leetcode.trappingRainWater;

/**
 * @ClassName Main
 * @Author hcy
 * @Description https://leetcode-cn.com/problems/trapping-rain-water/
 * @Date 2019-04-17 17:09
 * @Version 1.0
 **/
public class Main {


    public static int trap(int[] height) {

        // water num
        int count = 0;

        int i=0;
        int j=0;
        int maxPoint = 0;
        int len = height.length;

        int max = height[0];

        for (int k = 0; k < len; k++) {
            if (max <= height[k]){
                max = height[k];
                maxPoint = k;
            }
        }

        while (true){

            for (int k = 0; k < maxPoint; k++) {
                
            }

        }

      //  return  count;
    }


    public static void main(String[] args) {


        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);

    }
}
