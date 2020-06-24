package arithmetic.aa202006.dynamicPlanning;

import java.util.Arrays;

/**
 * Created by zuihaodeziji on 2020/6/21.
 * 该算法是最小零钱，子下向上算法
 */
public class MinMakeChangeOptimize {

    public static void main(String[] args) {
        int[] money = {1,2,35};
                 int sum = 4;
                 int count = money(money, sum);
                 System.out.println(count);
    }

    private static int money(int[] money, int sum) {
                 int[] count = new int[sum + 1];
                 count[0] = 0;
                 for (int j = 1; j < sum + 1; j++) { //总金额数，1,2,3，……，sum
                         int minCoins = j;
                         for (int i = 0; i < money.length; i++) {    //遍历硬币的面值
                                 if (j - money[i] >= 0) {
                                         //todo 还差 j-money[i] 钱,为什么是 count[j-money[i]]+1?
                                         int temp = count[j-money[i]] + 1; //当前所需硬币数
                                         if (temp < minCoins) {
                                                 minCoins = temp;
                                             }
                                    }
                             }

                         count[j] = minCoins;
                     }
                 System.out.println(Arrays.toString(count));
                 return count[sum];
             }

}



