package com.epi.hashtables;

import java.util.*;

class Node{
    int data;
    Node prev;
    Node next;
    public Node(int data, Node prev, Node next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
public class ISBNCache {
    Map<String, Node> lru = new HashMap<>();
    Node head;
    Node tail;
    /**
     * Create a cache
     * implement lookup, insert, delete
     * LRU for cache eviction - delete should update the LRU
     * lookup - changes LRU element - get should update the LRU
     * insert - changes LRU element - add should update the LRU
     * lookup using key, therefore a key-value pair
     * @param key
     * @return
     */
    //Let us try to make everything O(1)
    public Integer lookup(String key){
        //hashmap get is O(1)
        Node value = lru.get(key);
        //make the key MRU
        if(value == tail){
            tail = value.prev;
        }
        value.prev.next = value.next;
        value.next = head;
        value.prev = null;
        head = value;
        return head.data;
    }

    public void insert(String key, Integer value){
        //linkedhashmap insert is O(1) - if we insert the element into the end
        //most recently used will be the head
        if(lru.containsKey(key)){
            lookup(key);
        } else {
            Node prev = null;
            Node next = head;
            head = new Node(value, prev,next);
            lru.put(key, head);
        }
    }

    public void remove(String key){
        Node value = lru.get(key);
        if(value == null)
            return;
        if(tail == value){
            tail = tail.prev;
        }
        value.prev.next = null;
        lru.remove(key);
    }
}
