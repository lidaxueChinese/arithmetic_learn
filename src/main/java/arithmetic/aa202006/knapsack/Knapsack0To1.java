package arithmetic.aa202006.knapsack;

/**
 * Created by zuihaodeziji on 2020/9/6.
 * 0/1背包问题
 */
public class Knapsack0To1 {


    public int KnapsackMaxValue(int[] w,int[] v,int value){

         int[] valueArr = new int[w.length+1];
         int len = w.length;
         for(int i =1;i<=len;i++){
             int max = valueArr[i-1];
             if(value >= w[i]){
                  int tempMax = valueArr[i-1]+v[i];
                  if(max < tempMax){
                      max = tempMax;
                      value-=w[i];
                  }
             }

         }
    }
}
