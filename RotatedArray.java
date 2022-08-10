package com.example.helloworld;

import java.util.Arrays;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
//Time Complexity O(log2N)
public class RotatedArray {
    public static void main(String[] args) {

        int target=0;
        int[] a={2,1};
        int t=1;
        if(a.length==1)
            t=BinarySearch(a,0,a.length-1,target);
        else {
            int ans = rotate1(a, 0, a.length - 1);
            int x=ans;
            if(ans==-1){
                x = BinarySearch(a, 0, a.length - 1, target);
                t=x;}
            else
            {
                int y=BinarySearch(a,x,a.length-1,target);
                int z=BinarySearch(a,0,x-1,target);

                if(y>=0)
                    t=y;
                else if(z>=0)
                    t=z;
                else
                    t=-1;
            }

        }

        System.out.println(t);


    }
    static int rotate1(int[] arr,int s,int e){
        int mid=0;
        int ans=-1;
        while(s<=e && s!=(e-1)) {
            mid=(int)(s+e)/2;
            if (arr[mid]>arr[mid+1])
            {   ans=mid+1;
                break;
            }
            else if(arr.length==2)
                break;
            else if (arr[mid]<arr[mid-1] )
            {   ans=mid;
                break;
            }
            else if(arr[s]>arr[mid])
                e=mid;
            else
                s=mid;
        }
            return ans;

    }

    static int BinarySearch(int[] arr,int s,int e,int t){

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

}
