package leetcode.sortColors;

import java.util.Arrays;

/**
 * @ClassName: Main
 * @Author: hcy
 * @Description: https://leetcode-cn.com/problems/sort-colors/
 * @Date: 2019-04-20 19:14
 * @Version: 1.0
 **/
public class Main {


    //常数空间
    //一次扫描
    public static void sortColors(int[] nums) {

        //three points
        int star = 0;
        int end = nums.length-1;

        for (int j = 0; j <= end; j++) {

            if (nums[j] == 0){
                swap(nums,star,j);
                star++;
                if (nums[j] != 0){
                    j--;
                }
            }else   if (nums[j] == 2){
                swap(nums,end,j);
                end--;
               if (nums[j] == 0 || nums[j] == 2) {
                   j--;
               }
            }


        }

    }


    public static void swap(int[] nums, int i, int j){

        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {


        int[] nums = {2,1,2};
        sortColors(nums);
        Arrays.stream(nums).forEach(value -> {
            System.out.print(value+"  ");
        });
    }
}
