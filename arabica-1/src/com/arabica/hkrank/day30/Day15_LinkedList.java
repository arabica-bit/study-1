package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 15일차 : Linked List
 * 노드의 next를 이용하여 계속 노드를 이어가야 함. 별 생각없이 진행하면 노드가 이어지지 않고 head와 마지막 노드만 남는 사례 발생.
 */
public class Day15_LinkedList {
    public static Node2 insert(Node2 head,int data) {
        //Complete this method
        //if head is null then return head
        //else find the last Node2 that has no pointer.
        if(head == null){
            head = new Node2(data);
            return head;
        }

        Node2 Node2 = head;
        while(Node2 != null){
            if(Node2.next == null){
                Node2.next = new Node2(data);
                break;
            }
            Node2 = Node2.next;
        }

        return head;
    }

    public static void display(Node2 head) {
        Node2 start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node2 head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}

//다른 코드와 겹쳐서 Node2로 이름 바꿈. 나중에 패키지로 처리할것..
class Node2 {
    int data;
    Node2 next;
    Node2(int d) {
        data = d;
        next = null;
    }
}

