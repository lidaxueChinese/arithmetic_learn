package arithmetic;

/**
 * Created by ldxPC on 2019/2/28.
 * 本文主要记录剪绳子，长度为n的绳子，把绳子剪成m段（n m 都是整数 n>1 m>1）
 */
public class DynamicPlanning01 {

    public static int maxMulitipy(int n){
         if(n == 1){
             return 1;
         }else if(n == 2){
             return 2;
         }else if(n == 3){
             return 3;
         }else{
             int middleIndex = n/2;
             int max = n;
             for(int i = 1;i<=middleIndex;i++){
                 int tempMax = maxMulitipy(i) * maxMulitipy(n-i);
                 if(tempMax > max){
                     max = tempMax;
                 }
             }
             return max;
         }
    }


    public static void main(String[] args){
        /*int max =  out.print(max);*/
     int n =10;
        int t = 0;  //用来记录位数
               int bin = 0; //用来记录最后的二进制数
              int r = 0;  //用来存储余数
               while(n != 0){
                      r = n % 2;
                      n = n / 2;
                       bin += r * Math.pow(10,t);
                       t++;
                  }
                 System.out.println(bin);


    }
}
