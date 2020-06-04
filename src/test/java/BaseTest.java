import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10718 on 2019/10/22.
 */
public class BaseTest {


   static  Map<Integer,Integer> cacheMap = new HashMap<Integer,Integer>();
   static int modValue = 1000000007;

    public static void main(String[] args) {
        waysToChange(10);
    }

    public static int waysToChange(int n) {
        initCacheMap();
        int totalWays = totalWays(n);
        System.out.println("totalWays is :"+totalWays);
        return totalWays % modValue;

    }

    private static void initCacheMap(){
        cacheMap.put(1,1);
        cacheMap.put(5,2);
    }
    private static int totalWays(int n) {
        int ways = 0;
        if(n >= 0){
            if(cacheMap.containsKey(n)){
                return cacheMap.get(n);
            }
            if(n==0){
                return 1;
            }
            int subtract25 =  totalWays(n-25);
            if(validWay(subtract25)){
                ways += subtract25;
            }
            int subtract10 =  totalWays(n-10);
            if(validWay(subtract10)){
                ways += subtract10;
            }
            int subtract5 =  totalWays(n-5);
            if(validWay(subtract5)){
                ways +=subtract5;
            }
            //存在重复过程。。。
            int subtract1 = totalWays(n-1);
            if(validWay(subtract1)){
                ways +=subtract1;
            }
            //没有任何组成方法
            ways = ways>0?ways:-1;
            cacheMap.put(n,ways);
            return ways;
        }else{ //后面无解
            return -1;
        }


    }



    private static boolean validWay(int wayResult){
        if(wayResult > 0){
            return true;
        }
        return false;
    }
}
