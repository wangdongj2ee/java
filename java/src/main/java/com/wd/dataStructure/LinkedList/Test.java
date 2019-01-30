package com.wd.dataStructure.LinkedList;

public class Test {

    public static void main(String[] arg0) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(6);
        singleLinkedList.add(3,7);
        singleLinkedList.display();
//        singleLinkedList.remove();
//        System.out.println("***********************************");
//        singleLinkedList.display();
    }
}
