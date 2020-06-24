package arithmetic.aa202006.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lidaxue on 2020/6/24.
 * 字符串表达式： 2+6/3+10
 */
public class StrExpress {

    public static void main(String[] args) {


        String str = "2+8/2*4+10-3*4+6";
        List<String> list = new ArrayList<>();
        char c0 = '0';
        char c9 = '9';

        int lastIndex = 0;
        for(int i=0;i<=str.length();i++){
            if(i == str.length()){
                //最后一位
                String num = str.substring(lastIndex,str.length());
                list.add(num);
                break;
            }
            //数字
           if(c0 <= str.charAt(i) && str.charAt(i) <= c9){
               System.out.println("is the nun");
           }else{
               //截取数字
               String num = str.substring(lastIndex,i);
               list.add(num);
               //符号占一位
               list.add(new Character(str.charAt(i)).toString());
               lastIndex = i+1;
               i = lastIndex;

           }
        }

        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> opeStack = new Stack<>();

        //是否需要计算，如果出现currentOpe 小于 lastOpe
        //boolean isCompute = false;
        for(int index = list.size()-1; index >= 0;index --){
             if(index % 2 == 0){ //奇数表示数字
                 Integer currentValue = new Integer(list.get(index));
                 numStack.push(currentValue);
             }else{ //偶数表示操作符
                 String ope = list.get(index);
                 if(opeStack.isEmpty()){
                     opeStack.push(list.get(index));
                 }else{
                     while(true) {
                         String lastOpe = opeStack.peek();
                         if(opeStack.isEmpty()){
                             break;
                         }else if (isGreaterOpeEqualStr(ope, lastOpe)) {//需要计算
                             break;
                         } else {

                             Integer firstNum = numStack.pop();
                             String computeOpe = opeStack.pop();
                             Integer secondNum = numStack.pop();
                             Integer value = compute(firstNum, secondNum, computeOpe);
                             numStack.push(value);
                         }
                     }
                     opeStack.push(ope);
                 }
             }
        }

        int initValue = 0;
        while(true){
           Integer numValue =  numStack.pop();
        }



    }

    private static boolean isGreaterOpeEqualStr(String ope1,String ope2){
        int ope1Value = opeStr2Integer(ope1);
        int ope2Value = opeStr2Integer(ope2);
        if(ope1Value >= ope2Value){
            return true;
        }else{
            return false;
        }
    }

    private static Integer opeStr2Integer(String opeStr){
        int value = 0;
        switch (opeStr){
            case "*":
             value = 1;
             break;
            case "/":
                value = 1;
                break;
        }
        return value;
    }

    private static Integer compute(Integer firstValue,Integer secondValue,String ope){
        int value = 0;
        switch (ope){
            case "+":
                value = firstValue + secondValue;
                break;
            case "-":
                value = firstValue - secondValue;
                break;
            case "*":
                value = firstValue * secondValue;
                break;
            case "/":
                value = firstValue / secondValue;
                break;
        }
        return value;
    }

}


