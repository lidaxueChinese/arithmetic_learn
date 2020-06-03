package base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldxPC on 2019/2/15.
 */
public class BaseTest {

    public static void main(String[] args){
          /*String ff = new String("1705");
          Integer integer = new Integer(135000);

          System.out.println("ff.hashcode is :"+ff.hashCode());

          System.out.println("integer.hashcode is :"+integer.hashCode());

          System.out.println(ff.hashCode() >>> 16);*/
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        List<String> ff = list.subList(1,2);
        System.out.println(ff);

    }
}
