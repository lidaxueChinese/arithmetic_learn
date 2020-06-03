package arithmetic.dynamicPlanning201910;

import java.util.HashMap;
import java.util.Map;

/** 剪绳子
 * Created by 10718 on 2019/10/20.
 */
public class CutRope {

    static Map<Integer,Integer> map = new HashMap<>();
    //存在重复计算的问题，可以处理过的子问题用map 存储起来
    private static int getCutRopeMaxValue(int n){
        if(n<1){
            return -1;
        }
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int max = n;
        for(int i = 1;i<= n/2;i++){
            int tempPre = map.containsKey(i)? map.get(i):getCutRopeMaxValue(i);
            int tempNext =  map.containsKey(n-i)? map.get(n-i):getCutRopeMaxValue(n-i);
            int tempMaxValue = tempPre * tempNext;
            if(tempMaxValue > max){
                max = tempMaxValue;
            }
        }
        map.put(n,max);
        return max;
    }

    public static void main(String[] args) {
        int maxValue = getCutRopeMaxValue(8);
        System.out.println("the maxValue is:"+maxValue);
    }
}


