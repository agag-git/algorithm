package edu.zju.algorithm.base.datastructure.list;

import edu.zju.algorithm.util.ListNode;

/**
 * 链表相关操作
 */
public class List {

    /**
     * 链表复制 - 带random指针的链表深拷贝
     * @param head 链表头节点
     */
    public ListNode copyList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        ListNode res = head.next;
        node = head;
        while (node != null) {
            node.next.random = node.random.next;
            node = node.next.next;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1 != null) {
            node1.next = node2.next;
            node1 = node1.next;
            node2.next = node1.next;
            node2 = node2.next;
        }
        return res;
    }

    /**
     * 链表反转 - 使用尽量少的额外空间
     * @param head
     */
    public void revertList(ListNode head) {
        ListNode node = head.next;
        ListNode nextNode = null;
        while (node != null) {
            nextNode = node.next;
            node.next = head;
            head = node;
            node = nextNode;
        }
        return;
    }

    /**
     * 单链表判环
     * @param head 链表头节点
     * @return 是否存在环
     */
    public boolean hasLoop(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        boolean res = false;
        while (true) {
            if (node2 == null || node2.next == null) {
                break;
            }
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 单链表找环起点 - 方法1
     * @param head 链表头节点
     * @return 环入口节点
     */
    public ListNode loopNode1(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (true) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                node1 = head;
                break;
            }
        }
        while (true) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
    }

    /**
     * 单链表找环起点 - 方法2
     * @param head 链表头节点
     * @return 环入口节点
     */
    public ListNode loopNode2(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode meet = null;
        while (true) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                meet = node1;
                node1 = head;
                break;
            }
        }
        int disDiff = 0;
        while (true) {
            node1 = node1.next;
            node2 = node2.next;
            if (node2 == meet) {
                break;
            }
        }
        while (node1 != meet) {
            node1 = node1.next;
            disDiff++;
        }
        node1 = head;
        while (disDiff-- != 0) {
            node1 = node1.next;
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

}
