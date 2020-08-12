package arithmetic.aa202006.base;/**
 * Created by lidaxue on 2020/8/12.
 * 对输入的数开方，要求保留4为小数
 */
public class KaifangToNum {

    public static void main(String[] args) {

        double value = new Double("1");

        //TODO 对0进行特殊处理
        if(value == 0){
            System.out.println("the 开方 值是:"+0);
            return;
        }
        double lValue = 0;
        double rValue = value;
        while(rValue-lValue >= 1e-4){
            double middle = (lValue+rValue) /2;
            double pValue = middle*middle;
            //经过middle后，原本可以准确开方，不需要求近似值的值，可能并不能得到准确开方值了
            if(pValue==value){
                lValue = middle;
                break;
            }else if(pValue>value){
                rValue = middle;
            }else{
                lValue = middle;
            }
        }

        System.out.println("the 开方 值是:"+lValue);

    }
}
