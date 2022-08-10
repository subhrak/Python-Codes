package com.example.helloworld;

import java.util.Arrays;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//Time Complexity O(log2N)
public class PeakArray {
    public static void main(String[] args) {

        int[] a={1,2,3,4,5,3,1};
        int ans=peak(a,0,a.length-1);
        System.out.println(a[ans]);

        int SI=BSStartIndex(a,4,0,ans);
        int EI=BSEndIndex(a,4,ans,a.length-1);
        System.out.println(SI);
        System.out.println(EI);

        if(SI>=0 && EI>=0)
            System.out.println(SI);
        else if(SI<0 && EI<0)
            System.out.println(-1);
        else if (SI>=0 && EI==-1)
            System.out.println(SI);
        else
            System.out.println(EI);

    }
    static int peak(int[] arr,int s,int e){
        int mid=0;
        while(s<=e) {
            mid=(int)(s+e)/2;
            if (arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                break;
            else if (arr[mid]>arr[mid+1])
                e=mid;
            else if (arr[mid]<arr[mid+1])
                s=mid;
        }
        return mid;

    }

    static int BSStartIndex(int[] arr,int t,int s,int e)
    {
        int ans=-1;

        while(s<=e)
        {
            int mid=(int)(s+e)/2;

            if(t>arr[mid])
                s=mid+1;
            else if(t<arr[mid])
                e=mid-1;
            else {
                ans = mid;
                break;
            }
        }
        return ans;

    }

    static int BSEndIndex(int[] arr,int t,int s,int e)
    {
        int ans=-1;

        while(s<=e)
        {
            int mid=(int)(s+e)/2;

            if(t>arr[mid])
                e=mid-1;
            else if(t<arr[mid])
                s=mid+1;
            else {
                ans = mid;
                break;
            }
        }
        return ans;

    }
}
