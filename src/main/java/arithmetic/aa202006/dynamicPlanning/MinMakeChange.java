package arithmetic.aa202006.dynamicPlanning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zuihaodeziji on 2020/6/21.
 * 找零钱：给定6种钱币面值为2、5、10、20、100
 */
public class MinMakeChange {

    static int[] changeNum = {100,50,20,10,5,2};
    static int length = changeNum.length;
    //static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
      int num =  mackChange(101,0);
      System.out.println("interget maxValue is:"+Integer.MAX_VALUE);
      System.out.println("num is:"+num);
    }

    /**
     *
     * @param charge
     * @param lastChangeIndex
     * @return
     */
    private static int mackChange(int charge,int lastChangeIndex){
        /*if(map.containsKey(charge)){
            return map.get(charge);
        }*/
        int changeIndex = getChangeIndex(charge);
        if(changeIndex < 0){
            return -1;
        }
        //取零钱面值 不能比上一次的大，不然出现重复操作
        if(changeIndex < lastChangeIndex){
            changeIndex = lastChangeIndex;
        }
        int minNum =Integer.MAX_VALUE;
        for(int i = changeIndex;i<length;i++){
            int changeValue = changeNum[i];
            int subCharge = charge - changeValue;
            if(subCharge == 0){
                return 1;
            }else if(subCharge < 0){
                System.out.println("should not access the branch");
                continue;
            }
            int subNum = mackChange(charge-changeValue,i);
            if(subNum < 0){
                //TODO 出现异常的情况应该是continue，而不是return，其实可以简单的将for简单的看出一层for循环
               continue;
                //return -1;
            }
            int num = subNum +1;
            if(minNum > num){
                minNum  = num;
            }
        }
        //说明没有找零钱的方式
        if(minNum ==Integer.MAX_VALUE){
            return -1;
        }
        //map.put(charge,minNum);
        return  minNum;
    }

    //获取可以取零钱的最大索引
    private static int getChangeIndex(int charge){
        for(int index=0; index< length; index ++){
            if(charge >= changeNum[index]){
                return index;
            }
        }
        return -1;
    }
}
