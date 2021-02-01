package com.arabica.hktest;

import java.io.*;

/**
 * 숫자로 이루어진 문자열 입력은 ASCII 코드를 나타낸다.
 * 이를 해석하는 함수를 완성하기.
 * 각 코드는 2,3자로 구성되며 아스키특성상 연결된 문장은 항상 해석가능하다.
 * 입력: "1219950180111108236115111016623101401611235115012312161151110101111127"
 * 결과: "Honesty is the Best Policy"
 */
public class Nx_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtest.txt"));

        String encoded = bufferedReader.readLine();

        String result = Result_Nx_02.decode(encoded);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result_Nx_02 {

    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encoded as parameter.
     */

    public static String decode(String encoded) {
        // Write your code here
        StringBuffer resultBuffer = new StringBuffer();
        StringBuffer decodeBuffer = new StringBuffer();
        for(int i=encoded.length()-1; i>=0; i--){
            decodeBuffer.append(encoded.charAt(i));
            //디코드 버퍼에 2자이상 들어왔을 때.
            if(decodeBuffer.length() > 1) {
                String temp = getCharFromCode(decodeBuffer.toString());
                if(!temp.equals("0")){
                    //비교해본 값이 에러값이 아닐때, 결과 버퍼에 추가
                    resultBuffer.append(temp);
                    decodeBuffer.delete(0, decodeBuffer.length());
                }
            }
        }

        System.out.println(resultBuffer.toString());
        return resultBuffer.toString();
    }

    public static String getCharFromCode(String code){
        Integer numCode = Integer.parseInt(code);
        switch (numCode){
            case 32: return " ";
            case 65: return "A";
            case 66: return "B";
            case 67: return "C";
            case 68: return "D";
            case 69: return "E";
            case 70: return "F";
            case 71: return "G";
            case 72: return "H";
            case 73: return "I";
            case 74: return "J";
            case 75: return "K";
            case 76: return "L";
            case 77: return "M";
            case 78: return "N";
            case 79: return "O";
            case 80: return "P";
            case 81: return "Q";
            case 82: return "R";
            case 83: return "S";
            case 84: return "T";
            case 85: return "U";
            case 86: return "V";
            case 87: return "W";
            case 88: return "X";
            case 89: return "Y";
            case 90: return "Z";
            case 97: return "a";
            case 98: return "b";
            case 99: return "c";
            case 100: return "d";
            case 101: return "e";
            case 102: return "f";
            case 103: return "g";
            case 104: return "h";
            case 105: return "i";
            case 106: return "j";
            case 107: return "k";
            case 108: return "l";
            case 109: return "m";
            case 110: return "n";
            case 111: return "o";
            case 112: return "p";
            case 113: return "q";
            case 114: return "r";
            case 115: return "s";
            case 116: return "t";
            case 117: return "u";
            case 118: return "v";
            case 119: return "w";
            case 120: return "x";
            case 121: return "y";
            case 122: return "z";
            default: return "0";
        }
    }

}