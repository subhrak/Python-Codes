package com.example.helloworld;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
import java.util.Arrays;

//Time Complexity O(log2N)
public class SmallestLetterBS {
    public static void main(String[] args) {


        int[] a={2,2,2,2,2,6,6,6};
        Arrays.sort(a);
        int pos=0;
        int t=2;
        if(t>a[a.length-1])
            System.out.println(a[a.length-1]);
        else {
            pos = BS(a, 0, a.length - 1, t);
            System.out.println(a[pos]);
        }
    }
    static int BS(int[] arr,int s,int e,int t){

        int mid=(int)(s+e)/2;

        if(s==e+1)
            return s;

        if (t < arr[mid])
            return BS(arr, s, mid-1, t);
        else
            return BS(arr, mid+1,e, t);

    }
}
