package com.example.helloworld;

import java.util.Arrays;

//Time Complexity O(log2N)
public class SpecialArray {
    public static void main(String[] args) {

        int[] a={0,4,3,0,4,5,7,0,0,0};
        int ans=BS(a,1,a.length);
        System.out.println(ans);
    }

    static int countMax(int[] arr,int mid)
    {
        int count=0;
        for(int i:arr)
        {
            if(i>=mid)
                count++;
        }
        return count;

    }
    static int BS(int[] arr,int s,int e) {

        while (s <= e) {
            int mid = (int) (s + e) / 2;
            int ans = countMax(arr, mid);

            if (mid == ans)
                return mid;
            else if (ans > mid)
                s = mid + 1;
            else
                e = mid - 1;
        }
            return -1;

    }
}
