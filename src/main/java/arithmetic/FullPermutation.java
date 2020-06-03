package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldxPC on 2019/3/11.
 */
public class FullPermutation {

      public List<String> fullSort(List<String> originList){

           if(originList.size() ==1){
                return originList;
           }

          List<String> resultList = new ArrayList<>();
           for(int i=0;i<originList.size();i++){
                    swap(0,i,originList);

                    String first = originList.get(0);
                    List<String> tempList = fullSort(originList.subList(1,originList.size()));
                    resultList.addAll(println(first,tempList));
                    //在切换回来
                    swap(0,i,originList);

           }
           return resultList;
      }

      public void swap(int oneIndex,int secondIndex,List<String> list){
          //和第一个元素交换
          String tempOrigin = list.get(oneIndex);
          list.set(oneIndex,list.get(secondIndex));
          list.set(secondIndex,tempOrigin);
      }

      public List<String> println(String a,List<String> list){
          List<String> resultList = new ArrayList<>();
          for(int i = 0 ;i<list.size();i++){
              resultList.add(i,a+list.get(i));
          }
          return resultList;

      }

    public static void main(String[] args) {
        FullPermutation obg = new FullPermutation();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> resultList = obg.fullSort(list);
        for(int i = 0 ;i<resultList.size();i++){
            System.out.println("hello:"+resultList.get(i));
        }
    }
}
