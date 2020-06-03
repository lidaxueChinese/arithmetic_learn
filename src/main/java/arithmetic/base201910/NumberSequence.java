package arithmetic.base201910;
/**数字序列
 * 数字以01234567891011121314等排序，求第n个数组对应的值
 * Created by 10718 on 2019/10/26.
 */
public class NumberSequence {

    //第level位 数字总共有多少位
    private static int getCount(int level){
        //level肯定要大于0
        if(level ==1){
            return 10;
        }else{
           Double value =  Math.pow(10,level-1) * 9 * level;
           return value.intValue();
        }
    }
    //假设训寻到最多10位数
    private static void findNum(int n){
        for(int i=1;i<=10;i++){
            if(n> getCount(i)){
                n -= getCount(i);
            }else{
               int c= n / i;
               int mod = n % i;
               int value = new Double(Math.pow(10,i-1)).intValue();
               //value 中取第mod位
            }
        }
    }
}
