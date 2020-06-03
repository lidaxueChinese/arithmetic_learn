package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldxPC on 2019/3/9.
 *
 * 该部分会写两种方式，一种是递归，一种的平铺 ..递归有时候写起来简单，但是可能存在重复计算的问题
 *
 * 描述
 */
public class RecursionLearn {


    //递归做法(自上而下)
    public List<String> recursion(String originStr){
        List<String> list = new ArrayList<>();
        if(originStr.length()==1){
            list.add(getMapValue(originStr));
             return list;
        }

        Character a = originStr.charAt(0);
        if(a.toString().equals("1") || a.toString().equals("2")){ //有两种分法
            if(originStr.length()==2){
                list.addAll(getListToStr(getMapValue(originStr.substring(0,1)),recursion(originStr.substring(1))));//add one

                list.add(getMapValue(originStr.substring(0,2))); //add two
                return list;
            }else{
                list.addAll(getListToStr(getMapValue(originStr.substring(0,1)),recursion(originStr.substring(1))));//add one

                list.addAll(getListToStr(getMapValue(originStr.substring(0,2)),recursion(originStr.substring(2)))); //add two
               return list;
            }

        }else{ //仅仅有一种分法
            list.addAll(getListToStr(getMapValue(originStr.substring(0,1)),recursion(originStr.substring(1))));//add one
            return list;
        }


        //return list;

    }




    //for循环(自下而上)
    public void forCycle(String originStr){

    }


    public String getMapValue(String v){
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

    public List<String> getListToStr(String ori,List<String> list){
        for(int i = 0 ;i<list.size();i++){
            list.set(i,ori+list.get(i));
        }
        return list;

    }
   public static void main(String[] args){

       RecursionLearn recursionLearn = new RecursionLearn();
       List<String> list = recursionLearn.recursion("12258");

       System.out.println("the hello");
   }
}

