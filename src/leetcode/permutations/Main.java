package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Author hcy
 * @Description https://leetcode-cn.com/problems/permutations/
 * @Date 2019-04-18 21:39
 * @Version 1.0
 **/
public class Main {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> temp;
        List<Integer> list;
        temp = new ArrayList<>();
        temp.add(nums[0]);
        res.add(temp);
        for (int i = 1; i < len; i++) {
            int len2 = res.size();
            for (int j = 0; j < len2; j++) {
                list = res.get(0);
                for (int k = 0; k < list.size()+1; k++) {
                    temp = new ArrayList<>(list);
                    temp.add(k,nums[i]);
                    res.add(temp);
                }
                res.remove(0);
            }


        }


        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);

        permute.stream().forEach(integers -> {
            integers.stream().forEach(integer -> {
                System.out.print(integer+"   ");
            });
            System.out.println();
        });
    }
}

