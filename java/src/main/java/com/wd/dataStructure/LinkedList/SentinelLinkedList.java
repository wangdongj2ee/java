package com.wd.dataStructure.LinkedList;

/**
 * 带哨兵节点的单链表
 */

public class SentinelLinkedList<T> {

    private Node<T> sentinelNode = new Node<T>();

    public void add(T t){
        Node<T> node = sentinelNode;
        while (node!=null){
            node = node.getNextNode();
        }
        Node<T> n = new Node<T>(t,null);
        node.setNextNode(n);
    }

    class Node<T> {

        public Node() {
        }

        public Node(T t, Node<T> nextNode) {
            this.t = t;
            this.nextNode = nextNode;
        }

        private T t;

        private Node<T> nextNode;//下个节点对象，如果为空，代表是当前链表最后一个节点

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
