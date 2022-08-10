package com.example.helloworld;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/#:~:text=Find%20Numbers%20with%20Even%20Number%20of%20Digits%20%2D%20LeetCode&text=Given%20an%20array%20nums%20of,(even%20number%20of%20digits).
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {

        int[] a= new int[]{-12,45,7,5678,0};
        int count=EvenDigits(a);
        System.out.println(count);

    }

    static int EvenDigits(int[] a){

        int x=0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){

            if(a[i]<0)
                x=a[i]*-1;
            else
                x=a[i];

            String str=String.valueOf(x);
            if(str.toCharArray().length%2==0)
                arr.add(a[i]);
        }
        return arr.size();

    }


}


