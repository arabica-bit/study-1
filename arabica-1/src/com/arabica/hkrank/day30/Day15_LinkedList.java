package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 15일차 : Linked List
 * 노드의 next를 이용하여 계속 노드를 이어가야 함. 별 생각없이 진행하면 노드가 이어지지 않고 head와 마지막 노드만 남는 사례 발생.
 */
public class Day15_LinkedList {
    public static Node insert(Node head,int data) {
        //Complete this method
        //if head is null then return head
        //else find the last node that has no pointer.
        if(head == null){
            head = new Node(data);
            return head;
        }

        Node node = head;
        while(node != null){
            if(node.next == null){
                node.next = new Node(data);
                break;
            }
            node = node.next;
        }

        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

