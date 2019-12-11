package hot100;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
* 146. LRU缓存机制
* */

/*
* 方法 1：有序字典
想法

题目要求实现 LRU 缓存机制，需要在 O(1) 时间内完成如下操作：

获取键 / 检查键是否存在
设置键
删除最先插入的键
前两个操作可以用标准的哈希表在 O(1) 时间内完成。

有一种叫做有序字典的数据结构，综合了哈希表和链表，在 Python 中为 OrderedDict，
在 Java 中为 LinkedHashMap。
下面用这个数据结构来实现。
* */
public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.get(key);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }



}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */