package com.wjf.leetcode.addtwonumbers;

import java.math.BigInteger;

/**
 * description ：给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 *               将两数相加返回一个新的链表。
 *               你可以假设除了数字 0 之外，这两个数字都不会以零开头
 * @author : wjf
 * Date ：2018/10/11 10:44
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        long beginTime = System.currentTimeMillis();
        ListNode resultNode = addTwoNumbers(l1, l2);
        System.out.println("用时: " + (System.currentTimeMillis() - beginTime));
        while (resultNode != null) {
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println();
    }

    /**
     * 先把两个加数链表分别转为字符串，再反转后相加，然后再把相加结果倒序挨个加入待返回的链表
     * @param l1    链表1
     * @param l2    链表2
     * @return ListNode
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstListNode = null, e;
        StringBuilder l1Str = new StringBuilder();
        e = l1;
        do {
            l1Str.append(e.val);
        } while ((e = e.next) != null);
        StringBuilder l2Str = new StringBuilder();
        e = l2;
        do {
            l2Str.append(e.val);
        } while ((e = e.next) != null);
        BigInteger addend = new BigInteger(l1Str.reverse().toString());
        BigInteger summand = new BigInteger(l2Str.reverse().toString());
        BigInteger sum = addend.add(summand);
        char[] sumArray = sum.toString().toCharArray();
        for (int i = sumArray.length - 1; i >= 0; i--) {
            if(firstListNode == null){
                e = firstListNode = new ListNode(Integer.parseInt(String.valueOf(sumArray[i])));
            } else {
                e.next = new ListNode(Integer.parseInt(String.valueOf(sumArray[i])));
                e = e.next;
            }
        }
        return firstListNode;
    }
}
