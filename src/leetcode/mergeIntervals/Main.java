package leetcode.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Main {

    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> list = new ArrayList<>();

        if (intervals.size() == 0) return list;

        //Sort
        intervals.sort((o1, o2) -> {
            return o1.start - o2.start;
        });




        int size = intervals.size();
        int count = 0;

        int max;

        Interval temp = intervals.get(0);
        list.add(temp);
        max = temp.end;
        for (int i = 1; i < size; i++) {
            //
            temp = intervals.get(i);
            if (temp.start <= max){
                if (temp.end >= max){
                    list.get(count).end = temp.end;
                    max = temp.end;
                }
            }else{
                count++;
                list.add(temp);
                max = temp.end;
            }
        }

//        list.stream().forEach(interval -> {
//            System.out.println("star:" + interval.start +"    end:" + interval.end);
//        });

        return list;
    }

    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        merge(intervals);

    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}