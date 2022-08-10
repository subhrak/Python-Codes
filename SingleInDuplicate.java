package com.example.helloworld;

import java.util.Arrays;
//https://leetcode.com/problems/single-element-in-a-sorted-array/
//Time Complexity O(log2N)
public class SingleInDuplicate {
    public static void main(String[] args) {

        int[] a={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,10,10,11,11};
        int ans=BS(a,0,a.length-1);
        System.out.println(a[ans]);
    }
    static int BS(int[] arr,int s,int e) {

        if(arr[0]!=arr[1])
            return 0;
        else if(arr[arr.length-2]!=arr[arr.length-1])
            return arr.length-1;
        else {

            while (s <= e) {
                int mid = (int) (s + e) / 2;
                if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;

                else if (arr[mid + 1] == arr[mid] && mid % 2 == 0)
                    s = mid + 2;
                else if (arr[mid - 1] == arr[mid] && (mid - 1) % 2 == 0)
                    s = mid + 1;
                else if (arr[mid + 1] == arr[mid] && mid % 2 != 0)
                    e = mid - 1;
                else if (arr[mid - 1] == arr[mid] && (mid - 1) % 2 != 0)
                    e = mid - 2;

            }
        }
        return -1;
    }
}
