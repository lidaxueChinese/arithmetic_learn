package arithmetic.aa202006.data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lidaxue on 2020/9/2.
 * 实现lru map
 *
 * 注意点：
 * 1.当我们 删除元素 或者 添加元素 到头元素的时候，往往护理 pre指针 的维护
 * 2. 添加/删除 元素的时候，需要维护size 的大小
 */
public class LruMap<K,V> {

    private class Node<K,V>{
        K key;
        V value ;
        Node<K,V> pre;
        Node<K,V> next;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    private Map<K,Node> cacheMap = new HashMap<K, Node>();

    private int capacity =10;

    //元素数量
    private int size = 0;

    private Node<K,V> head  = null;

    private Node<K,V> tail = null;

    private LruMap(int capacity){
        this.capacity = capacity;
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.pre = head;
    }

    private void set(K key,V value){
        if(cacheMap.containsKey(key)){
            //删除元素原来的位置，将该元素插入到链表头部，和get操作是一样的
            get(key);
        }else{
            Node<K,V> newNode = new Node<>(key,value);
            addToHead(newNode);
            cacheMap.put(key,newNode);
            //判断是否达到上限值
            if(size > capacity){
                //链表 删除最后一个元素
                Node lastNode = tail.pre;
                deleteNode(lastNode);
                //同步删除map中的元素
                cacheMap.remove(lastNode.key);
            }
        }
    }

    private  V get(K key){
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            deleteNode(node);
            addToHead(node);
            return  (V)node.getValue();
        }else{
            return null;
        }
    }

    //将该元素从列表中删除
    private void deleteNode(Node node){
        //node的前一个元素 指向 该元素的下一个元素
        Node nodeLast = node.pre;
        Node nodeNext = node.next;
        nodeLast.next = nodeNext;
        nodeNext.pre = nodeLast;
        node.pre = null;
        node.next = null;
        size --;
    }

    private void addToHead(Node node){
      Node oriHeadNextNode =  head.next;
      head.next = node;

      node.next = oriHeadNextNode;
      node.pre = head;

      oriHeadNextNode.pre = node;
      size ++;
    }

    private void printLink(){
        StringBuilder stringBuffer = new StringBuilder();
        Node node = head;
        while(node != null){
            stringBuffer.append(node.getKey()).append("-->");
            node = node.next;
        }
       System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
        LruMap<String,Integer> lruCache = new LruMap<>(3);
        lruCache.set("7",7);
        lruCache.printLink();
        lruCache.set("0",0);
        lruCache.printLink();
        lruCache.set("1",1);
        lruCache.printLink();
        lruCache.set("2",2);
        lruCache.printLink();
        lruCache.get("0");
        lruCache.printLink();
        lruCache.set("3",3);
        lruCache.printLink();
        lruCache.get("0");
        lruCache.printLink();
        lruCache.set("4",4);
        lruCache.printLink();
    }


}
