package edu.zju.algorithm.base.datastructure.list;

import edu.zju.algorithm.util.ListNode;

/**
 * ������ز���
 */
public class List {

    /**
     * ������ - ��randomָ����������
     * @param head ����ͷ�ڵ�
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
     * ����ת - ʹ�þ����ٵĶ���ռ�
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
     * �������л�
     * @param head ����ͷ�ڵ�
     * @return �Ƿ���ڻ�
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
     * �������һ���� - ����1
     * @param head ����ͷ�ڵ�
     * @return ����ڽڵ�
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
     * �������һ���� - ����2
     * @param head ����ͷ�ڵ�
     * @return ����ڽڵ�
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
