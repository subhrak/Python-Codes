package com.example.helloworld;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Scanner;

public class Helloworld {
    public static void main(String[] args) {

        int[] a= new int[]{12,345,7,5678};
        ArrayList<Integer> arr1=EvenDigits(a);
        System.out.println(arr1);

    }

    static ArrayList<Integer> EvenDigits(int[] a){

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            String str=String.valueOf(a[i]);
            if(str.toCharArray().length%2==0)
                arr.add(a[i]);
      }
        return arr;

    }


}


