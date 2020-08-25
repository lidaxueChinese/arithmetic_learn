package arithmetic.aa202006.dynamicPlanning;
/**
 * Created by lidaxue on 2020/8/25.
 * leetcode link: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinClimbStairs {

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int arrLength = cost.length;
        int[] minArr = new int[arrLength+1];
        int[] climb2 = new int[arrLength+1]; //最后一条结束位置是 最后一位 还是 最后一位的上一位
        minArr[1] = cost[0];
        climb2[1] = 1;
        for(int i = 2 ;i<= cost.length;i++){
            int endIndex = i;//最后一步以第i个值
            int lastIndex1 = endIndex-2;
            int minValue1 = cost[endIndex-1];
            if(lastIndex1 > 0 && climb2[lastIndex1] == lastIndex1){
                minValue1 = minValue1 + minArr[lastIndex1];
            }

            int lastIndex2 = endIndex-1;
            int minValue2 = cost[endIndex-1];
            if(lastIndex2 > 0){
                minValue2 = minValue2 + minArr[lastIndex2];
            }

            int endIndexLast = i-1;
            int lastIndexLast1 = endIndexLast-2;
            int minValue1Last1 = cost[endIndexLast-1];
            if(lastIndexLast1 > 0 && climb2[lastIndexLast1] == lastIndexLast1){
                minValue1Last1 = minValue1Last1 + minArr[lastIndexLast1];
            }

            int lastIndexLast2 = endIndexLast -1;
            int minValueLast2 = cost[endIndexLast-1];
            if(lastIndexLast2 > 0){
                minValueLast2 = minValueLast2 + minArr[lastIndexLast2];
            }

            int resultMin = minValue1;
            int lastClimbIndex = endIndex;
            if(resultMin > minValue2){
                resultMin = minValue2;
            }
            if(resultMin > minValue1Last1){
                resultMin = minValue1Last1;
                lastClimbIndex = endIndexLast;
            }
            if(resultMin > minValueLast2){
                resultMin = minValueLast2;
                lastClimbIndex = endIndexLast;
            }

            minArr[i] = resultMin;
            climb2[i] = lastClimbIndex;
        }

        System.out.println("==============");
    }
}


