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


        String str = "2+6/3+10";
        List<String> list = new ArrayList<>();
        char c0 = '0';
        char c9 = '9';

        int lastIndex = 0;
        for(int i=0;i<str.length();i++){
            if(i == str.length() -1){
                //最后一位
                String num = str.substring(lastIndex,str.length());
                list.add(num);
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
        boolean isCompute = false;
        for(int index = list.size()-1; index >= 0;index --){
             if(index % 2 == 0){ //奇数表示数字
                 Integer currentValue = new Integer(list.get(index));
                 if(!isCompute) {
                     numStack.push(currentValue);
                 }else{
                     Integer computeSecondValue = numStack.pop();
                     String ope = opeStack.pop();
                     Integer value = compute(currentValue,computeSecondValue,ope);
                     numStack.push(value);
                     //是否计算还原
                     isCompute = false;

                 }
             }else{ //偶数表示操作符
                 String ope = list.get(index);
                 if(opeStack.isEmpty()){
                     opeStack.push(list.get(index));
                 }else{
                     if(isComputeOpeStr(ope)){//需要计算
                         isCompute =true;
                         opeStack.push(ope);
                     }else{
                       opeStack.push(ope);
                     }
                 }
             }
        }

        int initValue = 0;
        while(true){
           Integer numValue =  numStack.pop();
        }



    }

    private static boolean isComputeOpeStr(String ope){
        int ope1Value = opeStr2Integer(ope);
        if(ope1Value > 0){
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


