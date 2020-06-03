package arithmetic;

/**
 * Created by ldxPC on 2018/10/31.
 */
public class ObjectWait {


    public static void main(String[] args) throws Exception{
         ObjectWait objectWait = new ObjectWait();

         System.out.println("the hello is full");
         synchronized (objectWait){
             objectWait.wait();
             objectWait.notify();

         }



         //objectWait.notify();

         System.out.println("the main end !");

    }
}
