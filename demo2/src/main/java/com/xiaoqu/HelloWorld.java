package com.xiaoqu;

import org.testng.annotations.Test;

import java.util.Arrays;

public class HelloWorld {

    @Test
    public void testAlgorithm(){
        int[] nums ={44,55,33,88,99};
        int num=0;
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1; j<nums.length;j++){
               if (nums[i]>nums[j]){
                   num = nums[i];
                   nums[i] =nums[j];
                   nums[j]=num;
               }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testAlgo1(){
        int[] nums ={44,55,33,88,99};
        int num=0;
        for (int i = 0; i < nums.length; i++) {
            for(int j=0; j<nums.length-j-1;j++){
                if (nums[j]>nums[j+1]){
                    num = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=num;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
