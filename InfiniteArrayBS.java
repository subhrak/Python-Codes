package com.example.helloworld;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
import java.util.Arrays;

//Time Complexity O(log2N)
public class InfiniteArrayBS {
    public static void main(String[] args) {
        int[] ans = {};
        int[] a = {3,4,5,6,7,8,9,11,24,33,67,89};
        int t=67;
        int s=0;
        int end=1;

        while(t>a[end]) {
            s=end;
            end = end * 2;
        }


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




