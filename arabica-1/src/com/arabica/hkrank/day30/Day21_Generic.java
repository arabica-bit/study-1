package com.arabica.hkrank.day30;

import java.util.*;

/**
 * 30 days of code
 * 21일차 : generic 함수 작성
 * generic 형태의 배열을 출력하는 함수 작성.
 */
public class Day21_Generic <T>{

    void printArray(T[] input){
        for(Object obj: input){
            System.out.println(obj);
        }
    }
}
