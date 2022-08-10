package com.example.helloworld;

import java.util.Arrays;

//Time Complexity O(log2N)
public class SortedMatrix {
    public static void main(String[] args) {

        int target=4;
        int[][] a={{1,2,3,4,5}};
        int index=(int)(a[0].length-1)/2;
        int[] ans=BSMatrix(a,0,a.length-1,index,target);

        if(ans[1]==index && a[ans[0]][ans[1]]==target)
            System.out.println(Arrays.toString(new int[]{ans[0], ans[1]}));
        else
        {
            int x=BS(a[ans[0]],0,a[ans[0]].length-1,target);
            int y=BS(a[ans[1]],0,a[ans[1]].length-1,target);

            if(x>=0)
                System.out.println(Arrays.toString(new int[]{ans[0],x}));
            else if(y>=0)
                System.out.println(Arrays.toString(new int[]{ans[1],y}));
            else
                System.out.println(Arrays.toString(new int[]{-1,-1}));

        }

    }
    static int[] BSMatrix(int[][] arr,int s,int e,int index,int target) {

        int ans=-1;
        if(s==0 && e==0)
            return new int[]{0,0};
        while (s+1 != e) {
            int mid = (int) (s + e) / 2;

            if (arr[mid][index]==target)
                return new int[]{mid,index};
            else if (arr[mid][index]<target)
                s =mid;
            else
                e = mid;
        }
        return new int[]{s,e};

    }
    static int BS(int[] arr,int s,int e,int t) {

        int ans=-1;
        while (s <= e) {
            int mid = (int) (s + e) / 2;

            if (arr[mid]==t)
                return mid;
            else if (t > arr[mid])
                s = mid + 1;
            else
                e = mid - 1;
        }
        return -1;

    }
}
