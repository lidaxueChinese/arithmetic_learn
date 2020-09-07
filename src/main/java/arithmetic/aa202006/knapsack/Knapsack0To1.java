package arithmetic.aa202006.knapsack;

/**
 * Created by zuihaodeziji on 2020/9/6.
 * 0/1背包问题
 *
 * f[x][y] 表示到第x个元素，有y个背包剩余容量 条件下的最大价值
 *
 * w[x]表示选择第x个元素,需要花费的背包容量，v[x]表示第x个元素的价值
 * f[x][y] = max{f[x-1][y] , f[x-1][y-w[x]] + v[x]}
 *
 * 背包0/1问题：一个背包要么被选择，要么不被选择
 */
public class Knapsack0To1 {


    public static void main(String[] args) {
        Knapsack0To1 knapsack0To1 = new Knapsack0To1();
        int num = 6;
        int globalCapacity = 10;
        int[] wArr = {2,3,5,3,1,4};
        int[] vArr = {1,1,2,2,1,2};
        int value = knapsack0To1.knapsackMaxValue(num,globalCapacity,wArr,vArr);
        int value2 = knapsack0To1.knapsackMaxValueOptimize(globalCapacity,wArr,vArr);
        System.out.println("the value is:"+value);
        System.out.println("the value is:"+value2);
    }

    /**
     * f[x][y] = max{f[x-1][y] , f[x-1][y-w[x]] + v[x]} 的实现。
     * 时间复杂度为 x * y
     * 空间复杂度 x * y
     * @param num
     * @param globalCapacity
     * @param wArr
     * @param vArr
     * @return
     */
    public int knapsackMaxValue(int num,int globalCapacity,int[] wArr,int[] vArr){


         int[][] arr = new int[num+1][globalCapacity+1];
         for(int i =1;i<=wArr.length;i++){
             for(int j = 1;j<=globalCapacity;j++){
                 int max = arr[i-1][j];
                 if(j>=wArr[i-1]){
                      int chooseValue = arr[i-1][j-wArr[i-1]] + vArr[i-1];

                     if(chooseValue > max){
                         max = chooseValue;
                     }
                 }
                 arr[i][j] = max;
             }
         }

         return arr[num][globalCapacity];

    }

    /**
     * 从上面没有优化的程序，我们可以看到，当遍历到 x个元素，依赖于 max(f(x-1,y),f(x-1,y-w[i])+v[i]),即依赖于第x-1个元素背包剩余容量y 的结果，
     * 我们可以优化，使之变成一维数组 f(y),存放的是前一个元素下背包剩余容量为y的情况下，价值的最大值
     *
     *遍历背包剩余容量 y 一定要倒序，原因：
     * int max = Math.max(arr[j],arr[j-wArr[i-1]] + vArr[i-1]);
     * 当计算j容量时，需要用到比j小的容量的情况，并且要保证是 遍历到x-1个元素时的情况下 。。如果按照正序遍历时，背包剩余容量小的 元素先遍历到了更新成
     * 遍历到x个元素时的情况下了
     * @param
     * @param globalCapacity
     * @param wArr
     * @param vArr
     * @return
     */
    public int knapsackMaxValueOptimize(int globalCapacity,int[] wArr,int[] vArr){


        int[] arr = new int[globalCapacity+1];

        for(int i =1;i<=wArr.length;i++){
            /*for(int j = 1;j<=globalCapacity;j++){
                int max = arr[j];
                if(j>=wArr[i-1]){
                    int chooseValue = arr[j-wArr[i-1]] + vArr[i-1];

                    if(chooseValue > max){
                        max = chooseValue;
                    }
                }
                arr[j] = max;
            }*/

            for(int j = globalCapacity;j>=wArr[i-1];j--){
                int max = Math.max(arr[j],arr[j-wArr[i-1]] + vArr[i-1]);
                arr[j] = max;
            }
        }

        return arr[globalCapacity];

    }


}
