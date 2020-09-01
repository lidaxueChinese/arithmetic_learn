package arithmetic.aa202006.dynamicPlanning;
/**
 * Created by lidaxue on 2020/9/1.
 * 剪绳子，采用自下而上的做法，不用递归来处理
 *
 * 时间复杂度：1/2 + 2/2 + 3/2 + ... + n/2   总体 O(n^2)
 * 空间复杂度 O(n)
 */
public class CutRope {


    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        int n = 5;
        int maxValue = cutRope.maxMultiple(n);
        System.out.println("the max value is:"+maxValue);
    }

    private int maxMultiple(int n){
        int[] maxValue = new int[n+1];
        maxValue[1] = 1;
        maxValue[2] = 2;
        maxValue[3] = 3;
        maxValue[4] = 4;
        if(n <= 4){
            return maxValue[n];
        }
        for(int v = 5 ;v<=n ;v++){
            int maxV = v;
            for(int j = 1;j<= v/2;j++){
               int tempMax = maxValue[j] * maxValue[v-j];
               if(maxV < tempMax){
                   maxV = tempMax;
               }
            }
            maxValue[v] = maxV;
        }

        return maxValue[n];

    }
}
