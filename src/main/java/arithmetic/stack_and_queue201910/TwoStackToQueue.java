package arithmetic.stack_and_queue201910;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 用两个栈来实现队列，有点像 -1 * -1  的原理
 * Created by 10718 on 2019/10/18.
 */
public class TwoStackToQueue {
    static Stack<String> put_stack = new Stack<>();
    static Stack<String> get_stack = new Stack<>();

    private static void put(String data){
        put_stack.add(data);
    }
    private static String get(){
        if(get_stack.isEmpty()){ //从put_stack拉取数据
            while (!put_stack.isEmpty()){
                get_stack.push(put_stack.pop());
            }
        }

        return get_stack.isEmpty()?null:get_stack.pop();
    }

    public static void main(String[] args) {
        put("1");
        put("2");
        String get1 = get();
        put("3");
        String get2  = get();
        String get3 = get();
        String get4 = get();
        String get5 = get();
        System.out.println("");
    }
}
