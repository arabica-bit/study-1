package com.arabica.hkrank.day30;

import java.io.*;
import java.util.*;

/**
 * 30 days of code
 * 18일차: Queues and Stacks
 * Queue, Stack 사용해보기.
 */
public class Day18_QueueAndStack {
    // Write your code here.
    Stack<Character> stack;
    Queue<Character> queue;
    void pushCharacter(char c){
        if(stack == null || stack.isEmpty()) stack = new Stack<>();
        stack.push(c);
    }
    char popCharacter(){
        return stack.pop();
    }
    void enqueueCharacter(char c){
        if(queue == null || queue.isEmpty()) queue = new LinkedList<>();
        queue.add(c);
    }
    char dequeueCharacter(){
        return queue.poll();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18_QueueAndStack p = new Day18_QueueAndStack();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
