package com.example.helloworld;

import java.util.Arrays;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
//Time Complexity O(log2N)
public class MinmRA {
    public static void main(String[] args) {


        int[] a={11,13,15,17};
        int ans = rotate1(a, 0, a.length - 1);


        if(ans>0)
            System.out.println(a[ans]);
        else
            System.out.println(a[0]);;

    }

    static int rotate1(int[] arr,int s,int e){
        if(arr.length==1)
            return 0;
        int mid=0;
        int ans=-1;
        while(s<=e) {
            mid=(int)(s+e)/2;
            if (mid>=s && arr[mid]>arr[mid+1])
            {   ans=mid+1;
                break;
            }
            else if(arr.length==2)
                break;
            else if (mid<=e && arr[mid]<arr[mid-1] )
            {   ans=mid;
                break;
            }
            else if(arr[s]>arr[mid])
                e=mid;
            else if(arr[s]<arr[mid])
                s=mid;
            else
                break;
        }
        return ans;

    }


}
