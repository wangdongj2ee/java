package com.wd.dataStructure.LinkedList;

import java.util.Iterator;

/**
 * 单链表类
 */

public class SingleLinkedList<T> implements Iterator<T>{

    private int size = 0;

    //链表开始节点
    private Node<T> startNode;

    //链表结束节点
    private Node<T> endNode;


    private Node<T> temporaryNode;

    private boolean isDisplay = false;

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

    public void addHead(T t) {
        Node<T> node = new Node<T>(t, null);
        if (startNode == null) {
            startNode = node;
            endNode = node;
        } else {
            node.setNextNode(startNode);
            startNode = node;
        }
        size++;
    }

    public void add(Integer index,T t) {
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("index:"+index+";size"+size);
        }
        if(index == 0){
            addHead(t);
        }else if(index == size){
            add(t);
        }else{
            Node<T> node = startNode;
            int i = 0;
            int j = index-1;
            while (i != j) {
                node = node.getNextNode();
                i++;
            }
            Node<T> n = new Node<T>(t,node.getNextNode());
            node.setNextNode(n);
            size++;
        }
    }

    public void remove() {
        if(startNode == null){
            return;
        }
        if(startNode.getNextNode() == null){
            startNode = null;
            size =0;
            return;
        }
        int i=0;
        int j = size - 2;
        Node<T> node = startNode;
        while (i!=j){
            node = node.getNextNode();
            i++;
        }
        node.setNextNode(null);
        size--;
    }

    public void removeHead() {
        if(startNode == null){
            return;
        }
        startNode = startNode.getNextNode();
        size--;
    }

    public void remove(Integer index){
        if(startNode == null){
            return;
        }
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("index:"+index+";size"+size);
        }
        if(index == 0){
            removeHead();
        }else if(index == size){
            remove();
        }else{
            Node<T> node = startNode;
            int i = 0;
            while (i!=index){
                node = node.getNextNode();
                i++;
            }
            node.setT(node.getNextNode().getT());
            node.setNextNode(node.getNextNode().getNextNode());
            size--;
        }
    }

    public T get(Integer index){
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("index:"+index+";size"+size);
        }
        if(index == 0){
            return startNode.getT();
        }else if(index == size){
            return endNode.getT();
        }else{
            Node<T> node = startNode;
            int i = 0;
            while (i!=index){
                node = node.getNextNode();
                i++;
            }
            return node.getT();
        }
    }

    public boolean hasNext() {
        if(startNode == null){
            return false;
        }
        if(temporaryNode == null && !isDisplay){//开始遍历
            isDisplay = true;
            temporaryNode = startNode;
        }else if(temporaryNode == null && isDisplay){//遍历结束
            isDisplay = false;
            return false;
        }
        return true;
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
            int i=0;
            while (node != null) {
                System.out.println(node.getT());
//                System.out.println("i="+(++i));
                node = node.getNextNode();
            }
        }
    }

    public int getSize() {
        return size;
    }

//    public void setSize(int size) {
//        this.size = size;
//    }

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
