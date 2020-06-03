package arithmetic.string201910;

import java.util.ArrayList;
import java.util.List;


/**字符串全排列
 * 将一个复杂的问题 分解成多个小问题-做到各个击破
 * Created by 10718 on 2019/10/22.
 */
public class StringFullPermutation {

    private static List<String> fullPermutation(List<String> list){
        if (list == null) {
            return null;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String firstValue = list.get(i);
            swap(list,0,i);
            List<String> subResult = fullPermutation(list.subList(1,list.size()));
            result.add(combineStr(firstValue,subResult));
            swap(list,i,0);
        }
        return result;

    }

    private static List<String> swap(List<String> r, int leftIndex,int rightIndex){
        if(leftIndex == rightIndex){
            return r;
        }else{
            String swapValue = r.get(leftIndex);
            r.set(leftIndex,r.get(rightIndex));
            r.set(rightIndex,swapValue);
            return r;
        }
    }

    private static String combineStr(String headStr,List<String> subList){
        StringBuilder builder = new StringBuilder();
        builder.append(headStr);
        for(int j = 0;j<subList.size();j++){
            builder.append(subList.get(j));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

    }
}
