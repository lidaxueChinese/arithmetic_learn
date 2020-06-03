package arithmetic.recursion201910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串翻译
 * 注意点：
 * 1. 重复计算的问题，如果遇到 f(n) = f(n-1) + f(n-2)的问题时，需要注意重复计算的问题
 * 2. 该递归也是一个数值  产生List结果的过程
 *
 * Created by 10718 on 2019/10/26.
 */
public class StringTranslate {

    private static Map<String,List<String>> cacheMap = new HashMap<>();

    private static List<String> translate(String str){
        if(str == null){
            return null;
        }
        if(cacheMap.containsKey(str)){
            return cacheMap.get(str);
        }
        List<String> list = new ArrayList<>();
       if(str.length() ==1){
           list.add(getMapValue(str));
           return list;
        }else if(str.length() ==2){
            //take one
            String oneMapValue = getMapValue(str.substring(0,1));
            List<String> subList = translate(str.substring(1,str.length()));
            mergeList(list,oneMapValue,subList);

            if(new Integer(str) <=25){
                list.add(getMapValue(str));
            }
            cacheMap.put(str,list);
            return list;
        }else{
            //take one
            String oneMapValue = getMapValue(str.substring(0,1));
            List<String> subListOne = translate(str.substring(1,str.length()));
            mergeList(list,oneMapValue,subListOne);

            if(new Integer(str.substring(0,2)) <=25){
                String twoMapValue = getMapValue(str.substring(0,2));
                List<String> subListTwo = translate(str.substring(2,str.length()));
                mergeList(list,twoMapValue,subListTwo);
            }
           cacheMap.put(str,list);
            return list;

        }

    }

    private static void mergeList(List<String> list,String str,List<String> subList){
        if(subList != null){
            for(int i =0;i<subList.size();i++){
                list.add(str+subList.get(i));
            }
        }
    }


    private static String getMapValue(String v){
        String value = "-1";
        if(v.equals("0")){
            value="a";
        }else if(v.equals("1")){
            value="b";
        }else if(v.equals("2")){
            value="c";
        }else if(v.equals("3")){
            value="d";
        }else if(v.equals("4")){
            value="e";
        }else if(v.equals("5")){
            value="f";
        }else if(v.equals("6")){
            value="g";
        }else if(v.equals("7")){
            value="h";
        }else if(v.equals("8")){
            value="i";
        }else if(v.equals("9")){
            value="j";
        }else if(v.equals("10")){
            value="k";
        }else if(v.equals("11")){
            value="l";
        }else if(v.equals("12")){
            value="m";
        }else if(v.equals("13")){
            value="n";
        }else if(v.equals("14")){
            value="o";
        }else if(v.equals("15")){
            value="p";
        }else if(v.equals("16")){
            value="q";
        }else if(v.equals("17")){
            value="r";
        }else if(v.equals("18")){
            value="s";
        }else if(v.equals("19")){
            value="t";
        }else if(v.equals("20")){
            value="u";
        }else if(v.equals("21")){
            value="u";
        }else if(v.equals("22")){
            value="w";
        }else if(v.equals("23")){
            value="x";
        }else if(v.equals("24")){
            value="y";
        }else if(v.equals("25")){
            value="z";
        }else{
            value = "-1";
        }

        return value;
    }

    public static void main(String[] args) {
        String orinal = "122586585846224122627421361386386338613816613183638163444123458842662537587374182834757823859364";
        long startTime = System.currentTimeMillis();
        List<String> translateList = translate(orinal);
        System.out.println("cost time:"+(System.currentTimeMillis()-startTime));
    }
}
