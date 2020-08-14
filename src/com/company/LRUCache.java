package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        //System.out.print("get key:" + key);
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

                this.removeFirst();
            }
            add(node);
        }

        /*System.out.println("put key: " + key + " value: " + value );
        Node node = head;
        while (node.next != null) {
            System.out.printf("%d:%d    ", node.key, node.value);
            node = node.next;
        }*/
    }

    private void remove(Node node) {

        if (node == head) {
            this.removeFirst();
        } else if (node == tail) {
            tail = node.previos;
            tail.next = null;
            map.remove(node.key);
            node = null;
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

    private void removeFirst() {

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
        LRUCache cache = new LRUCache(10);

        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        cache.get(13);
        cache.put(2,19);
        cache.get(2);
        cache.get(3);
        cache.put(5,25);
        cache.get(8);
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        cache.get(11);
        cache.put(9,12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4,30);
        cache.put(9,3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6,14);
        cache.put(3,1);
        cache.get(3);
        cache.put(10,11);
        cache.get(8);
        cache.put(2,14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11,4);
        cache.put(12,24);
        cache.put(5,18);
        cache.get(13);
        cache.put(7,23);
        cache.get(8);
        cache.get(12);
        cache.put(3,27);
        cache.put(2,12);
        cache.get(5);
        cache.put(2,9);
        cache.put(13,4);
        cache.put(8,18);
        cache.put(1,7);
        cache.get(6);
        cache.put(9,29);
        cache.put(8,21);
        cache.get(5);
        cache.put(6,30);
        cache.put(1,12);
        cache.get(10);
        cache.put(4,15);
        cache.put(7,22);
        cache.put(11,26);
        cache.put(8,17);
        cache.put(9,29);
        cache.get(5);
        cache.put(3,4);
        cache.put(11,30);
        cache.get(12);
        cache.put(4,29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3,4);
        cache.get(1);
        cache.get(10);
        cache.put(3,29);
        cache.put(10,28);
        cache.put(1,20);
        cache.put(11,13);
        cache.get(3);
        cache.put(3,12);
        cache.put(3,8);
        cache.put(10,9);
        cache.put(3,26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13,17);
        cache.put(2,27);
        cache.put(11,15);
        cache.get(12);
        cache.put(9,19);
        cache.put(2,15);
        cache.put(3,16);
        cache.get(1);
        cache.put(12,17);
        cache.put(9,1);
        cache.put(6,19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8,1);
        cache.put(11,7);
        cache.put(5,2);
        cache.put(9,28);
        cache.get(1);
        cache.put(2,2);
        cache.put(7,4);
        cache.put(4,22);
        cache.put(7,24);
        cache.put(9,26);
        cache.put(13,28);
        cache.put(11,26);

    }
}

