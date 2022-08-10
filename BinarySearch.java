package com.example.helloworld;

import java.util.Arrays;

//Time Complexity O(log2N)
public class BinarySearch {
    public static void main(String[] args) {

        int[] a={2,5,8,9,11,16,19,22,29,35,45,60,100};
        Arrays.sort(a);
        int t=25;
        int pos=0;
        if (t>=a[0] && t<=a[a.length-1]) {
            if (t <= a[a.length - 1] && t >= a[a.length - 2])
                System.out.println(a[a.length - 1]);
            else {
                pos = BS(a, 0, a.length - 1, t);
                System.out.println(a[pos]);
            }
        }
        else
        {
            System.out.println("Element does not exist in array");
        }
    }
    static int BS(int[] arr,int s,int e,int t){

        int mid=(int)(s+e)/2;

        if ((arr[mid]>=t && arr[mid-1]<=t)  )
            return mid;

        if (t > arr[mid])
            return BS(arr, mid, e, t);
        else if (t < arr[mid])
            return BS(arr, s, mid, t);

        return -1;
    }
}
