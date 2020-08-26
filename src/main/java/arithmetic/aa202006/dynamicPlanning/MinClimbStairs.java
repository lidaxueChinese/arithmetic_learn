package arithmetic.aa202006.dynamicPlanning;
/**
 * Created by lidaxue on 2020/8/25.
 * leetcode link: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 空间复杂度可以优化 ，该题本质公式是
 * F(n) = Math.min(cost[n]+min(n-1) , cost[n-1]+min(n-2))
 * 本质上还有两种情况：
 * cost[n]+min(n-2)  和 cost[n-1]+min(n-3) 表示跳两级的两种情况
 * 跳两级情况要有条件：需要保证min(x) 并且之前的最后一跳在x位置上而不能在x-1的位置上。。如果满足这种情况 那 min(n-1) 等于min(n-2)
 * 即跳两级的情况可以省略
 *
 * 空间的复杂度是有优化的空间的
 */
public class MinClimbStairs {

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int arrLength = cost.length;
        int[] minArr = new int[arrLength+1];

        minArr[1] = 0;
        minArr[2] = Math.min(cost[0],cost[1]);
        for(int i = 3 ;i<= cost.length;i++){
            int endIndex = i;//最后一步以第i个值
            /*int lastIndex1 = endIndex-2;
            int minValue1 = cost[endIndex-1];
            if(lastIndex1 > 0 && climb2[lastIndex1] == lastIndex1){
                minValue1 = minValue1 + minArr[lastIndex1];
            }*/

            int lastIndex2 = endIndex-1;
            int minValue2 = cost[endIndex-1]; //第i 个cost消耗
            if(lastIndex2 > 0){
                minValue2 = minValue2 + minArr[lastIndex2]; //Min(i-1)
            }

            int endIndexLast = i-1;
            /*int lastIndexLast1 = endIndexLast-2;
            int minValue1Last1 = cost[endIndexLast-1];
            if(lastIndexLast1 > 0 ){
                minValue1Last1 = minValue1Last1 + minArr[lastIndexLast1];
            }*/

            int lastIndexLast2 = endIndexLast -1;
            int minValueLast2 = cost[endIndexLast-1]; //第i-1 个cost消耗
            if(lastIndexLast2 > 0){
                minValueLast2 = minValueLast2 + minArr[lastIndexLast2]; //Min(i-2)
            }


            minArr[i] = Math.min(minValue2,minValueLast2);

        }

        System.out.println("==============");
    }
}


