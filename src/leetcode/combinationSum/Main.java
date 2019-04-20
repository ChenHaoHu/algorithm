package leetcode.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Author hcy
 * @Description https://leetcode-cn.com/problems/combination-sum/
 * @Date 2019-04-16 21:53
 * @Version 1.0
 *
 *
 *
 *
 *
 * EROOR
 **/
public class Main {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length == 1 && target%candidates[0] == 0){
            ArrayList<Integer> aaa = new ArrayList<>();

            while (target != 0){
                target = target - candidates[0];
                aaa.add(candidates[0]);

            }

            res.add(aaa);
            return res;
        }


        int len1 = candidates.length;
        int len2 = target+1;
        int[][] map = new int[len1][len2];

        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                if (candidates[j] == i){
                    for (int k = 0; k < len1; k++) {
                        map[k][i] = 1;
                    }
                    break;
                }
            }
        }


        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                if (map[j][i] == 1 && i + candidates[j] < len2){
                    map[j][i+candidates[j]] = 1;
                }
            }
        }


        for (int i = 0; i < len1; i++) {
            List<Integer> list = new ArrayList();
            int temp = target;
            while (true){

                if (map[i][temp] == 1){
                   if (temp != target){
                       for (int j = 0; j < len1; j++) {
                           if (candidates[j] == temp && target%candidates[i] != 0){
                               List<Integer> tt = new ArrayList<>();
                               tt.addAll(list);
                               tt.add(temp);
                               res.add(tt);
                           }
                       }
                   }

                    temp = temp - candidates[i];

                    if (temp == 0){
                        if (list.size() != 0){
                            list.add(candidates[i]);
                            res.add(list);
                        }

                    }else{
                        list.add(candidates[i]);
                    }
                    if (temp < 0 ){
                        break;
                    }
                }else{
                    break;
                }
            }
        }

//        res.stream().forEach(integers -> {
//            integers.stream().forEach(integer -> {
//                System.out.print(integer +"-->");
//            });
//            System.out.println();
//        });

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (candidates[i] == target){
                list.add(target);
                res.add(list);
                break;
            }
        }


//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

   //     System.out.println(res.size());


        int a = 0;

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == 2){
                if (res.get(i).get(1) > res.get(i).get(0)){
                    res.remove(i);
                }
                if (res.get(i).get(1) == res.get(i).get(0)&& a ==0){
                    a = 1;
                    res.remove(i);
                }
            }
        }



        return res;

    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        combinationSum(candidates,target);


    }
}
