package arithmetic;

/**
 * Created by ldxPC on 2018/11/5.
 */
public class DLinkedNode<K,V> {

    public DLinkedNode(){}

    public DLinkedNode(K k,V initValue){
        key = k;
        value = initValue;
    }
    K key;
    V value;
    DLinkedNode pre;
    DLinkedNode post;
}
