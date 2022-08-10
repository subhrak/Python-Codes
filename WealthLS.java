package com.example.helloworld;
//https://leetcode.com/problems/richest-customer-wealth/
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WealthLS {
    public static void main(String[] args) {

        int[][] w= new int[][]{{1,2,3},{1,0,2},{1,4,6}};
        int money=WealthMax(w);
        System.out.println(money);

    }

    static int WealthMax(int[][] accounts){

        int x=0;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int[] customer:accounts)
        {
            int sum=0;
            for (int money: customer) {
                sum += money;
            }
            arr.add(sum);
        }
        return Collections.max(arr);
    }


}


