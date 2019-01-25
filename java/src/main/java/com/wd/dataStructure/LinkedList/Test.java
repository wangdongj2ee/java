package com.wd.dataStructure.LinkedList;

import java.util.Iterator;

public class Test {

    public static void main(String[] arg0){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(6);
        singleLinkedList.display();
        System.out.println("***********************************");
        while (singleLinkedList.hasNext()){
            System.out.println(singleLinkedList.next());
        }
        System.out.println("***********************************");
        singleLinkedList.remove();
        singleLinkedList.display();
        System.out.println(singleLinkedList);
    }
}
