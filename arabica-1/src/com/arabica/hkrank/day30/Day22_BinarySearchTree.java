package com.arabica.hkrank.day30;
import java.util.*;
import java.io.*;

/**
 * 30 days of code
 * 22일차 : 구성된 이진트리의 depth를 알아내기.
 * 이진탐색의 기본 구성은 재귀호출(root부터 탐색해가는 과정을 재귀적으로 반복하는 것이다 ->그림그려볼것)
 * 핵심은..왼쪽으로 끝까지 다 탐색, 그 후 오른쪽 끝까지 탐색해야 한다는 점이고 이를 위한 "if"문 구성을 잘 생각해야 함. (line 27)
 */
public class Day22_BinarySearchTree {

    public static int getHeight(Node root){
        //Write your code here
        return getNext(root, 0);

    }

    public static int getNext(Node root, int depth){
        int left,right;
        left=right=depth;
        System.out.println("Data["+root.data+"], depth["+depth+"]");
        if(root.left != null){
            left = getNext(root.left, depth+1);
        }
        //여기서 그냥 if 대신에 else if를 쓰면 오답이 나옴.
        if(root.right != null) {
            right = getNext(root.right, depth+1);
        }
        if(left > right) return left;
        else return right;
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }

}

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

