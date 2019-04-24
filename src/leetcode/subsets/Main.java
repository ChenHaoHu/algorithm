package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Main
 * @Author: hcy
 * @Description: https://leetcode-cn.com/problems/subsets/
 * @Date: 2019-04-24 19:19
 * @Version: 1.0
 **/
public class Main {


    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> data = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        data.add(temp);
        int b = 0;
        List<Integer> a;

        for (int i = 0; i < nums.length; i++) {
            temp = new ArrayList<>();
            temp.add(nums[i]);
            data.add(temp);
        }


        for (int j = 1; j < data.size(); j++) {
            a = data.get(j);
            b = a.get(a.size() - 1);
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] == b && k<nums.length){
                    for (int l = k+1; l < nums.length; l++) {
                        temp = new ArrayList<>(a);
                        temp.add(nums[l]);
                        data.add(temp);
                    }
                    break;
                }
            }
        }

        return data;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> subsets = subsets(nums);
        subsets.stream().forEach(integers -> {
            integers.stream().forEach(integer -> {
                System.out.print(integer);
            });
            System.out.println();
        });
    }
}
