package com.example.helloworld;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
import java.util.Arrays;

//Time Complexity O(log2N)
public class FirstLastBS {
    public static void main(String[] args) {
        int[] ans = {};
        int[] a = {1};
        int t = 1;
        int pos1 = search(a, 0, a.length - 1, t,1);
        int pos2 = search(a, 0, a.length - 1, t,-1);
        System.out.println(pos1);
        System.out.println(pos2);

    }

    static int search(int[] arr, int s, int e, int t,int find) {

        int ans=-1;
        int mid = 0;
        while (s <= e) {
            mid = e - (e - s) / 2;

            if (t > arr[mid])
                s = mid + 1;
            else if (t < arr[mid])
                e = mid - 1;
            else {
                ans=mid;
                if(find==1)
                    e=mid-1;
                else
                    s=mid+1;
            }
        }
        return ans;
    }
}




