package com.wd.leetcode;

//        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/add-two-numbers
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class AddTwoNumbers {

    public static void main(String[] arg0){
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_3 = new ListNode(3);
        listNode1_2.next = listNode1_4;
        listNode1_4.next = listNode1_3;

        ListNode listNode2_5 = new ListNode(5);
        ListNode listNode2_6 = new ListNode(6);
        ListNode listNode2_4 = new ListNode(4);
        listNode2_5.next = listNode2_6;
        listNode2_6.next = listNode2_4;

        System.out.println(listNode1_2);
        System.out.println(listNode2_5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode resListNode = addTwoNumbers.addTwoNumbers(listNode1_2,listNode2_5);
        System.out.println(resListNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode l11 = l1, l22 = l2,nowListNode = headNode;
        int carry = 0;
        while (l11 != null || l22!= null){
            int l1Val = l11 == null ? 0 : l11.val;
            int l2Val = l22 == null ? 0 : l22.val;
            int res = l1Val + l2Val+carry;
            carry = res/10;
            nowListNode.next = new ListNode(res %10);
            nowListNode = nowListNode.next;
            l11 = l11 == null ? null : l11.next;
            l22 = l22 == null ? null : l22.next;
        }
        if(carry>0){
            ListNode listNode = new ListNode(carry);
            nowListNode.next = listNode;
        }
        return headNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}