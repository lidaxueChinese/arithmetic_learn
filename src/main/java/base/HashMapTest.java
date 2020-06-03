package base;

import java.util.HashMap;

/**
 * Created by ldxPC on 2018/9/3.
 */
public class HashMapTest {

    public void test(){
        HashMap<String,String> map = new HashMap<String, String>();
        map.get("");
        map.put("","");
       int value =  hashTest("ldx");
       System.out.println(value);
    }

     final int hashTest(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void main(String[] args){
         new HashMapTest().test();
    }
}
