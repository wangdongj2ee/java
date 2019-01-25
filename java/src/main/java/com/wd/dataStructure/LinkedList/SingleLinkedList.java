package com.wd.dataStructure.LinkedList;

/**
 * 单链表类
 */

public class SingleLinkedList<T> {

    private int size;

    //链表开始节点
    private Node<T> startNode;

    //链表结束节点
    private Node<T> endNode;


    private Node<T> temporaryNode;

    public void add(T t) {
        Node<T> node = new Node<T>(t, null);
        if (startNode == null) {
            startNode = node;
            endNode = node;
        } else {
            endNode.setNextNode(node);
            endNode = node;
        }
        size++;
    }

    public T remove() {
        T t = null;
        if (startNode == null) {
            return t;
        }
        if(startNode.getNextNode() == null){
            t = startNode.getT();
            startNode = null;
            return t;
        }
        Node<T> prevNode = null,
                node = startNode;
        while (node!=null){
            prevNode = node;
            node = node.getNextNode();
        }
        t = prevNode.getT();
        return t;
    }

    public boolean hasNext() {
//        if (temporaryNode == null) {
//            temporaryNode = startNode;
//        }
        if(startNode == null){
            return false;
        }else {
            if(temporaryNode == null){
                temporaryNode = startNode;
            }
        }
        return temporaryNode != null;
    }

    public T next() {
        if (temporaryNode == null) {
            throw new NullPointerException();
        }
        T t = temporaryNode.getT();
        temporaryNode = temporaryNode.getNextNode();
        return t;
    }

    public void display() {
        if (startNode != null) {
            Node<T> node = startNode;
            while (node != null) {
                System.out.println(node.getT());
                node = node.getNextNode();
            }
        }
    }


    /**
     * 链表节点类
     *
     * @param <T>
     */
    class Node<T> {
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
