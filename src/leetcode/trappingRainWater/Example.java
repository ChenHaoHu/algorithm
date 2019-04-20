package leetcode.trappingRainWater;

/**
 * @ClassName Example
 * @Author hcy
 * @Description
 * @Date 2019-04-18 21:20
 * @Version 1.0
 **/
public class Example {

    public int trap(int[] height) {
        if (height.length<3)
            return 0;
        int begin,result = 0;
        int[] points = new int[2*height.length];
        int ptr = 0;
        for(begin=0;begin<height.length-1;begin++){
            if(height[begin]<=height[begin+1]){//当前元素值小于下一个元素值时，判断有无凹槽
                while (ptr!=0){
                    if(height[begin+1]>=height[points[ptr-2]]){//下一个元素的值大于栈顶的值，更新result，出栈，继续取值
                        result+=points[ptr-1]*(begin-points[ptr-2]);
                        ptr-=2;
                    }else{//下一个元素的值小于栈顶的值，说明是小凹槽，不出栈，更新result和栈顶的值，结束取值
                        result+=(points[ptr-1] - height[points[ptr-2]] + height[begin+1])*(begin-points[ptr-2]);
                        points[ptr-1]=height[points[ptr-2]] - height[begin+1];
                        break;
                    }
                }
            }else{//下一个元素的值小于此元素的值，将本元素压栈
                points[ptr] = begin;
                points[ptr+1] = height[begin]-height[begin+1];
                ptr+=2;
            }
        }
        return result;
    }

}
