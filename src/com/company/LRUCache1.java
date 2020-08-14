package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache1(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {

            Node node = map.get(key);
            if (tail != node) {
                remove(node);
                add(node);
            }

            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);

            Node node1 = new Node();
            node1.key = key;
            node1.value = value;

            add(node1);
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;

            if (map.size() == capacity) {

                this.removeFirst(node);
            }
            add(node);
        }
    }

    private void remove(Node node) {

        if (node == head) {
            this.removeFirst(node);
        } else {
            node.previos.next = node.next;
            if (node.next != null) {
                node.next.previos = node.previos;
            }
            map.remove(node.key);
            node = null;
        }
    }

    private void add(Node node) {

        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.next = node;
            node.previos = tail;
        }

        tail = node;
        map.put(node.key, node);
    }

    private void removeFirst(Node node) {

        Node temp = head;
        head = head.next;
        if (head != null) {
            head.previos = null;
        } else {
            tail = null;
        }
        map.remove(temp.key);
        temp = null;
    }


    private static class Node {

        private Node previos;
        private Node next;
        private int key;
        private int value;
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);

        cache.put(2, 1);
        cache.put(3, 2);

        System.out.println(cache.get(3));
        System.out.println(cache.get(2));


        // 返回  1
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

